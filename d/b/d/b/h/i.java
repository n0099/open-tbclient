package d.b.d.b.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile HandlerThread f69673a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Handler f69674b;

    public static HandlerThread a() {
        if (f69673a == null) {
            synchronized (i.class) {
                if (f69673a == null) {
                    f69673a = new HandlerThread("default_npth_thread");
                    f69673a.start();
                    f69674b = new Handler(f69673a.getLooper());
                }
            }
        }
        return f69673a;
    }

    public static Handler b() {
        if (f69674b == null) {
            a();
        }
        return f69674b;
    }
}
