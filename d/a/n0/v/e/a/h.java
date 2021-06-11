package d.a.n0.v.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveNormalCardView;
/* loaded from: classes4.dex */
public class h extends d.a.c.k.e.a<d.a.n0.v.e.b.c, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder> {
    public TbPageContext m;
    public d.a.n0.v.c n;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder Q(ViewGroup viewGroup) {
        return new AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder(new AlaGameFrsLiveNormalCardView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.v.e.b.c cVar, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder alaGameFrsNormalViewHolder) {
        alaGameFrsNormalViewHolder.f14021a.n(cVar);
        alaGameFrsNormalViewHolder.f14021a.v(this.n);
        return alaGameFrsNormalViewHolder.a();
    }

    public void h0(d.a.n0.v.c cVar) {
        this.n = cVar;
    }
}
