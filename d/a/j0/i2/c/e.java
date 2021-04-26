package d.a.j0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class e extends d.a.c.j.e.a<d.a.j0.i2.e.g, CardViewHolder<d.a.j0.i2.j.e>> {
    public TbPageContext m;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.j0.i2.j.e> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.j0.i2.j.e(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.i2.e.g gVar, CardViewHolder<d.a.j0.i2.j.e> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null || gVar == null) {
            return null;
        }
        cardViewHolder.b().m(gVar);
        return cardViewHolder.b().l();
    }
}
