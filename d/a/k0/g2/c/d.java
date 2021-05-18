package d.a.k0.g2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.k0.g2.e.h;
import d.a.k0.x.b0;
/* loaded from: classes5.dex */
public class d extends d.a.c.j.e.a<h, CardViewHolder<d.a.k0.g2.g.g>> {
    public TbPageContext m;
    public b0<h> n;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.k0.g2.g.g> P(ViewGroup viewGroup) {
        d.a.k0.g2.g.g gVar = new d.a.k0.g2.g.g(this.m);
        gVar.o(this.n);
        return new CardViewHolder<>(gVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, h hVar, CardViewHolder<d.a.k0.g2.g.g> cardViewHolder) {
        cardViewHolder.b().m(hVar);
        return cardViewHolder.a();
    }

    public void g0(b0<h> b0Var) {
        this.n = b0Var;
    }
}
