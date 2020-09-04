package com.google.gson.internal.b;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes3.dex */
public abstract class b {
    private static final b nFS;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        nFS = d.dXl() < 9 ? new a() : new c();
    }

    public static b dXO() {
        return nFS;
    }
}
