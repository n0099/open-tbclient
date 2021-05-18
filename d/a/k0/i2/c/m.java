package d.a.k0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class m extends d.a.c.j.e.a<d.a.k0.i2.e.m, CardViewHolder<d.a.k0.i2.j.j>> {
    public TbPageContext<?> m;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.i2.e.m.f56248g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.k0.i2.j.j> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.k0.i2.j.j(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.i2.e.m mVar, CardViewHolder<d.a.k0.i2.j.j> cardViewHolder) {
        cardViewHolder.b().m(mVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
