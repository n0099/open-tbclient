package d.b.i0.e.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.i0.e.e.f;
import d.b.i0.s2.t;
/* loaded from: classes4.dex */
public class a extends f {
    public t m;

    public a(t tVar, BdUniqueId bdUniqueId) {
        super(tVar.q().getPageActivity(), bdUniqueId);
        this.m = tVar;
    }

    @Override // d.b.c.j.e.a
    public View I(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            d.b.i0.e.e.a injectPlugin = ((d.b.i0.e.e.b) this.m).getInjectPlugin(1);
            if (injectPlugin instanceof d) {
                return ((d) injectPlugin).k(i, view, viewGroup, bVar.a());
            }
            return null;
        }
        return null;
    }

    @Override // d.b.c.j.e.a
    public TypeAdapter.ViewHolder S(ViewGroup viewGroup, Object obj) {
        if (b.j(G()) != -1 && (obj instanceof b)) {
            d.b.i0.e.e.a injectPlugin = ((d.b.i0.e.e.b) this.m).getInjectPlugin(1);
            if (injectPlugin instanceof d) {
                return ((d) injectPlugin).o(viewGroup, ((b) obj).a());
            }
            return null;
        }
        return null;
    }

    @Override // d.b.c.j.e.a
    public void Y(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        if (obj instanceof b) {
            d.b.i0.e.e.a injectPlugin = ((d.b.i0.e.e.b) this.m).getInjectPlugin(1);
            if (injectPlugin instanceof d) {
                ((d) injectPlugin).l(i, viewGroup, viewHolder, ((b) obj).a());
            }
        }
    }
}
