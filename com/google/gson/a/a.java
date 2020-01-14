package com.google.gson.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface a {
    boolean dzm() default true;

    boolean dzn() default true;
}
