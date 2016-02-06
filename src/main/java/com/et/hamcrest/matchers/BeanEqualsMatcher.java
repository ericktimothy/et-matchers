package com.et.hamcrest.matchers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.StringDescription;

public class BeanEqualsMatcher<T> extends BaseMatcher<T> {

    private T expected;

    public BeanEqualsMatcher(T expected) {

        this.expected = expected;
    }

    @Override
    public boolean matches(Object actual) {

        StringDescription expectedDescription = new StringDescription();
        prettyPrint(expected, expectedDescription);

        StringDescription actualDescription = new StringDescription();
        prettyPrint(actual, actualDescription);

        return expectedDescription.toString().equals(actualDescription.toString());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("\n");
        prettyPrint(expected, description);
    }

    @Override
    public void describeMismatch(Object item, Description description) {
        description.appendText("was \n");
        prettyPrint(item, description);
    }


    private void prettyPrint(Object object, Description description) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        description.appendText(gson.toJson(object));
    }


}
