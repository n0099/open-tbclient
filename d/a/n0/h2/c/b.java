package d.a.n0.h2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class b extends d.a.c.j.e.a<d.a.n0.h2.e.e, CardViewHolder<d.a.n0.h2.g.b>> {
    public TbPageContext m;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.n0.h2.g.b> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.h2.g.b(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.h2.e.e eVar, CardViewHolder<d.a.n0.h2.g.b> cardViewHolder) {
        cardViewHolder.b().m(eVar);
        return cardViewHolder.a();
    }
}
