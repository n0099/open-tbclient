package com.c.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {
    public static boolean isSupported() {
        return C0651a.isSupported();
    }

    public static String gu(Context context) {
        return C0651a.gu(context.getApplicationContext());
    }

    /* renamed from: com.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0651a {
        private static Object nmr;
        private static Class<?> nms;
        private static Method nmt;
        private static Method nmu;
        private static Method nmv;
        private static Method nmw;

        static {
            nmt = null;
            nmu = null;
            nmv = null;
            nmw = null;
            try {
                nms = Class.forName("com.android.id.impl.IdProviderImpl");
                nmr = nms.newInstance();
                nmt = nms.getMethod("getUDID", Context.class);
                nmu = nms.getMethod("getOAID", Context.class);
                nmv = nms.getMethod("getVAID", Context.class);
                nmw = nms.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static boolean isSupported() {
            return (nms == null || nmr == null) ? false : true;
        }

        public static String gu(Context context) {
            return a(context, nmu);
        }

        private static String a(Context context, Method method) {
            if (nmr != null && method != null) {
                try {
                    Object invoke = method.invoke(nmr, context);
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
