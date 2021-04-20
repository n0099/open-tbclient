package d.b.i0.a1.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.b.c.j.e.n;
import d.b.i0.x.e0.k;
import d.b.i0.x.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52450a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f52451b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.b.c.j.e.a> f52452c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public f f52453d;

    /* renamed from: e  reason: collision with root package name */
    public c f52454e;

    /* renamed from: f  reason: collision with root package name */
    public d f52455f;

    /* renamed from: g  reason: collision with root package name */
    public e f52456g;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f52450a = tbPageContext;
        this.f52451b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52451b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f52453d = new f(this.f52450a, k.v0);
        this.f52454e = new c(this.f52450a, l.V);
        this.f52455f = new d(this.f52450a, k.D0);
        this.f52456g = new e(this.f52450a, k.B0);
        this.f52453d.o0(this.f52451b);
        this.f52454e.q0(this.f52451b);
        this.f52455f.n0(this.f52451b);
        this.f52456g.p0(this.f52451b);
        this.f52452c.add(this.f52453d);
        this.f52452c.add(this.f52454e);
        this.f52452c.add(this.f52455f);
        this.f52452c.add(this.f52456g);
        this.f52451b.a(this.f52452c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52451b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        c cVar = this.f52454e;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f52451b.setData(list);
    }

    public void g(int i) {
        f fVar = this.f52453d;
        if (fVar != null) {
            fVar.m0(i);
        }
        c cVar = this.f52454e;
        if (cVar != null) {
            cVar.o0(i);
        }
        d dVar = this.f52455f;
        if (dVar != null) {
            dVar.l0(i);
        }
        e eVar = this.f52456g;
        if (eVar != null) {
            eVar.n0(i);
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar = this.f52456g;
        if (eVar != null) {
            eVar.m0(bVar);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        f fVar = this.f52453d;
        if (fVar != null) {
            fVar.n0(bdUniqueId);
        }
        c cVar = this.f52454e;
        if (cVar != null) {
            cVar.p0(bdUniqueId);
        }
        d dVar = this.f52455f;
        if (dVar != null) {
            dVar.m0(bdUniqueId);
        }
        e eVar = this.f52456g;
        if (eVar != null) {
            eVar.o0(bdUniqueId);
        }
    }
}
