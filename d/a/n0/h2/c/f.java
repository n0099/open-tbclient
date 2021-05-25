package d.a.n0.h2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.n0.h2.e.k;
/* loaded from: classes5.dex */
public class f extends d.a.c.j.e.a<k, CardViewHolder<d.a.n0.h2.g.d>> {
    public TbPageContext m;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.n0.h2.g.d> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.h2.g.d(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, k kVar, CardViewHolder<d.a.n0.h2.g.d> cardViewHolder) {
        cardViewHolder.b().m(kVar);
        return cardViewHolder.a();
    }
}
