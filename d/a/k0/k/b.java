package d.a.k0.k;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class b extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static b f44273e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f44274f;

    public b() {
        super("SSOHandlerThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (b.class) {
            b();
            handler = f44274f;
        }
        return handler;
    }

    public static void b() {
        if (f44273e == null) {
            b bVar = new b();
            f44273e = bVar;
            bVar.start();
            f44274f = new Handler(f44273e.getLooper());
        }
    }
}
