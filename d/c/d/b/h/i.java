package d.c.d.b.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile HandlerThread f66712a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Handler f66713b;

    public static HandlerThread a() {
        if (f66712a == null) {
            synchronized (i.class) {
                if (f66712a == null) {
                    f66712a = new HandlerThread("default_npth_thread");
                    f66712a.start();
                    f66713b = new Handler(f66712a.getLooper());
                }
            }
        }
        return f66712a;
    }

    public static Handler b() {
        if (f66713b == null) {
            a();
        }
        return f66713b;
    }
}
