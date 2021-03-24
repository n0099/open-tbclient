package d.b.i0.f2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class b extends d.b.b.j.e.a<d.b.i0.f2.e.e, CardViewHolder<d.b.i0.f2.g.b>> {
    public TbPageContext m;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.f2.g.b> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.f2.g.b(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.f2.e.e eVar, CardViewHolder<d.b.i0.f2.g.b> cardViewHolder) {
        cardViewHolder.b().n(eVar);
        return cardViewHolder.a();
    }
}
