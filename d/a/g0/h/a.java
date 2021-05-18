package d.a.g0.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class a extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static a f40150e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f40151f;

    public a() {
        super("BackgroundThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            b();
            handler = f40151f;
        }
        return handler;
    }

    public static void b() {
        if (f40150e == null) {
            a aVar = new a();
            f40150e = aVar;
            aVar.start();
            f40151f = new Handler(f40150e.getLooper());
        }
    }
}
