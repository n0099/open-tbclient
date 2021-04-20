package d.b.i0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes3.dex */
public class j extends d.b.c.j.e.a<d.b.i0.i2.e.j, CardViewHolder<d.b.i0.i2.j.h>> {
    public TbPageContext<?> m;
    public d.b.i0.i2.d.c n;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), d.b.i0.i2.e.j.f57155f, bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.b.i0.i2.j.h> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.i2.j.h(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.i2.e.j jVar, CardViewHolder<d.b.i0.i2.j.h> cardViewHolder) {
        d.b.i0.i2.j.h b2 = cardViewHolder.b();
        b2.n(jVar);
        b2.o(this.m, TbadkCoreApplication.getInst().getSkinType());
        b2.w(this.n);
        return cardViewHolder.a();
    }

    public void j0(d.b.i0.i2.d.c cVar) {
        this.n = cVar;
    }
}
