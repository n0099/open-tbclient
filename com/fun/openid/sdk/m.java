package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static Object f30899a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f30900b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f30901c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f30900b = cls;
            f30899a = cls.newInstance();
            f30900b.getMethod("getUDID", Context.class);
            f30901c = f30900b.getMethod("getOAID", Context.class);
            f30900b.getMethod("getVAID", Context.class);
            f30900b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }
}
