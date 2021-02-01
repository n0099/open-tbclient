package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes5.dex */
public abstract class b {
    private static final b pUR;

    public abstract void c(AccessibleObject accessibleObject);

    static {
        pUR = com.google.gson.internal.c.eBc() < 9 ? new a() : new c();
    }

    public static b eBJ() {
        return pUR;
    }
}
