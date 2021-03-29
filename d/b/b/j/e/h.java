package d.b.b.j.e;

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

    @Override // d.b.b.j.e.a
    public V R(ViewGroup viewGroup) {
        return S(viewGroup, new g());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public V S(ViewGroup viewGroup, g gVar) {
        V R;
        a<n, V> aVar = this.m;
        if (aVar == null) {
            return null;
        }
        if (this.f42361h == aVar.y()) {
            R = this.m.Q(viewGroup, gVar.g());
        } else if (this.f42361h == this.m.w()) {
            R = this.m.O(viewGroup, gVar.g());
        } else if (this.f42361h == this.m.x()) {
            R = this.m.P(viewGroup, gVar.g());
        } else if (this.f42361h == this.m.v()) {
            R = this.m.M(viewGroup, gVar.g());
        } else {
            R = this.m.R(viewGroup);
        }
        if (R != null) {
            c0(this.m.A());
            return R;
        }
        throw new NullPointerException("Order error or holder created is NullPointerException");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, g gVar, V v) {
        a<n, V> aVar = this.m;
        if (aVar == null) {
            return null;
        }
        if (this.f42361h == aVar.y()) {
            return this.m.W(i, view, viewGroup, gVar.g(), v);
        }
        if (this.f42361h == this.m.w()) {
            return this.m.U(i, view, viewGroup, gVar.g(), v);
        }
        if (this.f42361h == this.m.x()) {
            return this.m.V(i, view, viewGroup, gVar.g(), v);
        }
        if (this.f42361h == this.m.v()) {
            return this.m.T(i, view, viewGroup, gVar.g(), v);
        }
        return this.m.X(i, view, viewGroup, gVar.g(), v);
    }

    public void j0(a aVar) {
        this.m = aVar;
    }
}
