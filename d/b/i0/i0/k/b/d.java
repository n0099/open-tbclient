package d.b.i0.i0.k.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.i0.k.c.e;
/* loaded from: classes4.dex */
public class d extends d.b.b.j.e.a<e, CardViewHolder<d.b.i0.i0.k.d.d>> {
    public TbPageContext<?> m;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), e.f55652f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.i0.k.d.d> R(ViewGroup viewGroup) {
        d.b.i0.i0.k.d.d dVar = new d.b.i0.i0.k.d.d(this.m);
        dVar.r(this.i);
        return new CardViewHolder<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, e eVar, CardViewHolder<d.b.i0.i0.k.d.d> cardViewHolder) {
        if (eVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(eVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
