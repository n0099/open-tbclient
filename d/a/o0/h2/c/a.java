package d.a.o0.h2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class a extends d.a.c.k.e.a<d.a.o0.h2.e.d, CardViewHolder<d.a.o0.h2.g.a>> {
    public TbPageContext m;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    public void e0() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public CardViewHolder<d.a.o0.h2.g.a> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.o0.h2.g.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.h2.e.d dVar, CardViewHolder<d.a.o0.h2.g.a> cardViewHolder) {
        cardViewHolder.b().n(dVar);
        return cardViewHolder.a();
    }

    public void i0() {
    }
}
