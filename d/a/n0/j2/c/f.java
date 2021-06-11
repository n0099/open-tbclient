package d.a.n0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class f extends d.a.c.k.e.a<d.a.n0.j2.e.o, CardViewHolder<d.a.n0.j2.j.n>> {
    public TbPageContext m;
    public View.OnClickListener n;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.n0.j2.j.n> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.j2.j.n(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.j2.e.o oVar, CardViewHolder<d.a.n0.j2.j.n> cardViewHolder) {
        if (oVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(oVar);
        if (cardViewHolder.b().m() != null) {
            cardViewHolder.b().m().setOnClickListener(this.n);
        }
        return cardViewHolder.b().m();
    }

    public void h0(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }
}
