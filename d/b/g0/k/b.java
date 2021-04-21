package d.b.g0.k;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class b extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static b f43691e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f43692f;

    public b() {
        super("SSOHandlerThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (b.class) {
            b();
            handler = f43692f;
        }
        return handler;
    }

    public static void b() {
        if (f43691e == null) {
            b bVar = new b();
            f43691e = bVar;
            bVar.start();
            f43692f = new Handler(f43691e.getLooper());
        }
    }
}
