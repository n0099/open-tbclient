package d.a.o0.h2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.o0.h2.e.n;
/* loaded from: classes5.dex */
public class g extends d.a.c.k.e.a<n, CardViewHolder<d.a.o0.h2.g.e>> {
    public TbPageContext m;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.o0.h2.g.e> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.o0.h2.g.e(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, n nVar, CardViewHolder<d.a.o0.h2.g.e> cardViewHolder) {
        cardViewHolder.b().n(nVar);
        return cardViewHolder.a();
    }
}
