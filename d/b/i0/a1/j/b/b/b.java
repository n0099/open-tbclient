package d.b.i0.a1.j.b.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.c.e.p.l;
import d.b.i0.a1.j.b.c.c;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<c, CardViewHolder<d.b.i0.a1.j.b.d.b>> {
    public TbPageContext<?> m;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.f52985g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.a1.j.b.d.b> R(ViewGroup viewGroup) {
        d.b.i0.a1.j.b.d.b bVar = new d.b.i0.a1.j.b.d.b(this.m);
        bVar.r(this.i);
        CardViewHolder<d.b.i0.a1.j.b.d.b> cardViewHolder = new CardViewHolder<>(bVar);
        int g2 = l.g(this.m.getPageActivity(), R.dimen.tbds44);
        cardViewHolder.a().setPadding(g2, 0, g2, 0);
        return cardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, c cVar, CardViewHolder<d.b.i0.a1.j.b.d.b> cardViewHolder) {
        if (cVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(cVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
