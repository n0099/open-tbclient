package d.b.i0.t.d.c.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.OfficialRecommendLiveViewHolder;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<d.b.i0.t.d.c.e.c, OfficialRecommendLiveViewHolder> {
    public TbPageContext m;
    public d.b.i0.t.d.c.h.b n;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.d.c.e.c.f61889f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public OfficialRecommendLiveViewHolder R(ViewGroup viewGroup) {
        this.n = new d.b.i0.t.d.c.h.b(this.m, viewGroup);
        return new OfficialRecommendLiveViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.d.c.e.c cVar, OfficialRecommendLiveViewHolder officialRecommendLiveViewHolder) {
        d.b.i0.t.d.c.h.b bVar;
        if (officialRecommendLiveViewHolder == null || (bVar = officialRecommendLiveViewHolder.f14471a) == null) {
            return null;
        }
        bVar.n(cVar);
        officialRecommendLiveViewHolder.f14471a.o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return officialRecommendLiveViewHolder.a();
    }
}
