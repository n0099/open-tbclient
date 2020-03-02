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
        private static Object nkt;
        private static Class<?> nku;
        private static Method nkv;
        private static Method nkw;
        private static Method nkx;
        private static Method nky;

        static {
            nkv = null;
            nkw = null;
            nkx = null;
            nky = null;
            try {
                nku = Class.forName("com.android.id.impl.IdProviderImpl");
                nkt = nku.newInstance();
                nkv = nku.getMethod("getUDID", Context.class);
                nkw = nku.getMethod("getOAID", Context.class);
                nkx = nku.getMethod("getVAID", Context.class);
                nky = nku.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (nku == null || nkt == null) ? false : true;
        }

        public static String gv(Context context) {
            return a(context, nkw);
        }

        private static String a(Context context, Method method) {
            if (nkt != null && method != null) {
                try {
                    Object invoke = method.invoke(nkt, context);
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
