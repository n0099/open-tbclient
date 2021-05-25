package d.b.d.b.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile HandlerThread f65942a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Handler f65943b;

    public static HandlerThread a() {
        if (f65942a == null) {
            synchronized (i.class) {
                if (f65942a == null) {
                    f65942a = new HandlerThread("default_npth_thread");
                    f65942a.start();
                    f65943b = new Handler(f65942a.getLooper());
                }
            }
        }
        return f65942a;
    }

    public static Handler b() {
        if (f65943b == null) {
            a();
        }
        return f65943b;
    }
}
