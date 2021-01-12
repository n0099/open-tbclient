package com.squareup.wire2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface WireField {
    String eBw() default "";

    String eBx();

    Label eBy() default Label.OPTIONAL;

    boolean eBz() default false;

    int tag();

    /* loaded from: classes5.dex */
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
