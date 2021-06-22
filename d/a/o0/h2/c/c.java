package d.a.o0.h2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class c extends d.a.c.k.e.a<d.a.o0.h2.e.g, CardViewHolder<d.a.o0.h2.g.f>> {
    public TbPageContext m;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.o0.h2.g.f> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.o0.h2.g.f(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.h2.e.g gVar, CardViewHolder<d.a.o0.h2.g.f> cardViewHolder) {
        cardViewHolder.b().n(gVar);
        return cardViewHolder.a();
    }
}
