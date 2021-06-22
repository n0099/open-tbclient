package d.a.m0.h.x;

import d.a.m0.a.g1.f;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.p.b.a.k;
import d.a.m0.k.n;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class a implements k {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Integer> f51500a = new ArrayList<>();

    @Override // d.a.m0.a.p.b.a.k
    public void a(d.a.m0.a.y.b.a aVar) {
        if (aVar != null) {
            d(aVar.C("action"), aVar.C("menuItemName"));
        }
    }

    @Override // d.a.m0.a.p.b.a.k
    public void b(n nVar) {
        if (this.f51500a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f51500a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (nVar != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                nVar.j(id.intValue());
            }
        }
    }

    public final boolean c(n nVar, String str) {
        Integer a2 = b.a(str);
        if (a2 != null) {
            if (!this.f51500a.contains(a2)) {
                this.f51500a.add(a2);
            }
            if (nVar != null) {
                nVar.j(a2.intValue());
            }
            return true;
        }
        return false;
    }

    public final boolean d(String str, String str2) {
        if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
            f V = f.V();
            Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
            g W = V.W();
            d.a.m0.h.n.a aVar = W != null ? (d.a.m0.h.n.a) W.n(d.a.m0.h.n.a.class) : null;
            n j3 = aVar != null ? aVar.j3() : null;
            if (j3 != null && aVar != null) {
                aVar.x3(true);
            }
            return c(j3, str2);
        }
        return false;
    }
}
