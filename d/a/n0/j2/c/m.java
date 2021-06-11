package d.a.n0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class m extends d.a.c.k.e.a<d.a.n0.j2.e.m, CardViewHolder<d.a.n0.j2.j.j>> {
    public TbPageContext<?> m;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.j2.e.m.f60121g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.n0.j2.j.j> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.j2.j.j(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.j2.e.m mVar, CardViewHolder<d.a.n0.j2.j.j> cardViewHolder) {
        cardViewHolder.b().n(mVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
