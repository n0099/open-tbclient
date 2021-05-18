package d.a.k0.t.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f61572a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61573b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f61574c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public f f61575d;

    /* renamed from: e  reason: collision with root package name */
    public c f61576e;

    /* renamed from: f  reason: collision with root package name */
    public a f61577f;

    /* renamed from: g  reason: collision with root package name */
    public b f61578g;

    public g(d.a.c.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.f61572a = fVar;
        this.f61573b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        if (z) {
            c cVar = new c((TbPageContext) this.f61572a, d.a.k0.t.h.b.a.f61677g);
            this.f61576e = cVar;
            this.f61574c.add(cVar);
        } else {
            f fVar = new f((TbPageContext) this.f61572a, d.a.k0.t.h.b.a.f61677g);
            this.f61575d = fVar;
            this.f61574c.add(fVar);
        }
        this.f61577f = new a((TbPageContext) this.f61572a, d.a.k0.t.e.b.a.f61579e);
        this.f61578g = new b((TbPageContext) this.f61572a, d.a.k0.t.e.b.b.f61580e);
        this.f61574c.add(this.f61577f);
        this.f61574c.add(this.f61578g);
        this.f61573b.a(this.f61574c);
    }

    public void b(d.a.k0.t.c cVar) {
        f fVar = this.f61575d;
        if (fVar != null) {
            fVar.g0(cVar);
        }
        c cVar2 = this.f61576e;
        if (cVar2 != null) {
            cVar2.g0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f61573b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
