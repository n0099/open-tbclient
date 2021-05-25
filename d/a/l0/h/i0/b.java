package d.a.l0.h.i0;

import android.text.TextUtils;
import d.a.l0.a.a2.e;
import d.a.l0.n.i.m.f;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2, long j, long j2);

        void b(int i2);

        void success();
    }

    public static void a(String str, a aVar) {
        e i2;
        if (aVar == null || TextUtils.isEmpty(str) || (i2 = e.i()) == null) {
            return;
        }
        if (d.a.l0.h.i0.a.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = d.a.l0.h.i0.a.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            d.a.l0.n.b.f(new f(i2.f40749f, i2.Z(), a2, 1), new d.a.l0.h.i0.e.a(i2.f40749f, i2.Z(), d.a.l0.h.i0.a.b().c(str, 2), aVar));
        }
    }
}
