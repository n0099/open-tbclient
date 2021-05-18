package d.a.k0.t.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveGameCardView;
/* loaded from: classes4.dex */
public class e extends d.a.c.j.e.a<d.a.k0.t.e.b.c, AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder> {
    public TbPageContext m;
    public d.a.k0.t.c n;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder P(ViewGroup viewGroup) {
        return new AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder(new AlaGameFrsLiveGameCardView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.t.e.b.c cVar, AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder alaGameFrsGameViewHolder) {
        alaGameFrsGameViewHolder.f14060a.m(cVar);
        alaGameFrsGameViewHolder.f14060a.u(this.n);
        return alaGameFrsGameViewHolder.a();
    }

    public void g0(d.a.k0.t.c cVar) {
        this.n = cVar;
    }
}
