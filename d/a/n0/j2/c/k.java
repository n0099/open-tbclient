package d.a.n0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class k extends d.a.c.k.e.a<d.a.n0.j2.e.k, CardViewHolder<d.a.n0.j2.j.i>> {
    public TbPageContext<?> m;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.j2.e.k.f60111i);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.n0.j2.j.i> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.j2.j.i(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.j2.e.k kVar, CardViewHolder<d.a.n0.j2.j.i> cardViewHolder) {
        cardViewHolder.b().n(kVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
