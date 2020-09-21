package com.google.gson.internal.a;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes23.dex */
public abstract class b {
    private static final b nPO;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        nPO = com.google.gson.internal.c.ebj() < 9 ? new a() : new c();
    }

    public static b ebM() {
        return nPO;
    }
}
