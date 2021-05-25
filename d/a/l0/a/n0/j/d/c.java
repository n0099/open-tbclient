package d.a.l0.a.n0.j.d;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import d.a.l0.a.a1.e;
/* loaded from: classes2.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public String[] f43619a = {d.a.l0.a.a1.e.i(), d.a.l0.a.a1.e.l(), d.a.l0.a.a1.e.r(), e.b.f(), d.a.l0.a.e0.f.f.b.f(), d.a.l0.a.e0.f.f.b.d(), d.a.l0.a.e0.f.c.a.c(), e.f.f(), e.f.d(), d.a.l0.a.x0.a.d.a.f45751d};

    @Override // d.a.l0.a.n0.j.d.a
    public ArraySet<String> a() {
        ArraySet<String> arraySet = new ArraySet<>();
        for (String str : this.f43619a) {
            String J = d.a.l0.t.d.J(str);
            if (!TextUtils.isEmpty(J)) {
                arraySet.add(J);
            }
        }
        d.a.l0.a.e0.d.h("SwanSandboxFileCollector", "recovery renameAllFiles:" + arraySet.toString());
        return arraySet;
    }
}
