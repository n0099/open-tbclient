package d.a.g0.k;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class b extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static b f40193e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f40194f;

    public b() {
        super("SSOHandlerThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (b.class) {
            b();
            handler = f40194f;
        }
        return handler;
    }

    public static void b() {
        if (f40193e == null) {
            b bVar = new b();
            f40193e = bVar;
            bVar.start();
            f40194f = new Handler(f40193e.getLooper());
        }
    }
}
