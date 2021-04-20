package d.b.i0.q0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.q0.e2.l f60001a;

    public q(TbPageContext tbPageContext, d.b.i0.q0.e2.l lVar) {
        this.f60001a = lVar;
    }

    public void a(d.b.i0.e.d dVar) {
        d.b.i0.q0.e2.l lVar = this.f60001a;
        if (lVar == null || lVar.M() == null || this.f60001a.M().Z() == null || this.f60001a.x0() == null || dVar == null || this.f60001a.x0().Z() == null || this.f60001a.w0() == null) {
            return;
        }
        BdTypeRecyclerView Z = this.f60001a.x0().Z();
        int i = dVar.f55074a;
        if (i != 2) {
            if (i == 3 && dVar.a() != null) {
                Z.removeHeaderView(dVar.a());
                this.f60001a.w0().g0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            Z.removeHeaderView(dVar.a());
            Z.t(dVar.a(), Z.getHeaderViewsCount() - 1);
            this.f60001a.w0().g0(8);
        }
    }
}
