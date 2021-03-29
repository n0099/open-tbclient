package d.b.f0.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class a extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static a f42964e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f42965f;

    public a() {
        super("BackgroundThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            b();
            handler = f42965f;
        }
        return handler;
    }

    public static void b() {
        if (f42964e == null) {
            a aVar = new a();
            f42964e = aVar;
            aVar.start();
            f42965f = new Handler(f42964e.getLooper());
        }
    }
}
