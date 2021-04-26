package d.a.h0.g.f0;

import android.text.TextUtils;
import d.a.h0.a.r1.e;
import d.a.h0.l.l.k.f;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2, long j, long j2);

        void b(int i2);

        void success();
    }

    public static void a(String str, a aVar) {
        e h2;
        if (aVar == null || TextUtils.isEmpty(str) || (h2 = e.h()) == null) {
            return;
        }
        if (d.a.h0.g.f0.a.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = d.a.h0.g.f0.a.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            d.a.h0.l.c.d(new f(h2.f43823f, h2.W(), a2, 1), new d.a.h0.g.f0.e.a(h2.f43823f, h2.W(), d.a.h0.g.f0.a.b().c(str, 2), aVar));
        }
    }
}
