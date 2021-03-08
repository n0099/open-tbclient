package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes4.dex */
public abstract class b {
    private static final b pWg;

    public abstract void c(AccessibleObject accessibleObject);

    static {
        pWg = com.google.gson.internal.c.eBq() < 9 ? new a() : new c();
    }

    public static b eBX() {
        return pWg;
    }
}
