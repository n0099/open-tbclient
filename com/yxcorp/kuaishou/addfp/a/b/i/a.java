package com.yxcorp.kuaishou.addfp.a.b.i;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Object f8616a;
    private static Class b;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f8616a = cls.newInstance();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public static String a(Context context) {
        return a(context, "getOAID");
    }

    private static String a(Context context, String str) {
        if (f8616a != null && !TextUtils.isEmpty(str)) {
            try {
                Object invoke = b.getMethod(str, Context.class).invoke(f8616a, context);
                if (invoke != null) {
                    return (String) invoke;
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
        return null;
    }

    public static boolean a() {
        return (b == null || f8616a == null) ? false : true;
    }
}
