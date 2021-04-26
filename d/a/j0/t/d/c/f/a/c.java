package d.a.j0.t.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernItemViewLineHolder;
import d.a.j0.t.d.c.e.k;
import d.a.j0.t.d.c.f.d.i;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<k, LiveTabConcernItemViewLineHolder> {
    public TbPageContext m;
    public d.a.j0.t.d.c.f.d.d n;
    public i o;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.f60505h);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public LiveTabConcernItemViewLineHolder P(ViewGroup viewGroup) {
        d.a.j0.t.d.c.f.d.d dVar = new d.a.j0.t.d.c.f.d.d(this.m, viewGroup);
        this.n = dVar;
        i iVar = this.o;
        if (iVar != null) {
            dVar.t(iVar);
        }
        return new LiveTabConcernItemViewLineHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, k kVar, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        d.a.j0.t.d.c.f.d.d dVar;
        if (liveTabConcernItemViewLineHolder == null || (dVar = liveTabConcernItemViewLineHolder.f14539a) == null) {
            return null;
        }
        dVar.m(kVar);
        return liveTabConcernItemViewLineHolder.a();
    }

    public void g0(i iVar) {
        this.o = iVar;
        d.a.j0.t.d.c.f.d.d dVar = this.n;
        if (dVar != null) {
            dVar.t(iVar);
        }
    }
}
