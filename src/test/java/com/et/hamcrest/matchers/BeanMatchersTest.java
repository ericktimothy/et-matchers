package com.et.hamcrest.matchers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.et.hamcrest.matchers.BeanMatchers.beanEquals;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by etimothy on 6/02/2016.
 */
public class BeanMatchersTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testBeanEqualsMatcher_equal() throws Exception {
        Bean bean1 = new Bean();
        bean1.setField1("A");

        Bean bean2 = new Bean();
        bean2.setField1("A");

        assertThat(bean1, beanEquals(bean2));

    }

    @Test
    public void testBeanEqualsMatcher_equal_collection() throws Exception {
        Bean bean1 = new Bean();
        bean1.setField1("A");
        Bean child1 = new Bean();
        child1.setField1("1");
        bean1.getChildBeans().add(child1);

        Bean bean2 = new Bean();
        bean2.setField1("A");
        Bean child2 = new Bean();
        child2.setField1("1");
        bean2.getChildBeans().add(child2);

        assertThat(bean1, beanEquals(bean2));

    }

    @Test
    public void testBeanEqualsMatcher_notEqual() throws Exception {
        Bean bean1 = new Bean();
        bean1.setField1("A");

        Bean bean2 = new Bean();
        bean2.setField1("b");

        assertThat(bean1, not(beanEquals(bean2)));
    }

    @Test
    public void testBeanEqualsMatcher_notEqual_collection() throws Exception {
        Bean bean1 = new Bean();
        bean1.setField1("A");
        Bean child1 = new Bean();
        child1.setField1("1");
        bean1.getChildBeans().add(child1);

        Bean bean2 = new Bean();
        bean2.setField1("A");
        Bean child2 = new Bean();
        child2.setField1("2");
        bean2.getChildBeans().add(child2);

        assertThat(bean1, not(beanEquals(bean2)));

    }

    @Test
    public void testBeanEqualsMatcher_null() throws Exception {
        Bean bean1 = new Bean();
        bean1.setField1(null);

        Bean bean2 = new Bean();
        bean2.setField1(null);

        assertThat(bean1, beanEquals(bean2));
    }

    private class Bean {
        private String field1;
        private List<Bean> childBeans = new ArrayList<Bean>();

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public List<Bean> getChildBeans() {
            return childBeans;
        }

        public void setChildBeans(List<Bean> childBeans) {
            this.childBeans = childBeans;
        }
    }
}