package d.a.n0.r0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.r0.e2.l f59398a;

    public q(TbPageContext tbPageContext, d.a.n0.r0.e2.l lVar) {
        this.f59398a = lVar;
    }

    public void a(d.a.n0.e.d dVar) {
        d.a.n0.r0.e2.l lVar = this.f59398a;
        if (lVar == null || lVar.b0() == null || this.f59398a.b0().Z() == null || this.f59398a.y0() == null || dVar == null || this.f59398a.y0().Z() == null || this.f59398a.P() == null) {
            return;
        }
        BdTypeRecyclerView Z = this.f59398a.y0().Z();
        int i2 = dVar.f52743a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                Z.removeHeaderView(dVar.a());
                this.f59398a.P().e0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            Z.removeHeaderView(dVar.a());
            Z.t(dVar.a(), Z.getHeaderViewsCount() - 1);
            this.f59398a.P().e0(8);
        }
    }
}
