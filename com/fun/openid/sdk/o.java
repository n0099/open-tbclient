package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static Object f5248a;
    public static Class<?> b;
    public static Method c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f5248a = cls.newInstance();
            b.getMethod("getUDID", Context.class);
            c = b.getMethod("getOAID", Context.class);
            b.getMethod("getVAID", Context.class);
            b.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            Log.e("IdentifierManager", "reflect exception!", e);
        }
    }
}
