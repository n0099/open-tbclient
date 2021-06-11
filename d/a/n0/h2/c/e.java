package d.a.n0.h2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.n0.h2.e.i;
import d.a.n0.h2.g.h;
/* loaded from: classes5.dex */
public class e extends d.a.c.k.e.a<i, CardViewHolder<h>> {
    public TbPageContext<?> m;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<h> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new h(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, i iVar, CardViewHolder<h> cardViewHolder) {
        cardViewHolder.b().n(iVar);
        return cardViewHolder.a();
    }
}
