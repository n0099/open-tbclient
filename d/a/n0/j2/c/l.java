package d.a.n0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class l extends d.a.c.j.e.a<d.a.n0.j2.e.l, CardViewHolder<d.a.n0.j2.j.o>> {
    public TbPageContext<?> m;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.j2.e.l.f56427i);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.n0.j2.j.o> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.j2.j.o(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.j2.e.l lVar, CardViewHolder<d.a.n0.j2.j.o> cardViewHolder) {
        cardViewHolder.b().m(lVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
