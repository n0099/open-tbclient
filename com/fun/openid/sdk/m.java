package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static Object f30726a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f30727b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f30728c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f30727b = cls;
            f30726a = cls.newInstance();
            f30727b.getMethod("getUDID", Context.class);
            f30728c = f30727b.getMethod("getOAID", Context.class);
            f30727b.getMethod("getVAID", Context.class);
            f30727b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }
}
