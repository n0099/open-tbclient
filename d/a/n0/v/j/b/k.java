package d.a.n0.v.j.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.n0.v.j.d.n;
/* loaded from: classes4.dex */
public class k extends d.a.c.j.e.a<n, CardViewHolder<d.a.n0.v.j.h.c>> {
    public TbPageContext m;

    public k(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), n.f62069f);
        this.m = tbPageContext;
    }

    public final void e0(n nVar, d.a.n0.v.j.h.c cVar) {
        d.a.n0.v.j.d.c h2 = nVar.h();
        if (h2 != null && h2.a() != null && !TextUtils.isEmpty(h2.a().a())) {
            cVar.u(h2.a().a());
            cVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
            K();
            return;
        }
        cVar.r(8);
        K();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public CardViewHolder<d.a.n0.v.j.h.c> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.v.j.h.c(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, n nVar, CardViewHolder<d.a.n0.v.j.h.c> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        e0(nVar, cardViewHolder.b());
        return cardViewHolder.b().l();
    }
}
