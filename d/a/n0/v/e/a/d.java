package d.a.n0.v.e.a;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f65570a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f65571b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f65572c;

    /* renamed from: d  reason: collision with root package name */
    public e f65573d;

    /* renamed from: e  reason: collision with root package name */
    public h f65574e;

    public d(d.a.c.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.f65570a = fVar;
        this.f65572c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        this.f65573d = new e((TbPageContext) this.f65570a, d.a.n0.v.e.b.c.f65584f);
        this.f65574e = new h((TbPageContext) this.f65570a, d.a.n0.v.e.b.c.f65585g);
        this.f65571b.add(this.f65573d);
        this.f65571b.add(this.f65574e);
        this.f65572c.addAdapters(this.f65571b);
    }

    public void b(d.a.n0.v.c cVar) {
        e eVar = this.f65573d;
        if (eVar != null) {
            eVar.h0(cVar);
        }
        h hVar = this.f65574e;
        if (hVar != null) {
            hVar.h0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView = this.f65572c;
        if (bdTypeMultiColumnListView != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
