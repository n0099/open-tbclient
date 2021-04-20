package d.b.i0.a1.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class z extends d.b.c.j.e.a<d.b.i0.x.e0.o, CardViewHolder<d.b.i0.x.s>> {
    public TbPageContext<?> m;

    public z(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.x.e0.o.n);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder R(ViewGroup viewGroup) {
        d.b.i0.x.s sVar = new d.b.i0.x.s(this.m);
        sVar.w("c10718", "c10719", "c10742");
        return new CardViewHolder(sVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.o oVar, CardViewHolder cardViewHolder) {
        cardViewHolder.b().n(oVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        d.b.i0.x.t.b().a(new StatisticItem("c10718").param("obj_id", String.valueOf(oVar.f63800e)));
        return cardViewHolder.a();
    }
}
