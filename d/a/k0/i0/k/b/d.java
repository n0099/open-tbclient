package d.a.k0.i0.k.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.k0.i0.k.c.e;
/* loaded from: classes4.dex */
public class d extends d.a.c.j.e.a<e, CardViewHolder<d.a.k0.i0.k.d.d>> {
    public TbPageContext<?> m;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), e.f55835f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.k0.i0.k.d.d> P(ViewGroup viewGroup) {
        d.a.k0.i0.k.d.d dVar = new d.a.k0.i0.k.d.d(this.m);
        dVar.p(this.f39568i);
        return new CardViewHolder<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, e eVar, CardViewHolder<d.a.k0.i0.k.d.d> cardViewHolder) {
        if (eVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(eVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
