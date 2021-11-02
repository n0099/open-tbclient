package com.kwad.sdk.api.core;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@KsAdSdkDynamicApi
@Keep
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface KsAdSdkDynamicImpl {
    Class<?> value();
}
