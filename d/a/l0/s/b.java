package d.a.l0.s;

import android.annotation.SuppressLint;
import d.a.l0.t.j;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class b extends j {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f48488d;

    public b() {
        super("aiapp_open_stat");
    }

    public static b g() {
        if (f48488d == null) {
            synchronized (b.class) {
                if (f48488d == null) {
                    f48488d = new b();
                }
            }
        }
        return f48488d;
    }
}
