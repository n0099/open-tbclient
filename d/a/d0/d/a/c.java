package d.a.d0.d.a;

import android.content.Context;
import com.baidu.prologue.service.network.Request;
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: b  reason: collision with root package name */
    public static e f43370b;

    /* renamed from: a  reason: collision with root package name */
    public final e f43371a;

    public c(Context context) {
        this.f43371a = new g(context);
    }

    public static e c(Context context) {
        if (f43370b == null) {
            synchronized (e.class) {
                if (f43370b == null) {
                    f43370b = new c(context);
                }
            }
        }
        return f43370b;
    }

    @Override // d.a.d0.d.a.e
    public void a(Request request, k kVar) {
        this.f43371a.a(request, kVar);
    }
}
