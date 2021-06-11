package d.a.n0.v.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernItemViewLineHolder;
import d.a.n0.v.d.c.e.k;
import d.a.n0.v.d.c.f.d.i;
/* loaded from: classes4.dex */
public class c extends d.a.c.k.e.a<k, LiveTabConcernItemViewLineHolder> {
    public TbPageContext m;
    public d.a.n0.v.d.c.f.d.d n;
    public i o;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.f65230h);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public LiveTabConcernItemViewLineHolder Q(ViewGroup viewGroup) {
        d.a.n0.v.d.c.f.d.d dVar = new d.a.n0.v.d.c.f.d.d(this.m, viewGroup);
        this.n = dVar;
        i iVar = this.o;
        if (iVar != null) {
            dVar.u(iVar);
        }
        return new LiveTabConcernItemViewLineHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, k kVar, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        d.a.n0.v.d.c.f.d.d dVar;
        if (liveTabConcernItemViewLineHolder == null || (dVar = liveTabConcernItemViewLineHolder.f13822a) == null) {
            return null;
        }
        dVar.n(kVar);
        return liveTabConcernItemViewLineHolder.a();
    }

    public void h0(i iVar) {
        this.o = iVar;
        d.a.n0.v.d.c.f.d.d dVar = this.n;
        if (dVar != null) {
            dVar.u(iVar);
        }
    }
}
