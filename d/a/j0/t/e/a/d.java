package d.a.j0.t.e.a;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f60843a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f60844b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f60845c;

    /* renamed from: d  reason: collision with root package name */
    public e f60846d;

    /* renamed from: e  reason: collision with root package name */
    public h f60847e;

    public d(d.a.c.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.f60843a = fVar;
        this.f60845c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        this.f60846d = new e((TbPageContext) this.f60843a, d.a.j0.t.e.b.c.f60857f);
        this.f60847e = new h((TbPageContext) this.f60843a, d.a.j0.t.e.b.c.f60858g);
        this.f60844b.add(this.f60846d);
        this.f60844b.add(this.f60847e);
        this.f60845c.addAdapters(this.f60844b);
    }

    public void b(d.a.j0.t.c cVar) {
        e eVar = this.f60846d;
        if (eVar != null) {
            eVar.g0(cVar);
        }
        h hVar = this.f60847e;
        if (hVar != null) {
            hVar.g0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView = this.f60845c;
        if (bdTypeMultiColumnListView != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
