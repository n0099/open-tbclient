package com.google.gson.internal.b;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes7.dex */
public abstract class b {
    private static final b ncX;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        ncX = d.dHF() < 9 ? new a() : new c();
    }

    public static b dIi() {
        return ncX;
    }
}
