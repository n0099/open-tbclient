package d.b.i0.f2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.f2.e.h;
import d.b.i0.x.b0;
/* loaded from: classes5.dex */
public class d extends d.b.b.j.e.a<h, CardViewHolder<d.b.i0.f2.g.g>> {
    public TbPageContext m;
    public b0<h> n;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.f2.g.g> R(ViewGroup viewGroup) {
        d.b.i0.f2.g.g gVar = new d.b.i0.f2.g.g(this.m);
        gVar.q(this.n);
        return new CardViewHolder<>(gVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, h hVar, CardViewHolder<d.b.i0.f2.g.g> cardViewHolder) {
        cardViewHolder.b().n(hVar);
        return cardViewHolder.a();
    }

    public void j0(b0<h> b0Var) {
        this.n = b0Var;
    }
}
