package com.et.hamcrest.matchers;

import org.hamcrest.Matcher;


public class BeanMatchers {

    public static <T> Matcher<T> beanEquals(final T bean) {
        return new BeanEqualsMatcher<T>(bean);
    }
}
