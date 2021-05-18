package d.b.d.b.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile HandlerThread f65899a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Handler f65900b;

    public static HandlerThread a() {
        if (f65899a == null) {
            synchronized (i.class) {
                if (f65899a == null) {
                    f65899a = new HandlerThread("default_npth_thread");
                    f65899a.start();
                    f65900b = new Handler(f65899a.getLooper());
                }
            }
        }
        return f65899a;
    }

    public static Handler b() {
        if (f65900b == null) {
            a();
        }
        return f65900b;
    }
}
