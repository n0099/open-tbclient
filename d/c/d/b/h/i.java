package d.c.d.b.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile HandlerThread f65866a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Handler f65867b;

    public static HandlerThread a() {
        if (f65866a == null) {
            synchronized (i.class) {
                if (f65866a == null) {
                    f65866a = new HandlerThread("default_npth_thread");
                    f65866a.start();
                    f65867b = new Handler(f65866a.getLooper());
                }
            }
        }
        return f65866a;
    }

    public static Handler b() {
        if (f65867b == null) {
            a();
        }
        return f65867b;
    }
}
