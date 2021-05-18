package d.a.b0.d.a;

import android.content.Context;
import com.baidu.prologue.service.network.Request;
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: b  reason: collision with root package name */
    public static e f38620b;

    /* renamed from: a  reason: collision with root package name */
    public final e f38621a;

    public c(Context context) {
        this.f38621a = new g(context);
    }

    public static e c(Context context) {
        if (f38620b == null) {
            synchronized (e.class) {
                if (f38620b == null) {
                    f38620b = new c(context);
                }
            }
        }
        return f38620b;
    }

    @Override // d.a.b0.d.a.e
    public void a(Request request, k kVar) {
        this.f38621a.a(request, kVar);
    }
}
