package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes17.dex */
public abstract class b {
    private static final b oWw;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        oWw = com.google.gson.internal.c.eoU() < 9 ? new a() : new c();
    }

    public static b epx() {
        return oWw;
    }
}
