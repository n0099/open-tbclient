package com.google.gson.internal.b;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes5.dex */
public abstract class b {
    private static final b mMv;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        mMv = d.dzu() < 9 ? new a() : new c();
    }

    public static b dzZ() {
        return mMv;
    }
}
