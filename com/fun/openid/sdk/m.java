package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static Object f30797a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f30798b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f30799c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f30798b = cls;
            f30797a = cls.newInstance();
            f30798b.getMethod("getUDID", Context.class);
            f30799c = f30798b.getMethod("getOAID", Context.class);
            f30798b.getMethod("getVAID", Context.class);
            f30798b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }
}
