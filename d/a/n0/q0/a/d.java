package d.a.n0.q0.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class d extends d.a.c.k.e.a<d.a.n0.q0.c.a, CardViewHolder<d.a.n0.q0.d.c>> {
    public TbPageContext m;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.n0.q0.d.c> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.q0.d.c(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.q0.c.a aVar, CardViewHolder<d.a.n0.q0.d.c> cardViewHolder) {
        return cardViewHolder.a();
    }
}
