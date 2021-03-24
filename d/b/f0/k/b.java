package d.b.f0.k;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes3.dex */
public class b extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static b f43001e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f43002f;

    public b() {
        super("SSOHandlerThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (b.class) {
            b();
            handler = f43002f;
        }
        return handler;
    }

    public static void b() {
        if (f43001e == null) {
            b bVar = new b();
            f43001e = bVar;
            bVar.start();
            f43002f = new Handler(f43001e.getLooper());
        }
    }
}
