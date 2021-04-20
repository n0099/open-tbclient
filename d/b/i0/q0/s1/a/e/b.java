package d.b.i0.q0.s1.a.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemView;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<d.b.i0.q0.s1.a.a.b, FrsGameStrategyItemView.FrsGameStrategyItemViewHolder> {
    public TbPageContext m;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public FrsGameStrategyItemView.FrsGameStrategyItemViewHolder R(ViewGroup viewGroup) {
        return new FrsGameStrategyItemView.FrsGameStrategyItemViewHolder(new FrsGameStrategyItemView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.q0.s1.a.a.b bVar, FrsGameStrategyItemView.FrsGameStrategyItemViewHolder frsGameStrategyItemViewHolder) {
        frsGameStrategyItemViewHolder.f16015a.n(bVar);
        return frsGameStrategyItemViewHolder.a();
    }
}
