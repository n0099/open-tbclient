package d.b.i0.t.e.a;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.a.f f60669a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f60670b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f60671c;

    /* renamed from: d  reason: collision with root package name */
    public e f60672d;

    /* renamed from: e  reason: collision with root package name */
    public h f60673e;

    public d(d.b.b.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.f60669a = fVar;
        this.f60671c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        this.f60672d = new e((TbPageContext) this.f60669a, d.b.i0.t.e.b.c.f60683f);
        this.f60673e = new h((TbPageContext) this.f60669a, d.b.i0.t.e.b.c.f60684g);
        this.f60670b.add(this.f60672d);
        this.f60670b.add(this.f60673e);
        this.f60671c.addAdapters(this.f60670b);
    }

    public void b(d.b.i0.t.c cVar) {
        e eVar = this.f60672d;
        if (eVar != null) {
            eVar.j0(cVar);
        }
        h hVar = this.f60673e;
        if (hVar != null) {
            hVar.j0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView = this.f60671c;
        if (bdTypeMultiColumnListView != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
