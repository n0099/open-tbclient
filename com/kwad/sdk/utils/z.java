package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class z {
    public static <T> T a(T t) {
        if (t == null) {
            com.kwad.sdk.core.d.a.a(new NullPointerException());
        }
        return t;
    }

    public static <T> T a(T t, @Nullable Object obj) {
        if (t == null) {
            com.kwad.sdk.core.d.a.a(new NullPointerException(String.valueOf(obj)));
        }
        return t;
    }
}
