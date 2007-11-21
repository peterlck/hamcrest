/*  Copyright (c) 2000-2006 hamcrest.org
 */
package org.hamcrest.core;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.hamcrest.core.IsNot.not;
import org.hamcrest.AbstractMatcherTest;
import org.hamcrest.Matcher;
import static org.hamcrest.MatcherAssert.assertThat;


public class IsSameTest extends AbstractMatcherTest {

    protected Matcher<?> createMatcher() {
        return sameInstance("irrelevant");
    }

    public void testEvaluatesToTrueIfArgumentIsReferenceToASpecifiedObject() {
        Object o1 = new Object();
        Object o2 = new Object();

        assertThat(o1, sameInstance(o1));
        assertThat(o2, not(sameInstance(o1)));
    }

    public void testReturnsReadableDescriptionFromToString() {
        assertDescription("same(\"ARG\")", sameInstance("ARG"));
    }

    public void testReturnsReadableDescriptionFromToStringWhenInitialisedWithNull() {
        assertDescription("same(null)", sameInstance(null));
    }
}
