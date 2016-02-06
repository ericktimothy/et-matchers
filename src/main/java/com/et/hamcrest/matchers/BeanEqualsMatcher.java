package com.et.hamcrest.matchers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.StringDescription;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BeanEqualsMatcher<T> extends BaseMatcher<T> {

    private T expected;

    public BeanEqualsMatcher(T expected) {

        this.expected = expected;
    }

    @Override
    public boolean matches(Object actual) {

        StringDescription expectedDescription = new StringDescription();
        prettyPrint(expected, expectedDescription, 0);

        StringDescription actualDescription = new StringDescription();
        prettyPrint(actual, actualDescription, 0);

        return expectedDescription.toString().equals(actualDescription.toString());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("\n");
        prettyPrint(expected, description, 0);
    }

    @Override
    public void describeMismatch(Object item, Description description) {
        description.appendText("was \n");
        prettyPrint(item, description, 0);
    }


    private void prettyPrint(Object object, Description description, int lvl) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        description.appendText(gson.toJson(object));
    }


}
