package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes5.dex */
public abstract class b {
    private static final b pwD;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        pwD = com.google.gson.internal.c.eyl() < 9 ? new a() : new c();
    }

    public static b eyS() {
        return pwD;
    }
}
