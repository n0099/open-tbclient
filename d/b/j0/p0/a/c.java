package d.b.j0.p0.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class c extends d.b.c.j.e.a<d.b.j0.p0.c.b, CardViewHolder<d.b.j0.p0.d.d>> {
    public TbPageContext m;
    public View.OnClickListener n;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.j0.p0.d.d> R(ViewGroup viewGroup) {
        d.b.j0.p0.d.d dVar = new d.b.j0.p0.d.d(this.m);
        dVar.w(this.n);
        return new CardViewHolder<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.p0.c.b bVar, CardViewHolder<d.b.j0.p0.d.d> cardViewHolder) {
        cardViewHolder.b().n(bVar);
        return cardViewHolder.a();
    }

    public void j0(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }
}
