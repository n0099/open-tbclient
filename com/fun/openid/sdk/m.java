package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static Object f30849a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f30850b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f30851c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f30850b = cls;
            f30849a = cls.newInstance();
            f30850b.getMethod("getUDID", Context.class);
            f30851c = f30850b.getMethod("getOAID", Context.class);
            f30850b.getMethod("getVAID", Context.class);
            f30850b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }
}
