package d.b.d.b.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f69589b;

    /* renamed from: a  reason: collision with root package name */
    public final c f69590a;

    public f(@NonNull Context context) {
        this.f69590a = new c(context);
    }

    public static f a(Context context) {
        if (f69589b == null) {
            synchronized (f.class) {
                if (f69589b == null) {
                    f69589b = new f(context);
                }
            }
        }
        return f69589b;
    }

    public void b() {
        this.f69590a.c();
    }
}
