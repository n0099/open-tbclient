package d.a.j0.k;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class b extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static b f44133e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f44134f;

    public b() {
        super("SSOHandlerThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (b.class) {
            b();
            handler = f44134f;
        }
        return handler;
    }

    public static void b() {
        if (f44133e == null) {
            b bVar = new b();
            f44133e = bVar;
            bVar.start();
            f44134f = new Handler(f44133e.getLooper());
        }
    }
}
