package com.google.gson.internal.b;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes7.dex */
public abstract class b {
    private static final b mOW;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        mOW = d.dBe() < 9 ? new a() : new c();
    }

    public static b dBH() {
        return mOW;
    }
}
