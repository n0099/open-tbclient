package com.c.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {
    public static boolean isSupported() {
        return C0650a.isSupported();
    }

    public static String gv(Context context) {
        return C0650a.gv(context.getApplicationContext());
    }

    /* renamed from: com.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0650a {
        private static Object nkr;
        private static Class<?> nks;
        private static Method nkt;
        private static Method nku;
        private static Method nkv;
        private static Method nkw;

        static {
            nkt = null;
            nku = null;
            nkv = null;
            nkw = null;
            try {
                nks = Class.forName("com.android.id.impl.IdProviderImpl");
                nkr = nks.newInstance();
                nkt = nks.getMethod("getUDID", Context.class);
                nku = nks.getMethod("getOAID", Context.class);
                nkv = nks.getMethod("getVAID", Context.class);
                nkw = nks.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (nks == null || nkr == null) ? false : true;
        }

        public static String gv(Context context) {
            return a(context, nku);
        }

        private static String a(Context context, Method method) {
            if (nkr != null && method != null) {
                try {
                    Object invoke = method.invoke(nkr, context);
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
