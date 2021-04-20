package d.b.i0.t.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernItemViewLineHolder;
import d.b.i0.t.d.c.e.k;
import d.b.i0.t.d.c.f.d.i;
/* loaded from: classes4.dex */
public class c extends d.b.c.j.e.a<k, LiveTabConcernItemViewLineHolder> {
    public TbPageContext m;
    public d.b.i0.t.d.c.f.d.d n;
    public i o;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.f61906h);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public LiveTabConcernItemViewLineHolder R(ViewGroup viewGroup) {
        d.b.i0.t.d.c.f.d.d dVar = new d.b.i0.t.d.c.f.d.d(this.m, viewGroup);
        this.n = dVar;
        i iVar = this.o;
        if (iVar != null) {
            dVar.v(iVar);
        }
        return new LiveTabConcernItemViewLineHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, k kVar, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        d.b.i0.t.d.c.f.d.d dVar;
        if (liveTabConcernItemViewLineHolder == null || (dVar = liveTabConcernItemViewLineHolder.f14460a) == null) {
            return null;
        }
        dVar.n(kVar);
        return liveTabConcernItemViewLineHolder.a();
    }

    public void j0(i iVar) {
        this.o = iVar;
        d.b.i0.t.d.c.f.d.d dVar = this.n;
        if (dVar != null) {
            dVar.v(iVar);
        }
    }
}
