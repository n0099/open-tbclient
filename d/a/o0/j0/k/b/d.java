package d.a.o0.j0.k.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.o0.j0.k.c.e;
/* loaded from: classes4.dex */
public class d extends d.a.c.k.e.a<e, CardViewHolder<d.a.o0.j0.k.d.d>> {
    public TbPageContext<?> m;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), e.f59833f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.o0.j0.k.d.d> Q(ViewGroup viewGroup) {
        d.a.o0.j0.k.d.d dVar = new d.a.o0.j0.k.d.d(this.m);
        dVar.q(this.f43016i);
        return new CardViewHolder<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, e eVar, CardViewHolder<d.a.o0.j0.k.d.d> cardViewHolder) {
        if (eVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(eVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
