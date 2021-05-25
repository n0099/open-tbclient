package d.a.j0.k;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class b extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static b f40454e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f40455f;

    public b() {
        super("SSOHandlerThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (b.class) {
            b();
            handler = f40455f;
        }
        return handler;
    }

    public static void b() {
        if (f40454e == null) {
            b bVar = new b();
            f40454e = bVar;
            bVar.start();
            f40455f = new Handler(f40454e.getLooper());
        }
    }
}
