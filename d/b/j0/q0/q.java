package d.b.j0.q0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public d.b.j0.q0.e2.l f60422a;

    public q(TbPageContext tbPageContext, d.b.j0.q0.e2.l lVar) {
        this.f60422a = lVar;
    }

    public void a(d.b.j0.e.d dVar) {
        d.b.j0.q0.e2.l lVar = this.f60422a;
        if (lVar == null || lVar.M() == null || this.f60422a.M().Z() == null || this.f60422a.x0() == null || dVar == null || this.f60422a.x0().Z() == null || this.f60422a.w0() == null) {
            return;
        }
        BdTypeRecyclerView Z = this.f60422a.x0().Z();
        int i = dVar.f55495a;
        if (i != 2) {
            if (i == 3 && dVar.a() != null) {
                Z.removeHeaderView(dVar.a());
                this.f60422a.w0().g0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            Z.removeHeaderView(dVar.a());
            Z.t(dVar.a(), Z.getHeaderViewsCount() - 1);
            this.f60422a.w0().g0(8);
        }
    }
}
