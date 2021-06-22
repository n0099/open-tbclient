package d.b.d.b.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f69693b;

    /* renamed from: a  reason: collision with root package name */
    public final c f69694a;

    public f(@NonNull Context context) {
        this.f69694a = new c(context);
    }

    public static f a(Context context) {
        if (f69693b == null) {
            synchronized (f.class) {
                if (f69693b == null) {
                    f69693b = new f(context);
                }
            }
        }
        return f69693b;
    }

    public void b() {
        this.f69694a.c();
    }
}
