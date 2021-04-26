package d.a.j0.i0.k.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.j0.x.b0;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<d.a.j0.i0.k.c.d, CardViewHolder<d.a.j0.i0.k.d.c>> {
    public TbPageContext<?> m;
    public b0 n;

    public c(TbPageContext tbPageContext, b0 b0Var) {
        super(tbPageContext.getPageActivity(), d.a.j0.i0.k.c.d.j);
        this.m = tbPageContext;
        this.n = b0Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.j0.i0.k.d.c> P(ViewGroup viewGroup) {
        d.a.j0.i0.k.d.c cVar = new d.a.j0.i0.k.d.c(this.m);
        cVar.p(this.f40323i);
        return new CardViewHolder<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.i0.k.c.d dVar, CardViewHolder<d.a.j0.i0.k.d.c> cardViewHolder) {
        if (dVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        if (viewGroup instanceof BdTypeRecyclerView) {
            cardViewHolder.b().u(dVar.needTopMargin);
        }
        cardViewHolder.b().m(dVar);
        if (this.n != null) {
            cardViewHolder.b().o(this.n);
        }
        return cardViewHolder.a();
    }
}
