package d.a.k0.f1.b.p;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.c.j.e.w;
import d.a.k0.x.b0;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<a, CardViewHolder<c>> {
    public TbPageContext<?> m;
    public b0 n;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<c> P(ViewGroup viewGroup) {
        c cVar = new c(this.m, viewGroup);
        b0 b0Var = this.n;
        if (b0Var != null) {
            cVar.o(b0Var);
        }
        return new CardViewHolder<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, a aVar, CardViewHolder<c> cardViewHolder) {
        if (aVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(aVar);
        return cardViewHolder.a();
    }

    public void g0(b0 b0Var) {
        this.n = b0Var;
    }

    @Override // d.a.c.j.e.a
    public w z() {
        return super.z();
    }
}
