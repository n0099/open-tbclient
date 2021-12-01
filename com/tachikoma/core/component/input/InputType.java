package com.tachikoma.core.component.input;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes2.dex */
public @interface InputType {
    public static final String DEFAULT = "default";
    public static final String EMAIL = "email";
    public static final String NUMBER = "number";
    public static final String PASSWORD = "password";
    public static final String TEL = "tel";
}
