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
        private static Object nkE;
        private static Class<?> nkF;
        private static Method nkG;
        private static Method nkH;
        private static Method nkI;
        private static Method nkJ;

        static {
            nkG = null;
            nkH = null;
            nkI = null;
            nkJ = null;
            try {
                nkF = Class.forName("com.android.id.impl.IdProviderImpl");
                nkE = nkF.newInstance();
                nkG = nkF.getMethod("getUDID", Context.class);
                nkH = nkF.getMethod("getOAID", Context.class);
                nkI = nkF.getMethod("getVAID", Context.class);
                nkJ = nkF.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (nkF == null || nkE == null) ? false : true;
        }

        public static String gv(Context context) {
            return a(context, nkH);
        }

        private static String a(Context context, Method method) {
            if (nkE != null && method != null) {
                try {
                    Object invoke = method.invoke(nkE, context);
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
