package d.c.d.b.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f66727b;

    /* renamed from: a  reason: collision with root package name */
    public final c f66728a;

    public f(@NonNull Context context) {
        this.f66728a = new c(context);
    }

    public static f a(Context context) {
        if (f66727b == null) {
            synchronized (f.class) {
                if (f66727b == null) {
                    f66727b = new f(context);
                }
            }
        }
        return f66727b;
    }

    public void b() {
        this.f66728a.c();
    }
}
