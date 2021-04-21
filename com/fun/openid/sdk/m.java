package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static Object f30618a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f30619b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f30620c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f30619b = cls;
            f30618a = cls.newInstance();
            f30619b.getMethod("getUDID", Context.class);
            f30620c = f30619b.getMethod("getOAID", Context.class);
            f30619b.getMethod("getVAID", Context.class);
            f30619b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }
}
