package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes5.dex */
public abstract class b {
    private static final b pPm;

    public abstract void c(AccessibleObject accessibleObject);

    static {
        pPm = com.google.gson.internal.c.eCC() < 9 ? new a() : new c();
    }

    public static b eDj() {
        return pPm;
    }
}
