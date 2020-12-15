package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes5.dex */
public abstract class b {
    private static final b pwF;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        pwF = com.google.gson.internal.c.eym() < 9 ? new a() : new c();
    }

    public static b eyT() {
        return pwF;
    }
}
