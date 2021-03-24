package d.b.i0.f2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.f2.e.n;
/* loaded from: classes5.dex */
public class g extends d.b.b.j.e.a<n, CardViewHolder<d.b.i0.f2.g.e>> {
    public TbPageContext m;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.f2.g.e> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.f2.g.e(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, n nVar, CardViewHolder<d.b.i0.f2.g.e> cardViewHolder) {
        cardViewHolder.b().n(nVar);
        return cardViewHolder.a();
    }
}
