package d.b.d.b.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile HandlerThread f65213a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Handler f65214b;

    public static HandlerThread a() {
        if (f65213a == null) {
            synchronized (i.class) {
                if (f65213a == null) {
                    f65213a = new HandlerThread("default_npth_thread");
                    f65213a.start();
                    f65214b = new Handler(f65213a.getLooper());
                }
            }
        }
        return f65213a;
    }

    public static Handler b() {
        if (f65214b == null) {
            a();
        }
        return f65214b;
    }
}
