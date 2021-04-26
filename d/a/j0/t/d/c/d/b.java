package d.a.j0.t.d.c.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.OfficialRecommendLiveViewHolder;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.j0.t.d.c.e.c, OfficialRecommendLiveViewHolder> {
    public TbPageContext m;
    public d.a.j0.t.d.c.h.b n;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.j0.t.d.c.e.c.f60487f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public OfficialRecommendLiveViewHolder P(ViewGroup viewGroup) {
        this.n = new d.a.j0.t.d.c.h.b(this.m, viewGroup);
        return new OfficialRecommendLiveViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.t.d.c.e.c cVar, OfficialRecommendLiveViewHolder officialRecommendLiveViewHolder) {
        d.a.j0.t.d.c.h.b bVar;
        if (officialRecommendLiveViewHolder == null || (bVar = officialRecommendLiveViewHolder.f14550a) == null) {
            return null;
        }
        bVar.m(cVar);
        officialRecommendLiveViewHolder.f14550a.n(this.m, TbadkCoreApplication.getInst().getSkinType());
        return officialRecommendLiveViewHolder.a();
    }
}
