package d.a.n0.b1.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.c.j.e.n;
import d.a.n0.z.e0.k;
import d.a.n0.z.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51430a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f51431b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.j.e.a> f51432c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public f f51433d;

    /* renamed from: e  reason: collision with root package name */
    public c f51434e;

    /* renamed from: f  reason: collision with root package name */
    public d f51435f;

    /* renamed from: g  reason: collision with root package name */
    public e f51436g;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f51430a = tbPageContext;
        this.f51431b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51431b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f51433d = new f(this.f51430a, k.w0);
        this.f51434e = new c(this.f51430a, l.W);
        this.f51435f = new d(this.f51430a, k.E0);
        this.f51436g = new e(this.f51430a, k.C0);
        this.f51433d.m0(this.f51431b);
        this.f51434e.p0(this.f51431b);
        this.f51435f.j0(this.f51431b);
        this.f51436g.n0(this.f51431b);
        this.f51432c.add(this.f51433d);
        this.f51432c.add(this.f51434e);
        this.f51432c.add(this.f51435f);
        this.f51432c.add(this.f51436g);
        this.f51431b.a(this.f51432c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51431b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        c cVar = this.f51434e;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f51431b.setData(list);
    }

    public void g(int i2) {
        f fVar = this.f51433d;
        if (fVar != null) {
            fVar.i0(i2);
        }
        c cVar = this.f51434e;
        if (cVar != null) {
            cVar.m0(i2);
        }
        d dVar = this.f51435f;
        if (dVar != null) {
            dVar.h0(i2);
        }
        e eVar = this.f51436g;
        if (eVar != null) {
            eVar.j0(i2);
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar = this.f51436g;
        if (eVar != null) {
            eVar.i0(bVar);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        f fVar = this.f51433d;
        if (fVar != null) {
            fVar.j0(bdUniqueId);
        }
        c cVar = this.f51434e;
        if (cVar != null) {
            cVar.n0(bdUniqueId);
        }
        d dVar = this.f51435f;
        if (dVar != null) {
            dVar.i0(bdUniqueId);
        }
        e eVar = this.f51436g;
        if (eVar != null) {
            eVar.m0(bdUniqueId);
        }
    }
}
