package d.b.g0.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class a extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static a f43653e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f43654f;

    public a() {
        super("BackgroundThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            b();
            handler = f43654f;
        }
        return handler;
    }

    public static void b() {
        if (f43653e == null) {
            a aVar = new a();
            f43653e = aVar;
            aVar.start();
            f43654f = new Handler(f43653e.getLooper());
        }
    }
}
