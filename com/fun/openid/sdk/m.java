package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static Object f31552a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f31553b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f31554c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f31553b = cls;
            f31552a = cls.newInstance();
            f31553b.getMethod("getUDID", Context.class);
            f31554c = f31553b.getMethod("getOAID", Context.class);
            f31553b.getMethod("getVAID", Context.class);
            f31553b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }
}
