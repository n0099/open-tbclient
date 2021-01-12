package com.yxcorp.kuaishou.addfp.a.b.i;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Object f14373a;

    /* renamed from: b  reason: collision with root package name */
    private static Class f14374b;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f14374b = cls;
            f14373a = cls.newInstance();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public static String a(Context context) {
        return a(context, "getOAID");
    }

    private static String a(Context context, String str) {
        if (f14373a != null && !TextUtils.isEmpty(str)) {
            try {
                Object invoke = f14374b.getMethod(str, Context.class).invoke(f14373a, context);
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
        return (f14374b == null || f14373a == null) ? false : true;
    }
}
