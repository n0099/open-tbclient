package d.a.j0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class h extends d.a.c.j.e.a<d.a.j0.i2.e.i, CardViewHolder<d.a.j0.i2.j.g>> {
    public TbPageContext<?> m;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), d.a.j0.i2.e.i.f55526g, bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.j0.i2.j.g> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.j0.i2.j.g(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.i2.e.i iVar, CardViewHolder<d.a.j0.i2.j.g> cardViewHolder) {
        cardViewHolder.b().m(iVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
