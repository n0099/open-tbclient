package com.squareup.wire2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes6.dex */
public @interface WireField {

    /* loaded from: classes6.dex */
    public enum Label {
        REQUIRED,
        OPTIONAL,
        REPEATED,
        ONE_OF,
        PACKED;

        public boolean isOneOf() {
            return this == ONE_OF;
        }

        public boolean isPacked() {
            return this == PACKED;
        }

        public boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }
    }

    String adapter();

    String keyAdapter() default "";

    Label label() default Label.OPTIONAL;

    boolean redacted() default false;

    int tag();
}
