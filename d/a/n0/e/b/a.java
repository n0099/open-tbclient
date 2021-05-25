package d.a.n0.e.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.a.n0.e.e.f;
import d.a.n0.t2.u;
/* loaded from: classes4.dex */
public class a extends f {
    public u m;

    public a(u uVar, BdUniqueId bdUniqueId) {
        super(uVar.o().getPageActivity(), bdUniqueId);
        this.m = uVar;
    }

    @Override // d.a.c.j.e.a
    public View H(int i2, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            d.a.n0.e.e.a injectPlugin = ((d.a.n0.e.e.b) this.m).getInjectPlugin(1);
            if (injectPlugin instanceof d) {
                return ((d) injectPlugin).l(i2, view, viewGroup, bVar.c());
            }
            return null;
        }
        return null;
    }

    @Override // d.a.c.j.e.a
    public TypeAdapter.ViewHolder Q(ViewGroup viewGroup, Object obj) {
        if (b.i(G()) != -1 && (obj instanceof b)) {
            d.a.n0.e.e.a injectPlugin = ((d.a.n0.e.e.b) this.m).getInjectPlugin(1);
            if (injectPlugin instanceof d) {
                return ((d) injectPlugin).f(viewGroup, ((b) obj).c());
            }
            return null;
        }
        return null;
    }

    @Override // d.a.c.j.e.a
    public void X(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        if (obj instanceof b) {
            d.a.n0.e.e.a injectPlugin = ((d.a.n0.e.e.b) this.m).getInjectPlugin(1);
            if (injectPlugin instanceof d) {
                ((d) injectPlugin).m(i2, viewGroup, viewHolder, ((b) obj).c());
            }
        }
    }
}
