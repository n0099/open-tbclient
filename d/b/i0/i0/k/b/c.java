package d.b.i0.i0.k.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class c extends d.b.b.j.e.a<d.b.i0.i0.k.c.d, CardViewHolder<d.b.i0.i0.k.d.c>> {
    public TbPageContext<?> m;
    public b0 n;

    public c(TbPageContext tbPageContext, b0 b0Var) {
        super(tbPageContext.getPageActivity(), d.b.i0.i0.k.c.d.j);
        this.m = tbPageContext;
        this.n = b0Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.i0.k.d.c> R(ViewGroup viewGroup) {
        d.b.i0.i0.k.d.c cVar = new d.b.i0.i0.k.d.c(this.m);
        cVar.r(this.i);
        return new CardViewHolder<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.i0.k.c.d dVar, CardViewHolder<d.b.i0.i0.k.d.c> cardViewHolder) {
        if (dVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        if (viewGroup instanceof BdTypeRecyclerView) {
            cardViewHolder.b().w(dVar.needTopMargin);
        }
        cardViewHolder.b().n(dVar);
        if (this.n != null) {
            cardViewHolder.b().q(this.n);
        }
        return cardViewHolder.a();
    }
}
