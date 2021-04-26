package d.a.j0.g2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.j0.g2.e.i;
import d.a.j0.g2.g.h;
/* loaded from: classes4.dex */
public class e extends d.a.c.j.e.a<i, CardViewHolder<h>> {
    public TbPageContext<?> m;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<h> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new h(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, i iVar, CardViewHolder<h> cardViewHolder) {
        cardViewHolder.b().m(iVar);
        return cardViewHolder.a();
    }
}
