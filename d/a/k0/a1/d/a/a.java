package d.a.k0.a1.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.c.j.e.n;
import d.a.k0.x.e0.k;
import d.a.k0.x.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51265a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f51266b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.j.e.a> f51267c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public f f51268d;

    /* renamed from: e  reason: collision with root package name */
    public c f51269e;

    /* renamed from: f  reason: collision with root package name */
    public d f51270f;

    /* renamed from: g  reason: collision with root package name */
    public e f51271g;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f51265a = tbPageContext;
        this.f51266b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51266b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f51268d = new f(this.f51265a, k.w0);
        this.f51269e = new c(this.f51265a, l.W);
        this.f51270f = new d(this.f51265a, k.E0);
        this.f51271g = new e(this.f51265a, k.C0);
        this.f51268d.m0(this.f51266b);
        this.f51269e.p0(this.f51266b);
        this.f51270f.j0(this.f51266b);
        this.f51271g.n0(this.f51266b);
        this.f51267c.add(this.f51268d);
        this.f51267c.add(this.f51269e);
        this.f51267c.add(this.f51270f);
        this.f51267c.add(this.f51271g);
        this.f51266b.a(this.f51267c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51266b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        c cVar = this.f51269e;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f51266b.setData(list);
    }

    public void g(int i2) {
        f fVar = this.f51268d;
        if (fVar != null) {
            fVar.i0(i2);
        }
        c cVar = this.f51269e;
        if (cVar != null) {
            cVar.m0(i2);
        }
        d dVar = this.f51270f;
        if (dVar != null) {
            dVar.h0(i2);
        }
        e eVar = this.f51271g;
        if (eVar != null) {
            eVar.j0(i2);
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar = this.f51271g;
        if (eVar != null) {
            eVar.i0(bVar);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        f fVar = this.f51268d;
        if (fVar != null) {
            fVar.j0(bdUniqueId);
        }
        c cVar = this.f51269e;
        if (cVar != null) {
            cVar.n0(bdUniqueId);
        }
        d dVar = this.f51270f;
        if (dVar != null) {
            dVar.i0(bdUniqueId);
        }
        e eVar = this.f51271g;
        if (eVar != null) {
            eVar.m0(bdUniqueId);
        }
    }
}
