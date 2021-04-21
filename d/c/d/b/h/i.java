package d.c.d.b.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile HandlerThread f66807a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Handler f66808b;

    public static HandlerThread a() {
        if (f66807a == null) {
            synchronized (i.class) {
                if (f66807a == null) {
                    f66807a = new HandlerThread("default_npth_thread");
                    f66807a.start();
                    f66808b = new Handler(f66807a.getLooper());
                }
            }
        }
        return f66807a;
    }

    public static Handler b() {
        if (f66808b == null) {
            a();
        }
        return f66808b;
    }
}
