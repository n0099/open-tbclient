package com.tachikoma.core.component.input;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes2.dex */
public @interface ReturnKeyType {
    public static final String DONE = "done";
    public static final String GO = "go";
    public static final String NEXT = "next";
    public static final String SEARCH = "search";
    public static final String SEND = "send";
}
