package d.b.i0.z0.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.b.b.j.e.n;
import d.b.i0.x.e0.k;
import d.b.i0.x.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62830a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62831b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.b.b.j.e.a> f62832c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public f f62833d;

    /* renamed from: e  reason: collision with root package name */
    public c f62834e;

    /* renamed from: f  reason: collision with root package name */
    public d f62835f;

    /* renamed from: g  reason: collision with root package name */
    public e f62836g;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f62830a = tbPageContext;
        this.f62831b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62831b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f62833d = new f(this.f62830a, k.v0);
        this.f62834e = new c(this.f62830a, l.V);
        this.f62835f = new d(this.f62830a, k.D0);
        this.f62836g = new e(this.f62830a, k.B0);
        this.f62833d.o0(this.f62831b);
        this.f62834e.q0(this.f62831b);
        this.f62835f.n0(this.f62831b);
        this.f62836g.p0(this.f62831b);
        this.f62832c.add(this.f62833d);
        this.f62832c.add(this.f62834e);
        this.f62832c.add(this.f62835f);
        this.f62832c.add(this.f62836g);
        this.f62831b.a(this.f62832c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62831b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        c cVar = this.f62834e;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f62831b.setData(list);
    }

    public void g(int i) {
        f fVar = this.f62833d;
        if (fVar != null) {
            fVar.m0(i);
        }
        c cVar = this.f62834e;
        if (cVar != null) {
            cVar.o0(i);
        }
        d dVar = this.f62835f;
        if (dVar != null) {
            dVar.l0(i);
        }
        e eVar = this.f62836g;
        if (eVar != null) {
            eVar.n0(i);
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar = this.f62836g;
        if (eVar != null) {
            eVar.m0(bVar);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        f fVar = this.f62833d;
        if (fVar != null) {
            fVar.n0(bdUniqueId);
        }
        c cVar = this.f62834e;
        if (cVar != null) {
            cVar.p0(bdUniqueId);
        }
        d dVar = this.f62835f;
        if (dVar != null) {
            dVar.m0(bdUniqueId);
        }
        e eVar = this.f62836g;
        if (eVar != null) {
            eVar.o0(bdUniqueId);
        }
    }
}
