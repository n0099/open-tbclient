package d.b.d.b.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f65815b;

    /* renamed from: a  reason: collision with root package name */
    public final c f65816a;

    public f(@NonNull Context context) {
        this.f65816a = new c(context);
    }

    public static f a(Context context) {
        if (f65815b == null) {
            synchronized (f.class) {
                if (f65815b == null) {
                    f65815b = new f(context);
                }
            }
        }
        return f65815b;
    }

    public void b() {
        this.f65816a.c();
    }
}
