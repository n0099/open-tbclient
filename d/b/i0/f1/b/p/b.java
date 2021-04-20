package d.b.i0.f1.b.p;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.c.j.e.w;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<a, CardViewHolder<c>> {
    public TbPageContext<?> m;
    public b0 n;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
        this.m = tbPageContext;
    }

    @Override // d.b.c.j.e.a
    public w A() {
        return super.A();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<c> R(ViewGroup viewGroup) {
        c cVar = new c(this.m, viewGroup);
        b0 b0Var = this.n;
        if (b0Var != null) {
            cVar.q(b0Var);
        }
        return new CardViewHolder<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, a aVar, CardViewHolder<c> cardViewHolder) {
        if (aVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(aVar);
        return cardViewHolder.a();
    }

    public void j0(b0 b0Var) {
        this.n = b0Var;
    }
}
