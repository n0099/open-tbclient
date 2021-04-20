package d.b.a0.d.a;

import android.content.Context;
import com.baidu.prologue.service.network.Request;
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: b  reason: collision with root package name */
    public static e f41901b;

    /* renamed from: a  reason: collision with root package name */
    public final e f41902a;

    public c(Context context) {
        this.f41902a = new g(context);
    }

    public static e c(Context context) {
        if (f41901b == null) {
            synchronized (e.class) {
                if (f41901b == null) {
                    f41901b = new c(context);
                }
            }
        }
        return f41901b;
    }

    @Override // d.b.a0.d.a.e
    public void a(Request request, k kVar) {
        this.f41902a.a(request, kVar);
    }
}
