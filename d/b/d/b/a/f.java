package d.b.d.b.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f65858b;

    /* renamed from: a  reason: collision with root package name */
    public final c f65859a;

    public f(@NonNull Context context) {
        this.f65859a = new c(context);
    }

    public static f a(Context context) {
        if (f65858b == null) {
            synchronized (f.class) {
                if (f65858b == null) {
                    f65858b = new f(context);
                }
            }
        }
        return f65858b;
    }

    public void b() {
        this.f65859a.c();
    }
}
