package d.a.o0.b1.k.b.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.c.e.p.l;
import d.a.o0.b1.k.b.c.c;
/* loaded from: classes4.dex */
public class b extends d.a.c.k.e.a<c, CardViewHolder<d.a.o0.b1.k.b.d.b>> {
    public TbPageContext<?> m;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.f55811g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.o0.b1.k.b.d.b> Q(ViewGroup viewGroup) {
        d.a.o0.b1.k.b.d.b bVar = new d.a.o0.b1.k.b.d.b(this.m);
        bVar.q(this.f43016i);
        CardViewHolder<d.a.o0.b1.k.b.d.b> cardViewHolder = new CardViewHolder<>(bVar);
        int g2 = l.g(this.m.getPageActivity(), R.dimen.tbds44);
        cardViewHolder.a().setPadding(g2, 0, g2, 0);
        return cardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, c cVar, CardViewHolder<d.a.o0.b1.k.b.d.b> cardViewHolder) {
        if (cVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(cVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
