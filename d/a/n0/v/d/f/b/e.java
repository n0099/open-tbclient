package d.a.n0.v.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.SpecialLiveDoubleViewHolder;
import d.a.n0.v.d.g.d.f;
/* loaded from: classes4.dex */
public class e extends d.a.c.j.e.a<d.a.n0.v.d.g.b.b, SpecialLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public d.a.n0.v.d.f.e.a.b n;
    public f o;
    public int p;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.d.g.b.b.f61786g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public SpecialLiveDoubleViewHolder P(ViewGroup viewGroup) {
        d.a.n0.v.d.f.e.a.b bVar = new d.a.n0.v.d.f.e.a.b(this.m, viewGroup);
        this.n = bVar;
        f fVar = this.o;
        if (fVar != null) {
            bVar.u(fVar);
        }
        return new SpecialLiveDoubleViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.v.d.g.b.b bVar, SpecialLiveDoubleViewHolder specialLiveDoubleViewHolder) {
        specialLiveDoubleViewHolder.f13894a.t(bVar, this.p);
        return specialLiveDoubleViewHolder.a();
    }

    public void g0(int i2) {
        this.p = i2;
    }

    public void h0(f fVar) {
        this.o = fVar;
        d.a.n0.v.d.f.e.a.b bVar = this.n;
        if (bVar != null) {
            bVar.u(fVar);
        }
    }
}
