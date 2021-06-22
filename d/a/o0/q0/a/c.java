package d.a.o0.q0.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class c extends d.a.c.k.e.a<d.a.o0.q0.c.b, CardViewHolder<d.a.o0.q0.d.d>> {
    public TbPageContext m;
    public View.OnClickListener n;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.o0.q0.d.d> Q(ViewGroup viewGroup) {
        d.a.o0.q0.d.d dVar = new d.a.o0.q0.d.d(this.m);
        dVar.v(this.n);
        return new CardViewHolder<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.q0.c.b bVar, CardViewHolder<d.a.o0.q0.d.d> cardViewHolder) {
        cardViewHolder.b().n(bVar);
        return cardViewHolder.a();
    }

    public void h0(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }
}
