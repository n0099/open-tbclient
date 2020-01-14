package com.google.gson.internal.b;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes5.dex */
public abstract class b {
    private static final b mMA;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        mMA = d.dzw() < 9 ? new a() : new c();
    }

    public static b dAb() {
        return mMA;
    }
}
