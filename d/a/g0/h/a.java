package d.a.g0.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class a extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static a f40905e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f40906f;

    public a() {
        super("BackgroundThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            b();
            handler = f40906f;
        }
        return handler;
    }

    public static void b() {
        if (f40905e == null) {
            a aVar = new a();
            f40905e = aVar;
            aVar.start();
            f40906f = new Handler(f40905e.getLooper());
        }
    }
}
