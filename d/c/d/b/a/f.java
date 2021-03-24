package d.c.d.b.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f65786b;

    /* renamed from: a  reason: collision with root package name */
    public final c f65787a;

    public f(@NonNull Context context) {
        this.f65787a = new c(context);
    }

    public static f a(Context context) {
        if (f65786b == null) {
            synchronized (f.class) {
                if (f65786b == null) {
                    f65786b = new f(context);
                }
            }
        }
        return f65786b;
    }

    public void b() {
        this.f65787a.c();
    }
}
