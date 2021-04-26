package d.a.j0.p0.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<d.a.j0.p0.c.b, CardViewHolder<d.a.j0.p0.d.d>> {
    public TbPageContext m;
    public View.OnClickListener n;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.j0.p0.d.d> P(ViewGroup viewGroup) {
        d.a.j0.p0.d.d dVar = new d.a.j0.p0.d.d(this.m);
        dVar.u(this.n);
        return new CardViewHolder<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.p0.c.b bVar, CardViewHolder<d.a.j0.p0.d.d> cardViewHolder) {
        cardViewHolder.b().m(bVar);
        return cardViewHolder.a();
    }

    public void g0(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }
}
