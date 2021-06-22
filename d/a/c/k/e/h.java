package d.a.c.k.e;

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

    @Override // d.a.c.k.e.a
    public V Q(ViewGroup viewGroup) {
        return R(viewGroup, new g());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public V R(ViewGroup viewGroup, g gVar) {
        V Q;
        a<n, V> aVar = this.m;
        if (aVar == null) {
            return null;
        }
        if (this.f43015h == aVar.y()) {
            Q = this.m.P(viewGroup, gVar.c());
        } else if (this.f43015h == this.m.w()) {
            Q = this.m.N(viewGroup, gVar.c());
        } else if (this.f43015h == this.m.x()) {
            Q = this.m.O(viewGroup, gVar.c());
        } else if (this.f43015h == this.m.v()) {
            Q = this.m.M(viewGroup, gVar.c());
        } else {
            Q = this.m.Q(viewGroup);
        }
        if (Q != null) {
            a0(this.m.A());
            return Q;
        }
        throw new NullPointerException("Order error or holder created is NullPointerException");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, g gVar, V v) {
        a<n, V> aVar = this.m;
        if (aVar == null) {
            return null;
        }
        if (this.f43015h == aVar.y()) {
            return this.m.V(i2, view, viewGroup, gVar.c(), v);
        }
        if (this.f43015h == this.m.w()) {
            return this.m.T(i2, view, viewGroup, gVar.c(), v);
        }
        if (this.f43015h == this.m.x()) {
            return this.m.U(i2, view, viewGroup, gVar.c(), v);
        }
        if (this.f43015h == this.m.v()) {
            return this.m.S(i2, view, viewGroup, gVar.c(), v);
        }
        return this.m.X(i2, view, viewGroup, gVar.c(), v);
    }

    public void h0(a aVar) {
        this.m = aVar;
    }
}
