package d.b.f0.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes3.dex */
public class a extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static a f42963e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f42964f;

    public a() {
        super("BackgroundThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            b();
            handler = f42964f;
        }
        return handler;
    }

    public static void b() {
        if (f42963e == null) {
            a aVar = new a();
            f42963e = aVar;
            aVar.start();
            f42964f = new Handler(f42963e.getLooper());
        }
    }
}
