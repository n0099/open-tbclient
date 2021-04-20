package d.b.f0.k;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class b extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static b f43394e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f43395f;

    public b() {
        super("SSOHandlerThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (b.class) {
            b();
            handler = f43395f;
        }
        return handler;
    }

    public static void b() {
        if (f43394e == null) {
            b bVar = new b();
            f43394e = bVar;
            bVar.start();
            f43395f = new Handler(f43394e.getLooper());
        }
    }
}
