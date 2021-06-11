package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static Object f30817a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f30818b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f30819c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f30818b = cls;
            f30817a = cls.newInstance();
            f30818b.getMethod("getUDID", Context.class);
            f30819c = f30818b.getMethod("getOAID", Context.class);
            f30818b.getMethod("getVAID", Context.class);
            f30818b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }
}
