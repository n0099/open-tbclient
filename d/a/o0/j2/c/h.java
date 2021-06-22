package d.a.o0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class h extends d.a.c.k.e.a<d.a.o0.j2.e.i, CardViewHolder<d.a.o0.j2.j.g>> {
    public TbPageContext<?> m;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), d.a.o0.j2.e.i.f60231g, bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.o0.j2.j.g> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.o0.j2.j.g(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.j2.e.i iVar, CardViewHolder<d.a.o0.j2.j.g> cardViewHolder) {
        cardViewHolder.b().n(iVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
