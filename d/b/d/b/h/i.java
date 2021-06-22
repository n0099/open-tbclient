package d.b.d.b.h;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile HandlerThread f69777a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Handler f69778b;

    public static HandlerThread a() {
        if (f69777a == null) {
            synchronized (i.class) {
                if (f69777a == null) {
                    f69777a = new HandlerThread("default_npth_thread");
                    f69777a.start();
                    f69778b = new Handler(f69777a.getLooper());
                }
            }
        }
        return f69777a;
    }

    public static Handler b() {
        if (f69778b == null) {
            a();
        }
        return f69778b;
    }
}
