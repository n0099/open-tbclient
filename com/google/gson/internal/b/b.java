package com.google.gson.internal.b;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes7.dex */
public abstract class b {
    private static final b mlN;

    public abstract void b(AccessibleObject accessibleObject);

    static {
        mlN = d.dvt() < 9 ? new a() : new c();
    }

    public static b dvW() {
        return mlN;
    }
}
