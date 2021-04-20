package d.b.i0.t.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.SpecialLiveDoubleViewHolder;
import d.b.i0.t.d.g.d.g;
/* loaded from: classes4.dex */
public class f extends d.b.c.j.e.a<d.b.i0.t.d.g.b.b, SpecialLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public d.b.i0.t.d.f.e.a.d n;
    public g o;
    public int p;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.d.g.b.b.f62171g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public SpecialLiveDoubleViewHolder R(ViewGroup viewGroup) {
        d.b.i0.t.d.f.e.a.d dVar = new d.b.i0.t.d.f.e.a.d(this.m, viewGroup);
        this.n = dVar;
        g gVar = this.o;
        if (gVar != null) {
            dVar.w(gVar);
        }
        return new SpecialLiveDoubleViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.d.g.b.b bVar, SpecialLiveDoubleViewHolder specialLiveDoubleViewHolder) {
        specialLiveDoubleViewHolder.f14595a.v(bVar, this.p);
        return specialLiveDoubleViewHolder.a();
    }

    public void j0(int i) {
        this.p = i;
    }

    public void l0(g gVar) {
        this.o = gVar;
        d.b.i0.t.d.f.e.a.d dVar = this.n;
        if (dVar != null) {
            dVar.w(gVar);
        }
    }
}
