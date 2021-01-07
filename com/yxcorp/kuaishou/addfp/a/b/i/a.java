package com.yxcorp.kuaishou.addfp.a.b.i;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Object f14673a;

    /* renamed from: b  reason: collision with root package name */
    private static Class f14674b;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f14674b = cls;
            f14673a = cls.newInstance();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public static String a(Context context) {
        return a(context, "getOAID");
    }

    private static String a(Context context, String str) {
        if (f14673a != null && !TextUtils.isEmpty(str)) {
            try {
                Object invoke = f14674b.getMethod(str, Context.class).invoke(f14673a, context);
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
        return (f14674b == null || f14673a == null) ? false : true;
    }
}
