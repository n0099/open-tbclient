package d.b.i0.t.e.a;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.a.f f60670a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f60671b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f60672c;

    /* renamed from: d  reason: collision with root package name */
    public e f60673d;

    /* renamed from: e  reason: collision with root package name */
    public h f60674e;

    public d(d.b.b.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.f60670a = fVar;
        this.f60672c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        this.f60673d = new e((TbPageContext) this.f60670a, d.b.i0.t.e.b.c.f60684f);
        this.f60674e = new h((TbPageContext) this.f60670a, d.b.i0.t.e.b.c.f60685g);
        this.f60671b.add(this.f60673d);
        this.f60671b.add(this.f60674e);
        this.f60672c.addAdapters(this.f60671b);
    }

    public void b(d.b.i0.t.c cVar) {
        e eVar = this.f60673d;
        if (eVar != null) {
            eVar.j0(cVar);
        }
        h hVar = this.f60674e;
        if (hVar != null) {
            hVar.j0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView = this.f60672c;
        if (bdTypeMultiColumnListView != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
