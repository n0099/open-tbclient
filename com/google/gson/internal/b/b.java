package com.google.gson.internal.b;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes4.dex */
public abstract class b {
    private static final b mIH;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        mIH = d.dyl() < 9 ? new a() : new c();
    }

    public static b dyU() {
        return mIH;
    }
}
