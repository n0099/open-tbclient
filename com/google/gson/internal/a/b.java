package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes5.dex */
public abstract class b {
    private static final b pVr;

    public abstract void c(AccessibleObject accessibleObject);

    static {
        pVr = com.google.gson.internal.c.eBk() < 9 ? new a() : new c();
    }

    public static b eBR() {
        return pVr;
    }
}
