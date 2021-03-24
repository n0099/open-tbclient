package d.b.i0.p0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.p0.e2.l f58338a;

    public q(TbPageContext tbPageContext, d.b.i0.p0.e2.l lVar) {
        this.f58338a = lVar;
    }

    public void a(d.b.i0.e.d dVar) {
        d.b.i0.p0.e2.l lVar = this.f58338a;
        if (lVar == null || lVar.M() == null || this.f58338a.M().Z() == null || this.f58338a.x0() == null || dVar == null || this.f58338a.x0().Z() == null || this.f58338a.w0() == null) {
            return;
        }
        BdTypeRecyclerView Z = this.f58338a.x0().Z();
        int i = dVar.f54190a;
        if (i != 2) {
            if (i == 3 && dVar.a() != null) {
                Z.removeHeaderView(dVar.a());
                this.f58338a.w0().g0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            Z.removeHeaderView(dVar.a());
            Z.t(dVar.a(), Z.getHeaderViewsCount() - 1);
            this.f58338a.w0().g0(8);
        }
    }
}
