package d.a.j0.q0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.q0.e2.l f58515a;

    public q(TbPageContext tbPageContext, d.a.j0.q0.e2.l lVar) {
        this.f58515a = lVar;
    }

    public void a(d.a.j0.e.d dVar) {
        d.a.j0.q0.e2.l lVar = this.f58515a;
        if (lVar == null || lVar.b0() == null || this.f58515a.b0().Z() == null || this.f58515a.z0() == null || dVar == null || this.f58515a.z0().Z() == null || this.f58515a.P() == null) {
            return;
        }
        BdTypeRecyclerView Z = this.f58515a.z0().Z();
        int i2 = dVar.f53341a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                Z.removeHeaderView(dVar.a());
                this.f58515a.P().e0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            Z.removeHeaderView(dVar.a());
            Z.t(dVar.a(), Z.getHeaderViewsCount() - 1);
            this.f58515a.P().e0(8);
        }
    }
}
