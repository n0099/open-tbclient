package d.a.j0.a1.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.c.j.e.n;
import d.a.j0.x.e0.k;
import d.a.j0.x.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f50568a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f50569b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.j.e.a> f50570c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public f f50571d;

    /* renamed from: e  reason: collision with root package name */
    public c f50572e;

    /* renamed from: f  reason: collision with root package name */
    public d f50573f;

    /* renamed from: g  reason: collision with root package name */
    public e f50574g;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f50568a = tbPageContext;
        this.f50569b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f50569b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f50571d = new f(this.f50568a, k.v0);
        this.f50572e = new c(this.f50568a, l.V);
        this.f50573f = new d(this.f50568a, k.D0);
        this.f50574g = new e(this.f50568a, k.B0);
        this.f50571d.m0(this.f50569b);
        this.f50572e.p0(this.f50569b);
        this.f50573f.j0(this.f50569b);
        this.f50574g.n0(this.f50569b);
        this.f50570c.add(this.f50571d);
        this.f50570c.add(this.f50572e);
        this.f50570c.add(this.f50573f);
        this.f50570c.add(this.f50574g);
        this.f50569b.a(this.f50570c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f50569b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        c cVar = this.f50572e;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f50569b.setData(list);
    }

    public void g(int i2) {
        f fVar = this.f50571d;
        if (fVar != null) {
            fVar.i0(i2);
        }
        c cVar = this.f50572e;
        if (cVar != null) {
            cVar.m0(i2);
        }
        d dVar = this.f50573f;
        if (dVar != null) {
            dVar.h0(i2);
        }
        e eVar = this.f50574g;
        if (eVar != null) {
            eVar.j0(i2);
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar = this.f50574g;
        if (eVar != null) {
            eVar.i0(bVar);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        f fVar = this.f50571d;
        if (fVar != null) {
            fVar.j0(bdUniqueId);
        }
        c cVar = this.f50572e;
        if (cVar != null) {
            cVar.n0(bdUniqueId);
        }
        d dVar = this.f50573f;
        if (dVar != null) {
            dVar.i0(bdUniqueId);
        }
        e eVar = this.f50574g;
        if (eVar != null) {
            eVar.m0(bdUniqueId);
        }
    }
}
