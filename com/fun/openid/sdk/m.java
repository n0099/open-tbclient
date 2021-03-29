package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static Object f30850a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f30851b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f30852c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f30851b = cls;
            f30850a = cls.newInstance();
            f30851b.getMethod("getUDID", Context.class);
            f30852c = f30851b.getMethod("getOAID", Context.class);
            f30851b.getMethod("getVAID", Context.class);
            f30851b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }
}
