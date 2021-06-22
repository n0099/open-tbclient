package d.a.o0.j2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes5.dex */
public class j extends d.a.c.k.e.a<d.a.o0.j2.e.j, CardViewHolder<d.a.o0.j2.j.h>> {
    public TbPageContext<?> m;
    public d.a.o0.j2.d.c n;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), d.a.o0.j2.e.j.f60234f, bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public CardViewHolder<d.a.o0.j2.j.h> Q(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.o0.j2.j.h(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.j2.e.j jVar, CardViewHolder<d.a.o0.j2.j.h> cardViewHolder) {
        d.a.o0.j2.j.h b2 = cardViewHolder.b();
        b2.n(jVar);
        b2.o(this.m, TbadkCoreApplication.getInst().getSkinType());
        b2.v(this.n);
        return cardViewHolder.a();
    }

    public void h0(d.a.o0.j2.d.c cVar) {
        this.n = cVar;
    }
}
