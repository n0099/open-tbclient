package org.aspectj.lang.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes8.dex */
public @interface SuppressAjWarnings {
    String[] value() default {""};
}
