package d.a.c.j.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
/* loaded from: classes.dex */
public class h<V extends TypeAdapter.ViewHolder> extends a<g, V> {
    public a<n, V> m;

    public h(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    @Override // d.a.c.j.e.a
    public V P(ViewGroup viewGroup) {
        return Q(viewGroup, new g());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public V Q(ViewGroup viewGroup, g gVar) {
        V P;
        a<n, V> aVar = this.m;
        if (aVar == null) {
            return null;
        }
        if (this.f39231h == aVar.x()) {
            P = this.m.O(viewGroup, gVar.h());
        } else if (this.f39231h == this.m.v()) {
            P = this.m.M(viewGroup, gVar.h());
        } else if (this.f39231h == this.m.w()) {
            P = this.m.N(viewGroup, gVar.h());
        } else if (this.f39231h == this.m.u()) {
            P = this.m.L(viewGroup, gVar.h());
        } else {
            P = this.m.P(viewGroup);
        }
        if (P != null) {
            Z(this.m.z());
            return P;
        }
        throw new NullPointerException("Order error or holder created is NullPointerException");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, g gVar, V v) {
        a<n, V> aVar = this.m;
        if (aVar == null) {
            return null;
        }
        if (this.f39231h == aVar.x()) {
            return this.m.V(i2, view, viewGroup, gVar.h(), v);
        }
        if (this.f39231h == this.m.v()) {
            return this.m.S(i2, view, viewGroup, gVar.h(), v);
        }
        if (this.f39231h == this.m.w()) {
            return this.m.T(i2, view, viewGroup, gVar.h(), v);
        }
        if (this.f39231h == this.m.u()) {
            return this.m.R(i2, view, viewGroup, gVar.h(), v);
        }
        return this.m.W(i2, view, viewGroup, gVar.h(), v);
    }

    public void g0(a aVar) {
        this.m = aVar;
    }
}
