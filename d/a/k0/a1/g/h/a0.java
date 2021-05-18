package d.a.k0.a1.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class a0 extends d.a.c.j.e.a<d.a.k0.x.e0.o, CardViewHolder<d.a.k0.x.s>> {
    public TbPageContext<?> m;

    public a0(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.x.e0.o.n);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public CardViewHolder P(ViewGroup viewGroup) {
        d.a.k0.x.s sVar = new d.a.k0.x.s(this.m);
        sVar.u("c10718", "c10719", "c10742");
        return new CardViewHolder(sVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.o oVar, CardViewHolder cardViewHolder) {
        cardViewHolder.b().m(oVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        d.a.k0.x.t.b().a(new StatisticItem("c10718").param("obj_id", String.valueOf(oVar.f63210e)));
        return cardViewHolder.a();
    }
}
