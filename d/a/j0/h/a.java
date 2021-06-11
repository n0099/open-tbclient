package d.a.j0.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class a extends HandlerThread {

    /* renamed from: e  reason: collision with root package name */
    public static a f44090e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f44091f;

    public a() {
        super("BackgroundThread", 10);
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            b();
            handler = f44091f;
        }
        return handler;
    }

    public static void b() {
        if (f44090e == null) {
            a aVar = new a();
            f44090e = aVar;
            aVar.start();
            f44091f = new Handler(f44090e.getLooper());
        }
    }
}
