package d.c.d.b.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f66632b;

    /* renamed from: a  reason: collision with root package name */
    public final c f66633a;

    public f(@NonNull Context context) {
        this.f66633a = new c(context);
    }

    public static f a(Context context) {
        if (f66632b == null) {
            synchronized (f.class) {
                if (f66632b == null) {
                    f66632b = new f(context);
                }
            }
        }
        return f66632b;
    }

    public void b() {
        this.f66633a.c();
    }
}
