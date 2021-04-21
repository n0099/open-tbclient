package d.b.j0.t.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveGameCardView;
/* loaded from: classes4.dex */
public class e extends d.b.c.j.e.a<d.b.j0.t.e.b.c, AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder> {
    public TbPageContext m;
    public d.b.j0.t.c n;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder R(ViewGroup viewGroup) {
        return new AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder(new AlaGameFrsLiveGameCardView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.e.b.c cVar, AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder alaGameFrsGameViewHolder) {
        alaGameFrsGameViewHolder.f14667a.n(cVar);
        alaGameFrsGameViewHolder.f14667a.w(this.n);
        return alaGameFrsGameViewHolder.a();
    }

    public void j0(d.b.j0.t.c cVar) {
        this.n = cVar;
    }
}
