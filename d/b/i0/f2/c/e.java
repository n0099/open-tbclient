package d.b.i0.f2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.f2.e.i;
import d.b.i0.f2.g.h;
/* loaded from: classes5.dex */
public class e extends d.b.b.j.e.a<i, CardViewHolder<h>> {
    public TbPageContext<?> m;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<h> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new h(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, i iVar, CardViewHolder<h> cardViewHolder) {
        cardViewHolder.b().n(iVar);
        return cardViewHolder.a();
    }
}
