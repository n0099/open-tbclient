package d.a.x.b.a;

import android.app.Application;
import android.content.Context;
import d.a.x.i.h;
/* loaded from: classes2.dex */
public class a {
    public static boolean a(Application application) {
        Object e2;
        ClassLoader classLoader;
        try {
            Context baseContext = application.getBaseContext();
            if (baseContext == null || (e2 = h.e(baseContext, "mPackageInfo")) == null || (classLoader = (ClassLoader) h.e(e2, "mClassLoader")) == null) {
                return false;
            }
            b bVar = new b(classLoader.getParent(), classLoader);
            h.j(e2, "mClassLoader", bVar);
            Thread.currentThread().setContextClassLoader(bVar);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
