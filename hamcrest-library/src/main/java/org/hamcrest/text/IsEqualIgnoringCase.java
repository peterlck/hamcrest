/*  Copyright (c) 2000-2006 hamcrest.org
 */
package org.hamcrest.text;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Factory;
import org.hamcrest.core.StringMatcher;

/**
 * Tests if a string is equal to another string, regardless of the case.
 */
public class IsEqualIgnoringCase extends StringMatcher {

    // TODO: Replace String with CharSequence to allow for easy interopability between
    //       String, StringBuffer, StringBuilder, CharBuffer, etc (joe).

    private final String string;

    public IsEqualIgnoringCase(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Non-null value required by IsEqualIgnoringCase()");
        }
        this.string = string;
    }

    @Override
    public boolean matchesSafely(String item, Description mismatchDescription) {
        if (!string.equalsIgnoreCase(item)) {
          mismatchDescription.appendText("was ").appendText(item);
          return false;
        }
        return true;
    }

    public void describeTo(Description description) {
        description.appendText("equalToIgnoringCase(")
                .appendValue(string)
                .appendText(")");
    }

    @Factory
    public static Matcher<String> equalToIgnoringCase(String string) {
        return new IsEqualIgnoringCase(string);
    }

}
