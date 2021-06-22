package d.a.o0.h2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class b extends d.a.c.k.e.a<d.a.o0.h2.e.e, CardViewHolder<d.a.o0.h2.g.b>> {
    public TbPageContext m;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.o0.h2.g.b> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.o0.h2.g.b(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.h2.e.e eVar, CardViewHolder<d.a.o0.h2.g.b> cardViewHolder) {
        cardViewHolder.b().n(eVar);
        return cardViewHolder.a();
    }
}
