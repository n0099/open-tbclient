package com.google.gson.internal;
/* loaded from: classes.dex */
public final class a {
    public static Object a(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
