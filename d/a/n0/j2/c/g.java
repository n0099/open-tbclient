package d.a.n0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class g extends d.a.c.k.e.a<d.a.n0.j2.e.h, CardViewHolder<d.a.n0.j2.j.f>> {
    public TbPageContext m;
    public View.OnClickListener n;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.n0.j2.j.f> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.j2.j.f(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.j2.e.h hVar, CardViewHolder<d.a.n0.j2.j.f> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null || hVar == null) {
            return null;
        }
        cardViewHolder.b().n(hVar);
        if (cardViewHolder.b().m() != null) {
            cardViewHolder.b().m().setOnClickListener(this.n);
        }
        return cardViewHolder.b().m();
    }

    public void h0(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }
}
