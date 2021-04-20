package d.b.i0.t.j.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.t.j.d.n;
/* loaded from: classes4.dex */
public class k extends d.b.c.j.e.a<n, CardViewHolder<d.b.i0.t.j.h.c>> {
    public TbPageContext m;

    public k(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), n.f62437f);
        this.m = tbPageContext;
    }

    public final void h0(n nVar, d.b.i0.t.j.h.c cVar) {
        d.b.i0.t.j.d.c g2 = nVar.g();
        if (g2 != null && g2.a() != null && !TextUtils.isEmpty(g2.a().a())) {
            cVar.w(g2.a().a());
            cVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
            L();
            return;
        }
        cVar.s(8);
        L();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public CardViewHolder<d.b.i0.t.j.h.c> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.t.j.h.c(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, n nVar, CardViewHolder<d.b.i0.t.j.h.c> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        h0(nVar, cardViewHolder.b());
        return cardViewHolder.b().m();
    }
}
