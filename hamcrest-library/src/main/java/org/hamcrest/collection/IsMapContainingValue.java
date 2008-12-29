package org.hamcrest.collection;

import static org.hamcrest.core.IsEqual.equalTo;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import java.util.Map;

public class IsMapContainingValue<V> extends MapMatcher<Map<?, V>>{
    private final Matcher<? super V> valueMatcher;

    public IsMapContainingValue(Matcher<? super V> valueMatcher) {
        this.valueMatcher = valueMatcher;
    }

    @Override
    public boolean matchesSafely(Map<?, V> item, Description mismatchDescription) {  
        for (V value : item.values()) {
            if (valueMatcher.matches(value)) {
                return true;
            }
        }
        mismatchDescription.appendText("map was ").appendValueList("[", ", ", "]", item.entrySet());
        return false;
    }

    public void describeTo(Description description) {
        description.appendText("map with value ")
                   .appendDescriptionOf(valueMatcher);
    }

    @Factory
    public static <V> Matcher<? super Map<?,V>> hasValue(V value) {
        return IsMapContainingValue.<V>hasValue(equalTo(value));
    }

    @Factory
    public static <V> Matcher<? super Map<?,V>> hasValue(Matcher<? super V> valueMatcher) {
        return new IsMapContainingValue<V>(valueMatcher);
    }
}
