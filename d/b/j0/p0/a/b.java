package d.b.j0.p0.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<d.b.j0.p0.c.a, CardViewHolder<d.b.j0.p0.d.b>> {
    public TbPageContext m;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.j0.p0.d.b> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.j0.p0.d.b(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.p0.c.a aVar, CardViewHolder<d.b.j0.p0.d.b> cardViewHolder) {
        cardViewHolder.b().n(aVar);
        return cardViewHolder.a();
    }
}
