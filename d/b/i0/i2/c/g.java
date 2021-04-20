package d.b.i0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes3.dex */
public class g extends d.b.c.j.e.a<d.b.i0.i2.e.h, CardViewHolder<d.b.i0.i2.j.f>> {
    public TbPageContext m;
    public View.OnClickListener n;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.i2.j.f> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.i2.j.f(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.i2.e.h hVar, CardViewHolder<d.b.i0.i2.j.f> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.b() == null || hVar == null) {
            return null;
        }
        cardViewHolder.b().n(hVar);
        if (cardViewHolder.b().m() != null) {
            cardViewHolder.b().m().setOnClickListener(this.n);
        }
        return cardViewHolder.b().m();
    }

    public void j0(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }
}
