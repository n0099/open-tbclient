package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes4.dex */
public abstract class b {
    private static final b pKL;

    public abstract void c(AccessibleObject accessibleObject);

    static {
        pKL = com.google.gson.internal.c.eyK() < 9 ? new a() : new c();
    }

    public static b ezr() {
        return pKL;
    }
}
