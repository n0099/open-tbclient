package d.b.j0.g2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes3.dex */
public class a extends d.b.c.j.e.a<d.b.j0.g2.e.d, CardViewHolder<d.b.j0.g2.g.a>> {
    public TbPageContext m;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    public void h0() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public CardViewHolder<d.b.j0.g2.g.a> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.j0.g2.g.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.g2.e.d dVar, CardViewHolder<d.b.j0.g2.g.a> cardViewHolder) {
        cardViewHolder.b().n(dVar);
        return cardViewHolder.a();
    }

    public void l0() {
    }
}
