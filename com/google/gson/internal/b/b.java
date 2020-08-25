package com.google.gson.internal.b;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes3.dex */
public abstract class b {
    private static final b nFA;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        nFA = d.dXc() < 9 ? new a() : new c();
    }

    public static b dXF() {
        return nFA;
    }
}
