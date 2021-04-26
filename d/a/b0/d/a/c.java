package d.a.b0.d.a;

import android.content.Context;
import com.baidu.prologue.service.network.Request;
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: b  reason: collision with root package name */
    public static e f39375b;

    /* renamed from: a  reason: collision with root package name */
    public final e f39376a;

    public c(Context context) {
        this.f39376a = new g(context);
    }

    public static e c(Context context) {
        if (f39375b == null) {
            synchronized (e.class) {
                if (f39375b == null) {
                    f39375b = new c(context);
                }
            }
        }
        return f39375b;
    }

    @Override // d.a.b0.d.a.e
    public void a(Request request, k kVar) {
        this.f39376a.a(request, kVar);
    }
}
