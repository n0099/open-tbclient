package d.a.j0.a1.j.b.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.c.e.p.l;
import d.a.j0.a1.j.b.c.c;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<c, CardViewHolder<d.a.j0.a1.j.b.d.b>> {
    public TbPageContext<?> m;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.f51131g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.j0.a1.j.b.d.b> P(ViewGroup viewGroup) {
        d.a.j0.a1.j.b.d.b bVar = new d.a.j0.a1.j.b.d.b(this.m);
        bVar.p(this.f40323i);
        CardViewHolder<d.a.j0.a1.j.b.d.b> cardViewHolder = new CardViewHolder<>(bVar);
        int g2 = l.g(this.m.getPageActivity(), R.dimen.tbds44);
        cardViewHolder.a().setPadding(g2, 0, g2, 0);
        return cardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, c cVar, CardViewHolder<d.a.j0.a1.j.b.d.b> cardViewHolder) {
        if (cVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(cVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
