package d.a.i0.s;

import android.annotation.SuppressLint;
import d.a.i0.t.j;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class b extends j {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f48312d;

    public b() {
        super("aiapp_open_stat");
    }

    public static b g() {
        if (f48312d == null) {
            synchronized (b.class) {
                if (f48312d == null) {
                    f48312d = new b();
                }
            }
        }
        return f48312d;
    }
}
