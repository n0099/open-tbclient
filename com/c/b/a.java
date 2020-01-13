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
        private static Object njK;
        private static Class<?> njL;
        private static Method njM;
        private static Method njN;
        private static Method njO;
        private static Method njP;

        static {
            njM = null;
            njN = null;
            njO = null;
            njP = null;
            try {
                njL = Class.forName("com.android.id.impl.IdProviderImpl");
                njK = njL.newInstance();
                njM = njL.getMethod("getUDID", Context.class);
                njN = njL.getMethod("getOAID", Context.class);
                njO = njL.getMethod("getVAID", Context.class);
                njP = njL.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (njL == null || njK == null) ? false : true;
        }

        public static String gw(Context context) {
            return a(context, njN);
        }

        private static String a(Context context, Method method) {
            if (njK != null && method != null) {
                try {
                    Object invoke = method.invoke(njK, context);
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
