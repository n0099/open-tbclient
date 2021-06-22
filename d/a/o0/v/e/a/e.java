package d.a.o0.v.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveGameCardView;
/* loaded from: classes4.dex */
public class e extends d.a.c.k.e.a<d.a.o0.v.e.b.c, AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder> {
    public TbPageContext m;
    public d.a.o0.v.c n;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder Q(ViewGroup viewGroup) {
        return new AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder(new AlaGameFrsLiveGameCardView(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.e.b.c cVar, AlaGameFrsLiveGameCardView.AlaGameFrsGameViewHolder alaGameFrsGameViewHolder) {
        alaGameFrsGameViewHolder.f14102a.n(cVar);
        alaGameFrsGameViewHolder.f14102a.v(this.n);
        return alaGameFrsGameViewHolder.a();
    }

    public void h0(d.a.o0.v.c cVar) {
        this.n = cVar;
    }
}
