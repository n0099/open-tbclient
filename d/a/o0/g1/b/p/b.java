package d.a.o0.g1.b.p;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.c.k.e.w;
import d.a.o0.z.b0;
/* loaded from: classes4.dex */
public class b extends d.a.c.k.e.a<a, CardViewHolder<c>> {
    public TbPageContext<?> m;
    public b0 n;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
        this.m = tbPageContext;
    }

    @Override // d.a.c.k.e.a
    public w A() {
        return super.A();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<c> Q(ViewGroup viewGroup) {
        c cVar = new c(this.m, viewGroup);
        b0 b0Var = this.n;
        if (b0Var != null) {
            cVar.p(b0Var);
        }
        return new CardViewHolder<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, a aVar, CardViewHolder<c> cardViewHolder) {
        if (aVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(aVar);
        return cardViewHolder.a();
    }

    public void h0(b0 b0Var) {
        this.n = b0Var;
    }
}
