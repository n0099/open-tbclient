package d.a.n0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class c extends d.a.c.j.e.a<d.a.n0.j2.e.d, CardViewHolder<d.a.n0.j2.j.c>> {
    public TbPageContext<?> m;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.j2.e.d.k);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.n0.j2.j.c> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.j2.j.c(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.j2.e.d dVar, CardViewHolder<d.a.n0.j2.j.c> cardViewHolder) {
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().m(dVar);
        return cardViewHolder.a();
    }
}
