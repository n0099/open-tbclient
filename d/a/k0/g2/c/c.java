package d.a.k0.g2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class c extends d.a.c.j.e.a<d.a.k0.g2.e.g, CardViewHolder<d.a.k0.g2.g.f>> {
    public TbPageContext m;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.k0.g2.g.f> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.k0.g2.g.f(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.g2.e.g gVar, CardViewHolder<d.a.k0.g2.g.f> cardViewHolder) {
        cardViewHolder.b().m(gVar);
        return cardViewHolder.a();
    }
}
