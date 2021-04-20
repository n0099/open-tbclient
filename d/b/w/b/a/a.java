package d.b.w.b.a;

import android.app.Application;
import android.content.Context;
import d.b.w.h.g;
/* loaded from: classes2.dex */
public class a {
    public static boolean a(Application application) {
        Object e2;
        ClassLoader classLoader;
        try {
            Context baseContext = application.getBaseContext();
            if (baseContext == null || (e2 = g.e(baseContext, "mPackageInfo")) == null || (classLoader = (ClassLoader) g.e(e2, "mClassLoader")) == null) {
                return false;
            }
            b bVar = new b(classLoader.getParent(), classLoader);
            g.j(e2, "mClassLoader", bVar);
            Thread.currentThread().setContextClassLoader(bVar);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
