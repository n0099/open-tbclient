package d.b.d.b.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f65129b;

    /* renamed from: a  reason: collision with root package name */
    public final c f65130a;

    public f(@NonNull Context context) {
        this.f65130a = new c(context);
    }

    public static f a(Context context) {
        if (f65129b == null) {
            synchronized (f.class) {
                if (f65129b == null) {
                    f65129b = new f(context);
                }
            }
        }
        return f65129b;
    }

    public void b() {
        this.f65130a.c();
    }
}
