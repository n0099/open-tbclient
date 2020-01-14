package com.c.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class a {
    public static boolean isSupported() {
        return C0642a.isSupported();
    }

    public static String gw(Context context) {
        return C0642a.gw(context.getApplicationContext());
    }

    /* renamed from: com.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static class C0642a {
        private static Object njP;
        private static Class<?> njQ;
        private static Method njR;
        private static Method njS;
        private static Method njT;
        private static Method njU;

        static {
            njR = null;
            njS = null;
            njT = null;
            njU = null;
            try {
                njQ = Class.forName("com.android.id.impl.IdProviderImpl");
                njP = njQ.newInstance();
                njR = njQ.getMethod("getUDID", Context.class);
                njS = njQ.getMethod("getOAID", Context.class);
                njT = njQ.getMethod("getVAID", Context.class);
                njU = njQ.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (njQ == null || njP == null) ? false : true;
        }

        public static String gw(Context context) {
            return a(context, njS);
        }

        private static String a(Context context, Method method) {
            if (njP != null && method != null) {
                try {
                    Object invoke = method.invoke(njP, context);
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
