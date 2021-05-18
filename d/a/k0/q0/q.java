package d.a.k0.q0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.q0.e2.l f59257a;

    public q(TbPageContext tbPageContext, d.a.k0.q0.e2.l lVar) {
        this.f59257a = lVar;
    }

    public void a(d.a.k0.e.d dVar) {
        d.a.k0.q0.e2.l lVar = this.f59257a;
        if (lVar == null || lVar.b0() == null || this.f59257a.b0().Z() == null || this.f59257a.y0() == null || dVar == null || this.f59257a.y0().Z() == null || this.f59257a.P() == null) {
            return;
        }
        BdTypeRecyclerView Z = this.f59257a.y0().Z();
        int i2 = dVar.f54048a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                Z.removeHeaderView(dVar.a());
                this.f59257a.P().e0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            Z.removeHeaderView(dVar.a());
            Z.t(dVar.a(), Z.getHeaderViewsCount() - 1);
            this.f59257a.P().e0(8);
        }
    }
}
