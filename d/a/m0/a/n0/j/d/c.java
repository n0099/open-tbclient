package d.a.m0.a.n0.j.d;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import d.a.m0.a.a1.e;
/* loaded from: classes3.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public String[] f47403a = {d.a.m0.a.a1.e.i(), d.a.m0.a.a1.e.l(), d.a.m0.a.a1.e.r(), e.b.f(), d.a.m0.a.e0.f.f.b.f(), d.a.m0.a.e0.f.f.b.d(), d.a.m0.a.e0.f.c.a.c(), e.f.f(), e.f.d(), d.a.m0.a.x0.a.d.a.f49533d};

    @Override // d.a.m0.a.n0.j.d.a
    public ArraySet<String> a() {
        ArraySet<String> arraySet = new ArraySet<>();
        for (String str : this.f47403a) {
            String J = d.a.m0.t.d.J(str);
            if (!TextUtils.isEmpty(J)) {
                arraySet.add(J);
            }
        }
        d.a.m0.a.e0.d.h("SwanSandboxFileCollector", "recovery renameAllFiles:" + arraySet.toString());
        return arraySet;
    }
}
