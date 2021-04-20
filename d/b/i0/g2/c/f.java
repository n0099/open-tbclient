package d.b.i0.g2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.g2.e.k;
/* loaded from: classes3.dex */
public class f extends d.b.c.j.e.a<k, CardViewHolder<d.b.i0.g2.g.d>> {
    public TbPageContext m;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.g2.g.d> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.g2.g.d(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, k kVar, CardViewHolder<d.b.i0.g2.g.d> cardViewHolder) {
        cardViewHolder.b().n(kVar);
        return cardViewHolder.a();
    }
}
