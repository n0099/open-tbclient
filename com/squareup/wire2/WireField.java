package com.squareup.wire2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface WireField {
    String dGt() default "";

    String dGu();

    Label dGv() default Label.OPTIONAL;

    boolean dGw() default false;

    int tag();

    /* loaded from: classes.dex */
    public enum Label {
        REQUIRED,
        OPTIONAL,
        REPEATED,
        ONE_OF,
        PACKED;

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isPacked() {
            return this == PACKED;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isOneOf() {
            return this == ONE_OF;
        }
    }
}
