package d.b.i0.o0.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class a extends d.b.b.j.e.a<d.b.i0.o0.c.a, CardViewHolder<d.b.i0.o0.d.a>> {
    public TbPageContext m;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.o0.d.a> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.o0.d.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.o0.c.a aVar, CardViewHolder<d.b.i0.o0.d.a> cardViewHolder) {
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.a();
    }
}
