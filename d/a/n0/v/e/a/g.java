package d.a.n0.v.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f61860a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61861b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f61862c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public f f61863d;

    /* renamed from: e  reason: collision with root package name */
    public c f61864e;

    /* renamed from: f  reason: collision with root package name */
    public a f61865f;

    /* renamed from: g  reason: collision with root package name */
    public b f61866g;

    public g(d.a.c.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.f61860a = fVar;
        this.f61861b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        if (z) {
            c cVar = new c((TbPageContext) this.f61860a, d.a.n0.v.h.b.a.f61965g);
            this.f61864e = cVar;
            this.f61862c.add(cVar);
        } else {
            f fVar = new f((TbPageContext) this.f61860a, d.a.n0.v.h.b.a.f61965g);
            this.f61863d = fVar;
            this.f61862c.add(fVar);
        }
        this.f61865f = new a((TbPageContext) this.f61860a, d.a.n0.v.e.b.a.f61867e);
        this.f61866g = new b((TbPageContext) this.f61860a, d.a.n0.v.e.b.b.f61868e);
        this.f61862c.add(this.f61865f);
        this.f61862c.add(this.f61866g);
        this.f61861b.a(this.f61862c);
    }

    public void b(d.a.n0.v.c cVar) {
        f fVar = this.f61863d;
        if (fVar != null) {
            fVar.g0(cVar);
        }
        c cVar2 = this.f61864e;
        if (cVar2 != null) {
            cVar2.g0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f61861b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
