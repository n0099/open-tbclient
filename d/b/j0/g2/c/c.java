package d.b.j0.g2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes3.dex */
public class c extends d.b.c.j.e.a<d.b.j0.g2.e.g, CardViewHolder<d.b.j0.g2.g.f>> {
    public TbPageContext m;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.j0.g2.g.f> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.j0.g2.g.f(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.g2.e.g gVar, CardViewHolder<d.b.j0.g2.g.f> cardViewHolder) {
        cardViewHolder.b().n(gVar);
        return cardViewHolder.a();
    }
}
