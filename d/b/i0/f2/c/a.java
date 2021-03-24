package d.b.i0.f2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class a extends d.b.b.j.e.a<d.b.i0.f2.e.d, CardViewHolder<d.b.i0.f2.g.a>> {
    public TbPageContext m;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    public void h0() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public CardViewHolder<d.b.i0.f2.g.a> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.f2.g.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.f2.e.d dVar, CardViewHolder<d.b.i0.f2.g.a> cardViewHolder) {
        cardViewHolder.b().n(dVar);
        return cardViewHolder.a();
    }

    public void l0() {
    }
}
