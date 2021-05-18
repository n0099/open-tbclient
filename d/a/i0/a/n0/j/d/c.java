package d.a.i0.a.n0.j.d;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import d.a.i0.a.a1.e;
/* loaded from: classes2.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public String[] f43445a = {d.a.i0.a.a1.e.i(), d.a.i0.a.a1.e.l(), d.a.i0.a.a1.e.r(), e.b.f(), d.a.i0.a.e0.f.f.b.f(), d.a.i0.a.e0.f.f.b.d(), d.a.i0.a.e0.f.c.a.c(), e.f.f(), e.f.d(), d.a.i0.a.x0.a.d.a.f45575d};

    @Override // d.a.i0.a.n0.j.d.a
    public ArraySet<String> a() {
        ArraySet<String> arraySet = new ArraySet<>();
        for (String str : this.f43445a) {
            String J = d.a.i0.t.d.J(str);
            if (!TextUtils.isEmpty(J)) {
                arraySet.add(J);
            }
        }
        d.a.i0.a.e0.d.h("SwanSandboxFileCollector", "recovery renameAllFiles:" + arraySet.toString());
        return arraySet;
    }
}
