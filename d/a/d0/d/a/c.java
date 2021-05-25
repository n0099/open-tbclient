package d.a.d0.d.a;

import android.content.Context;
import com.baidu.prologue.service.network.Request;
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: b  reason: collision with root package name */
    public static e f39689b;

    /* renamed from: a  reason: collision with root package name */
    public final e f39690a;

    public c(Context context) {
        this.f39690a = new g(context);
    }

    public static e c(Context context) {
        if (f39689b == null) {
            synchronized (e.class) {
                if (f39689b == null) {
                    f39689b = new c(context);
                }
            }
        }
        return f39689b;
    }

    @Override // d.a.d0.d.a.e
    public void a(Request request, k kVar) {
        this.f39690a.a(request, kVar);
    }
}
