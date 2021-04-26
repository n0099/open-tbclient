package d.a.j0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class f extends d.a.c.j.e.a<d.a.j0.i2.e.o, CardViewHolder<d.a.j0.i2.j.n>> {
    public TbPageContext m;
    public View.OnClickListener n;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.j0.i2.j.n> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.j0.i2.j.n(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.i2.e.o oVar, CardViewHolder<d.a.j0.i2.j.n> cardViewHolder) {
        if (oVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(oVar);
        if (cardViewHolder.b().l() != null) {
            cardViewHolder.b().l().setOnClickListener(this.n);
        }
        return cardViewHolder.b().l();
    }

    public void g0(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }
}
