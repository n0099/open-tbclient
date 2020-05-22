package com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class b {
    public static String a(Context context) {
        e dGw = e.dGw();
        return dGw.a(context.getApplicationContext(), dGw.nda);
    }

    public static final boolean a() {
        Context context;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
            method.setAccessible(true);
            context = (Context) method.invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e.toString());
            context = null;
        }
        if (context == null) {
            return false;
        }
        return e.dGw().a(context, false);
    }

    public static String b(Context context) {
        e dGw = e.dGw();
        return dGw.a(context.getApplicationContext(), dGw.ndb);
    }

    public static String c(Context context) {
        e dGw = e.dGw();
        return dGw.a(context.getApplicationContext(), dGw.ndd);
    }

    public static String d(Context context) {
        e dGw = e.dGw();
        return dGw.a(context.getApplicationContext(), dGw.ndc);
    }
}
