package d.b.j0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes3.dex */
public class f extends d.b.c.j.e.a<d.b.j0.i2.e.o, CardViewHolder<d.b.j0.i2.j.n>> {
    public TbPageContext m;
    public View.OnClickListener n;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.j0.i2.j.n> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.j0.i2.j.n(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.i2.e.o oVar, CardViewHolder<d.b.j0.i2.j.n> cardViewHolder) {
        if (oVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(oVar);
        if (cardViewHolder.b().m() != null) {
            cardViewHolder.b().m().setOnClickListener(this.n);
        }
        return cardViewHolder.b().m();
    }

    public void j0(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }
}
