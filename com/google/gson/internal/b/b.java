package com.google.gson.internal.b;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes10.dex */
public abstract class b {
    private static final b nlJ;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        nlJ = d.dLb() < 9 ? new a() : new c();
    }

    public static b dLE() {
        return nlJ;
    }
}
