package d.a.m0.a.n0.j.d;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import d.a.m0.a.a1.e;
import d.a.m0.a.k;
import d.a.m0.a.v2.l;
/* loaded from: classes3.dex */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f47404a = {d.a.m0.a.k2.b.w(), d.a.m0.a.k2.b.y(), d.a.m0.a.h0.o.h.d.a.c()};

    @Override // d.a.m0.a.n0.j.d.a
    public ArraySet<String> a() {
        ArraySet<String> arraySet = new ArraySet<>();
        for (String str : this.f47404a) {
            String J = d.a.m0.t.d.J(str);
            if (!TextUtils.isEmpty(J)) {
                arraySet.add(J);
            }
        }
        if (k.f46983a) {
            b(arraySet);
        }
        d.a.m0.a.e0.d.h("SwanSdcardFileCollector", "recovery renameAllFiles:" + arraySet.toString());
        return arraySet;
    }

    public final void b(ArraySet<String> arraySet) {
        if (arraySet == null) {
            return;
        }
        String[] strArr = {d.a.m0.a.p0.f.c.b().getAbsolutePath(), d.a.m0.a.m2.d.a.c().getAbsolutePath(), e.b.d(), l.b(), d.a.m0.a.a1.h.a.j(), d.a.m0.a.r1.l.a.b()};
        for (int i2 = 0; i2 < 6; i2++) {
            String J = d.a.m0.t.d.J(strArr[i2]);
            if (!TextUtils.isEmpty(J)) {
                arraySet.add(J);
            }
        }
    }
}
