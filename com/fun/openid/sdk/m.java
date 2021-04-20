package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static Object f30523a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f30524b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f30525c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f30524b = cls;
            f30523a = cls.newInstance();
            f30524b.getMethod("getUDID", Context.class);
            f30525c = f30524b.getMethod("getOAID", Context.class);
            f30524b.getMethod("getVAID", Context.class);
            f30524b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }
}
