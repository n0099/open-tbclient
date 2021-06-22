package d.a.o0.v.d.c.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.OfficialRecommendLiveViewHolder;
/* loaded from: classes4.dex */
public class b extends d.a.c.k.e.a<d.a.o0.v.d.c.e.c, OfficialRecommendLiveViewHolder> {
    public TbPageContext m;
    public d.a.o0.v.d.c.h.b n;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.v.d.c.e.c.f65337f);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public OfficialRecommendLiveViewHolder Q(ViewGroup viewGroup) {
        this.n = new d.a.o0.v.d.c.h.b(this.m, viewGroup);
        return new OfficialRecommendLiveViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.d.c.e.c cVar, OfficialRecommendLiveViewHolder officialRecommendLiveViewHolder) {
        d.a.o0.v.d.c.h.b bVar;
        if (officialRecommendLiveViewHolder == null || (bVar = officialRecommendLiveViewHolder.f13915a) == null) {
            return null;
        }
        bVar.n(cVar);
        officialRecommendLiveViewHolder.f13915a.o(this.m, TbadkCoreApplication.getInst().getSkinType());
        return officialRecommendLiveViewHolder.a();
    }
}
