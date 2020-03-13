package com.google.gson.internal.b;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes7.dex */
public abstract class b {
    private static final b mNq;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        mNq = d.dAH() < 9 ? new a() : new c();
    }

    public static b dBk() {
        return mNq;
    }
}
