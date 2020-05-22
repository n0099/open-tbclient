package com.google.gson.internal.b;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes7.dex */
public abstract class b {
    private static final b mFI;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        mFI = d.dCL() < 9 ? new a() : new c();
    }

    public static b dDo() {
        return mFI;
    }
}
