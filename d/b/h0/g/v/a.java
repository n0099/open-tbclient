package d.b.h0.g.v;

import d.b.h0.a.e0.l.j;
import d.b.h0.a.z0.f;
import d.b.h0.g.e.d.c;
import d.b.h0.i.n;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Integer> f49305a = new ArrayList<>();

    public final void a(n nVar) {
        if (this.f49305a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f49305a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (nVar != null) {
                Intrinsics.checkExpressionValueIsNotNull(id, "id");
                nVar.k(id.intValue());
            }
        }
    }

    public final boolean b(n nVar, String str) {
        Integer a2 = b.a(str);
        if (a2 != null) {
            if (!this.f49305a.contains(a2)) {
                this.f49305a.add(a2);
            }
            if (nVar != null) {
                nVar.k(a2.intValue());
            }
            return true;
        }
        return false;
    }

    public final void c(c cVar) {
        if (cVar != null) {
            d(cVar.B("action"), cVar.B("menuItemName"));
        }
    }

    public final boolean d(String str, String str2) {
        if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
            f V = f.V();
            Intrinsics.checkExpressionValueIsNotNull(V, "SwanAppController.getInstance()");
            d.b.h0.a.e0.l.f W = V.W();
            j jVar = W != null ? (j) W.n(j.class) : null;
            n X2 = jVar != null ? jVar.X2() : null;
            if (X2 != null && jVar != null) {
                jVar.k3(true);
            }
            return b(X2, str2);
        }
        return false;
    }
}
