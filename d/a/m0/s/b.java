package d.a.m0.s;

import android.annotation.SuppressLint;
import d.a.m0.t.j;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class b extends j {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f52270d;

    public b() {
        super("aiapp_open_stat");
    }

    public static b g() {
        if (f52270d == null) {
            synchronized (b.class) {
                if (f52270d == null) {
                    f52270d = new b();
                }
            }
        }
        return f52270d;
    }
}
