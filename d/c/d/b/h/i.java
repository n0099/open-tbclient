package d.c.d.b.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile HandlerThread f65867a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Handler f65868b;

    public static HandlerThread a() {
        if (f65867a == null) {
            synchronized (i.class) {
                if (f65867a == null) {
                    f65867a = new HandlerThread("default_npth_thread");
                    f65867a.start();
                    f65868b = new Handler(f65867a.getLooper());
                }
            }
        }
        return f65867a;
    }

    public static Handler b() {
        if (f65868b == null) {
            a();
        }
        return f65868b;
    }
}
