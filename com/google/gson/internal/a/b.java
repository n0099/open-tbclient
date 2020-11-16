package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes5.dex */
public abstract class b {
    private static final b phu;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        phu = com.google.gson.internal.c.esJ() < 9 ? new a() : new c();
    }

    public static b etm() {
        return phu;
    }
}
