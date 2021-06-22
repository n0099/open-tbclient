package d.a.o0.v.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.SpecialLiveDoubleViewHolder;
import d.a.o0.v.d.g.d.f;
/* loaded from: classes4.dex */
public class e extends d.a.c.k.e.a<d.a.o0.v.d.g.b.b, SpecialLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public d.a.o0.v.d.f.e.a.b n;
    public f o;
    public int p;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.v.d.g.b.b.f65626g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public SpecialLiveDoubleViewHolder Q(ViewGroup viewGroup) {
        d.a.o0.v.d.f.e.a.b bVar = new d.a.o0.v.d.f.e.a.b(this.m, viewGroup);
        this.n = bVar;
        f fVar = this.o;
        if (fVar != null) {
            bVar.v(fVar);
        }
        return new SpecialLiveDoubleViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.d.g.b.b bVar, SpecialLiveDoubleViewHolder specialLiveDoubleViewHolder) {
        specialLiveDoubleViewHolder.f14033a.u(bVar, this.p);
        return specialLiveDoubleViewHolder.a();
    }

    public void h0(int i2) {
        this.p = i2;
    }

    public void i0(f fVar) {
        this.o = fVar;
        d.a.o0.v.d.f.e.a.b bVar = this.n;
        if (bVar != null) {
            bVar.v(fVar);
        }
    }
}
