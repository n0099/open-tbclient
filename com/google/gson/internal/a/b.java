package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes17.dex */
public abstract class b {
    private static final b ofh;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        ofh = com.google.gson.internal.c.eeU() < 9 ? new a() : new c();
    }

    public static b efx() {
        return ofh;
    }
}
