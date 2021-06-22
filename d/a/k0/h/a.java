package d.a.k0.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class a extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static a f44230e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f44231f;

    public a() {
        super("BackgroundThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            b();
            handler = f44231f;
        }
        return handler;
    }

    public static void b() {
        if (f44230e == null) {
            a aVar = new a();
            f44230e = aVar;
            aVar.start();
            f44231f = new Handler(f44230e.getLooper());
        }
    }
}
