package d.a.n0.r0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.r0.e2.l f63089a;

    public q(TbPageContext tbPageContext, d.a.n0.r0.e2.l lVar) {
        this.f63089a = lVar;
    }

    public void a(d.a.n0.e.d dVar) {
        d.a.n0.r0.e2.l lVar = this.f63089a;
        if (lVar == null || lVar.e0() == null || this.f63089a.e0().d0() == null || this.f63089a.B0() == null || dVar == null || this.f63089a.B0().Z() == null || this.f63089a.R() == null) {
            return;
        }
        BdTypeRecyclerView Z = this.f63089a.B0().Z();
        int i2 = dVar.f56432a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                Z.removeHeaderView(dVar.a());
                this.f63089a.R().d0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            Z.removeHeaderView(dVar.a());
            Z.t(dVar.a(), Z.getHeaderViewsCount() - 1);
            this.f63089a.R().d0(8);
        }
    }
}
