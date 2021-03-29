package d.b.g0.g.f0;

import android.text.TextUtils;
import d.b.g0.a.r1.e;
import d.b.g0.l.l.k.f;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, long j, long j2);

        void b(int i);

        void success();
    }

    public static void a(String str, a aVar) {
        e y;
        if (aVar == null || TextUtils.isEmpty(str) || (y = e.y()) == null) {
            return;
        }
        if (d.b.g0.g.f0.a.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = d.b.g0.g.f0.a.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            d.b.g0.l.c.d(new f(y.f45740f, y.W(), a2, 1), new d.b.g0.g.f0.e.a(y.f45740f, y.W(), d.b.g0.g.f0.a.b().c(str, 2), aVar));
        }
    }
}
