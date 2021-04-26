package d.a.j0.a1.j.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.j0.a1.j.a.c.d;
import d.a.j0.a1.j.a.e.e;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<d, CardViewHolder<e>> {
    public TbPageContext<?> m;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.j);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<e> P(ViewGroup viewGroup) {
        e eVar = new e(this.m);
        eVar.p(this.f40323i);
        return new CardViewHolder<>(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d dVar, CardViewHolder<e> cardViewHolder) {
        if (dVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(dVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
