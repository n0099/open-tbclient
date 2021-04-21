package d.b.j0.t.e.a;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.a.f f62655a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f62656b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f62657c;

    /* renamed from: d  reason: collision with root package name */
    public e f62658d;

    /* renamed from: e  reason: collision with root package name */
    public h f62659e;

    public d(d.b.c.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.f62655a = fVar;
        this.f62657c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        this.f62658d = new e((TbPageContext) this.f62655a, d.b.j0.t.e.b.c.f62669f);
        this.f62659e = new h((TbPageContext) this.f62655a, d.b.j0.t.e.b.c.f62670g);
        this.f62656b.add(this.f62658d);
        this.f62656b.add(this.f62659e);
        this.f62657c.addAdapters(this.f62656b);
    }

    public void b(d.b.j0.t.c cVar) {
        e eVar = this.f62658d;
        if (eVar != null) {
            eVar.j0(cVar);
        }
        h hVar = this.f62659e;
        if (hVar != null) {
            hVar.j0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView = this.f62657c;
        if (bdTypeMultiColumnListView != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
