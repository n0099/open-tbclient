package d.a.n0.r0.s1.a.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemView;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.n0.r0.s1.a.a.b, FrsGameStrategyItemView.FrsGameStrategyItemViewHolder> {
    public TbPageContext m;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public FrsGameStrategyItemView.FrsGameStrategyItemViewHolder P(ViewGroup viewGroup) {
        return new FrsGameStrategyItemView.FrsGameStrategyItemViewHolder(new FrsGameStrategyItemView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.r0.s1.a.a.b bVar, FrsGameStrategyItemView.FrsGameStrategyItemViewHolder frsGameStrategyItemViewHolder) {
        frsGameStrategyItemViewHolder.f15442a.m(bVar);
        return frsGameStrategyItemViewHolder.a();
    }
}
