package d.a.n0.v.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernRecommendLineHolder;
import d.a.n0.v.d.c.f.d.h;
import d.a.n0.v.d.c.f.d.i;
/* loaded from: classes4.dex */
public class f extends d.a.c.j.e.a<d.a.n0.v.d.c.f.b.c, LiveTabConcernRecommendLineHolder> {
    public TbPageContext m;
    public h n;
    public i o;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.d.c.f.b.c.f61538h);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public LiveTabConcernRecommendLineHolder P(ViewGroup viewGroup) {
        h hVar = new h(this.m, viewGroup);
        this.n = hVar;
        i iVar = this.o;
        if (iVar != null) {
            hVar.t(iVar);
        }
        return new LiveTabConcernRecommendLineHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.v.d.c.f.b.c cVar, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        h hVar;
        if (liveTabConcernRecommendLineHolder == null || (hVar = liveTabConcernRecommendLineHolder.f13760a) == null) {
            return null;
        }
        hVar.m(cVar);
        return liveTabConcernRecommendLineHolder.a();
    }

    public void g0(i iVar) {
        this.o = iVar;
        h hVar = this.n;
        if (hVar != null) {
            hVar.t(iVar);
        }
    }
}
