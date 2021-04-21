package d.b.j0.t.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveNormalCardView;
/* loaded from: classes4.dex */
public class h extends d.b.c.j.e.a<d.b.j0.t.e.b.c, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder> {
    public TbPageContext m;
    public d.b.j0.t.c n;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder R(ViewGroup viewGroup) {
        return new AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder(new AlaGameFrsLiveNormalCardView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.e.b.c cVar, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder alaGameFrsNormalViewHolder) {
        alaGameFrsNormalViewHolder.f14668a.n(cVar);
        alaGameFrsNormalViewHolder.f14668a.w(this.n);
        return alaGameFrsNormalViewHolder.a();
    }

    public void j0(d.b.j0.t.c cVar) {
        this.n = cVar;
    }
}
