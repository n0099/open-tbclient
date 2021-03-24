package d.b.i0.t.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernRecommendLineHolder;
import d.b.i0.t.d.c.f.d.h;
import d.b.i0.t.d.c.f.d.i;
/* loaded from: classes4.dex */
public class f extends d.b.b.j.e.a<d.b.i0.t.d.c.f.b.c, LiveTabConcernRecommendLineHolder> {
    public TbPageContext m;
    public h n;
    public i o;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.d.c.f.b.c.f60361h);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public LiveTabConcernRecommendLineHolder R(ViewGroup viewGroup) {
        h hVar = new h(this.m, viewGroup);
        this.n = hVar;
        i iVar = this.o;
        if (iVar != null) {
            hVar.v(iVar);
        }
        return new LiveTabConcernRecommendLineHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.d.c.f.b.c cVar, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        h hVar;
        if (liveTabConcernRecommendLineHolder == null || (hVar = liveTabConcernRecommendLineHolder.f14799a) == null) {
            return null;
        }
        hVar.n(cVar);
        return liveTabConcernRecommendLineHolder.a();
    }

    public void j0(i iVar) {
        this.o = iVar;
        h hVar = this.n;
        if (hVar != null) {
            hVar.v(iVar);
        }
    }
}
