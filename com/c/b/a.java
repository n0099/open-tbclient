package com.c.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class a {
    public static boolean dzA() {
        return C0637a.dzA();
    }

    public static String gv(Context context) {
        return C0637a.gv(context.getApplicationContext());
    }

    /* renamed from: com.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0637a {
        private static Object mKi;
        private static Class<?> mKj;
        private static Method mKk;
        private static Method mKl;
        private static Method mKm;
        private static Method mKn;

        static {
            mKk = null;
            mKl = null;
            mKm = null;
            mKn = null;
            try {
                mKj = Class.forName("com.android.id.impl.IdProviderImpl");
                mKi = mKj.newInstance();
                mKk = mKj.getMethod("getUDID", Context.class);
                mKl = mKj.getMethod("getOAID", Context.class);
                mKm = mKj.getMethod("getVAID", Context.class);
                mKn = mKj.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean dzA() {
            return (mKj == null || mKi == null) ? false : true;
        }

        public static String gv(Context context) {
            return a(context, mKl);
        }

        private static String a(Context context, Method method) {
            if (mKi != null && method != null) {
                try {
                    Object invoke = method.invoke(mKi, context);
                    if (invoke != null) {
                        return (String) invoke;
                    }
                } catch (Exception e) {
                    Log.e("XiaomiId", "invoke method error", e);
                }
            }
            return null;
        }
    }
}
