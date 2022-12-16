package com.kwad.sdk.api.core;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Keep
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes8.dex */
public @interface KsAdSdkDynamicApi {
    String value() default "";
}
