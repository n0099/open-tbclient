package d.b.j0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes3.dex */
public class e extends d.b.c.j.e.a<d.b.j0.i2.e.g, CardViewHolder<d.b.j0.i2.j.e>> {
    public TbPageContext m;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.j0.i2.j.e> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.j0.i2.j.e(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.i2.e.g gVar, CardViewHolder<d.b.j0.i2.j.e> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null || gVar == null) {
            return null;
        }
        cardViewHolder.b().n(gVar);
        return cardViewHolder.b().m();
    }
}
