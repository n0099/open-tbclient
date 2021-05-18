package d.a.k0.t.e.a;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f61567a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f61568b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f61569c;

    /* renamed from: d  reason: collision with root package name */
    public e f61570d;

    /* renamed from: e  reason: collision with root package name */
    public h f61571e;

    public d(d.a.c.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.f61567a = fVar;
        this.f61569c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        this.f61570d = new e((TbPageContext) this.f61567a, d.a.k0.t.e.b.c.f61581f);
        this.f61571e = new h((TbPageContext) this.f61567a, d.a.k0.t.e.b.c.f61582g);
        this.f61568b.add(this.f61570d);
        this.f61568b.add(this.f61571e);
        this.f61569c.addAdapters(this.f61568b);
    }

    public void b(d.a.k0.t.c cVar) {
        e eVar = this.f61570d;
        if (eVar != null) {
            eVar.g0(cVar);
        }
        h hVar = this.f61571e;
        if (hVar != null) {
            hVar.g0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView = this.f61569c;
        if (bdTypeMultiColumnListView != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
