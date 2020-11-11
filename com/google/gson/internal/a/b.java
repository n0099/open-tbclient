package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes17.dex */
public abstract class b {
    private static final b pfR;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        pfR = com.google.gson.internal.c.esJ() < 9 ? new a() : new c();
    }

    public static b etm() {
        return pfR;
    }
}
