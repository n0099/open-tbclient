package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes5.dex */
public abstract class b {
    private static final b pNE;

    public abstract void c(AccessibleObject accessibleObject);

    static {
        pNE = com.google.gson.internal.c.eBY() < 9 ? new a() : new c();
    }

    public static b eCF() {
        return pNE;
    }
}
