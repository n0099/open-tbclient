package d.b.i0.t.e.a;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.a.f f62234a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f62235b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f62236c;

    /* renamed from: d  reason: collision with root package name */
    public e f62237d;

    /* renamed from: e  reason: collision with root package name */
    public h f62238e;

    public d(d.b.c.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.f62234a = fVar;
        this.f62236c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        this.f62237d = new e((TbPageContext) this.f62234a, d.b.i0.t.e.b.c.f62248f);
        this.f62238e = new h((TbPageContext) this.f62234a, d.b.i0.t.e.b.c.f62249g);
        this.f62235b.add(this.f62237d);
        this.f62235b.add(this.f62238e);
        this.f62236c.addAdapters(this.f62235b);
    }

    public void b(d.b.i0.t.c cVar) {
        e eVar = this.f62237d;
        if (eVar != null) {
            eVar.j0(cVar);
        }
        h hVar = this.f62238e;
        if (hVar != null) {
            hVar.j0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView = this.f62236c;
        if (bdTypeMultiColumnListView != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
