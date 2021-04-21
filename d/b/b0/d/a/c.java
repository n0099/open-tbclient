package d.b.b0.d.a;

import android.content.Context;
import com.baidu.prologue.service.network.Request;
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: b  reason: collision with root package name */
    public static e f42190b;

    /* renamed from: a  reason: collision with root package name */
    public final e f42191a;

    public c(Context context) {
        this.f42191a = new g(context);
    }

    public static e c(Context context) {
        if (f42190b == null) {
            synchronized (e.class) {
                if (f42190b == null) {
                    f42190b = new c(context);
                }
            }
        }
        return f42190b;
    }

    @Override // d.b.b0.d.a.e
    public void a(Request request, k kVar) {
        this.f42191a.a(request, kVar);
    }
}
