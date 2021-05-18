package d.a.k0.g2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class a extends d.a.c.j.e.a<d.a.k0.g2.e.d, CardViewHolder<d.a.k0.g2.g.a>> {
    public TbPageContext m;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    public void e0() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public CardViewHolder<d.a.k0.g2.g.a> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.k0.g2.g.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.g2.e.d dVar, CardViewHolder<d.a.k0.g2.g.a> cardViewHolder) {
        cardViewHolder.b().m(dVar);
        return cardViewHolder.a();
    }

    public void h0() {
    }
}
