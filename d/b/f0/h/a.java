package d.b.f0.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class a extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static a f43356e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f43357f;

    public a() {
        super("BackgroundThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            b();
            handler = f43357f;
        }
        return handler;
    }

    public static void b() {
        if (f43356e == null) {
            a aVar = new a();
            f43356e = aVar;
            aVar.start();
            f43357f = new Handler(f43356e.getLooper());
        }
    }
}
