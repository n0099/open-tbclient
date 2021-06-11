package d.a.n0.b1.k.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.n0.b1.k.a.c.d;
import d.a.n0.b1.k.a.e.e;
/* loaded from: classes4.dex */
public class c extends d.a.c.k.e.a<d, CardViewHolder<e>> {
    public TbPageContext<?> m;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.j);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<e> Q(ViewGroup viewGroup) {
        e eVar = new e(this.m);
        eVar.q(this.f42913i);
        return new CardViewHolder<>(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d dVar, CardViewHolder<e> cardViewHolder) {
        if (dVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(dVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
