package d.a.j0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class j extends d.a.c.j.e.a<d.a.j0.i2.e.j, CardViewHolder<d.a.j0.i2.j.h>> {
    public TbPageContext<?> m;
    public d.a.j0.i2.d.c n;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), d.a.j0.i2.e.j.f55529f, bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.j0.i2.j.h> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.j0.i2.j.h(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.i2.e.j jVar, CardViewHolder<d.a.j0.i2.j.h> cardViewHolder) {
        d.a.j0.i2.j.h b2 = cardViewHolder.b();
        b2.m(jVar);
        b2.n(this.m, TbadkCoreApplication.getInst().getSkinType());
        b2.u(this.n);
        return cardViewHolder.a();
    }

    public void g0(d.a.j0.i2.d.c cVar) {
        this.n = cVar;
    }
}
