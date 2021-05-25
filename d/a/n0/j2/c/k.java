package d.a.n0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class k extends d.a.c.j.e.a<d.a.n0.j2.e.k, CardViewHolder<d.a.n0.j2.j.i>> {
    public TbPageContext<?> m;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.j2.e.k.f56422i);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.n0.j2.j.i> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.j2.j.i(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.j2.e.k kVar, CardViewHolder<d.a.n0.j2.j.i> cardViewHolder) {
        cardViewHolder.b().m(kVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
