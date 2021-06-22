package d.a.d0.d.a;

import android.content.Context;
import com.baidu.prologue.service.network.Request;
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: b  reason: collision with root package name */
    public static e f43473b;

    /* renamed from: a  reason: collision with root package name */
    public final e f43474a;

    public c(Context context) {
        this.f43474a = new g(context);
    }

    public static e c(Context context) {
        if (f43473b == null) {
            synchronized (e.class) {
                if (f43473b == null) {
                    f43473b = new c(context);
                }
            }
        }
        return f43473b;
    }

    @Override // d.a.d0.d.a.e
    public void a(Request request, k kVar) {
        this.f43474a.a(request, kVar);
    }
}
