package d.a.j0.t.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveNormalCardView;
/* loaded from: classes4.dex */
public class h extends d.a.c.j.e.a<d.a.j0.t.e.b.c, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder> {
    public TbPageContext m;
    public d.a.j0.t.c n;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder P(ViewGroup viewGroup) {
        return new AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder(new AlaGameFrsLiveNormalCardView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.t.e.b.c cVar, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder alaGameFrsNormalViewHolder) {
        alaGameFrsNormalViewHolder.f14746a.m(cVar);
        alaGameFrsNormalViewHolder.f14746a.u(this.n);
        return alaGameFrsNormalViewHolder.a();
    }

    public void g0(d.a.j0.t.c cVar) {
        this.n = cVar;
    }
}
