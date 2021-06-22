package d.a.o0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class e extends d.a.c.k.e.a<d.a.o0.j2.e.g, CardViewHolder<d.a.o0.j2.j.e>> {
    public TbPageContext m;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.o0.j2.j.e> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.o0.j2.j.e(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.j2.e.g gVar, CardViewHolder<d.a.o0.j2.j.e> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null || gVar == null) {
            return null;
        }
        cardViewHolder.b().n(gVar);
        return cardViewHolder.b().m();
    }
}
