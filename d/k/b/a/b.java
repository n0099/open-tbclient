package d.k.b.a;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class b {
    public static String a(Context context) {
        d b2 = d.b();
        return b2.c(context.getApplicationContext(), b2.f67339a);
    }

    public static final boolean b() {
        Context context = null;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
            method.setAccessible(true);
            context = (Context) method.invoke(null, new Object[0]);
        } catch (Exception e2) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e2.toString());
        }
        if (context == null) {
            return false;
        }
        return d.b().f(context, false);
    }

    public static String c(Context context) {
        d b2 = d.b();
        return b2.c(context.getApplicationContext(), b2.f67340b);
    }

    public static String d(Context context) {
        d b2 = d.b();
        return b2.c(context.getApplicationContext(), b2.f67342d);
    }

    public static String e(Context context) {
        d b2 = d.b();
        return b2.c(context.getApplicationContext(), b2.f67341c);
    }
}
