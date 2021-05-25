package d.a.j0.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class a extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static a f40411e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f40412f;

    public a() {
        super("BackgroundThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            b();
            handler = f40412f;
        }
        return handler;
    }

    public static void b() {
        if (f40411e == null) {
            a aVar = new a();
            f40411e = aVar;
            aVar.start();
            f40412f = new Handler(f40411e.getLooper());
        }
    }
}
