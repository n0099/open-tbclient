package d.a.o0.r0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.r0.e2.l f63214a;

    public q(TbPageContext tbPageContext, d.a.o0.r0.e2.l lVar) {
        this.f63214a = lVar;
    }

    public void a(d.a.o0.e.d dVar) {
        d.a.o0.r0.e2.l lVar = this.f63214a;
        if (lVar == null || lVar.e0() == null || this.f63214a.e0().d0() == null || this.f63214a.B0() == null || dVar == null || this.f63214a.B0().Z() == null || this.f63214a.R() == null) {
            return;
        }
        BdTypeRecyclerView Z = this.f63214a.B0().Z();
        int i2 = dVar.f56557a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                Z.removeHeaderView(dVar.a());
                this.f63214a.R().d0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            Z.removeHeaderView(dVar.a());
            Z.t(dVar.a(), Z.getHeaderViewsCount() - 1);
            this.f63214a.R().d0(8);
        }
    }
}
