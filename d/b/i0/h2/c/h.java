package d.b.i0.h2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class h extends d.b.b.j.e.a<d.b.i0.h2.e.i, CardViewHolder<d.b.i0.h2.j.g>> {
    public TbPageContext<?> m;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), d.b.i0.h2.e.i.f55293g, bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.h2.j.g> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.h2.j.g(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.h2.e.i iVar, CardViewHolder<d.b.i0.h2.j.g> cardViewHolder) {
        cardViewHolder.b().n(iVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
