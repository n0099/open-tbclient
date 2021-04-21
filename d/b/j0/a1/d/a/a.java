package d.b.j0.a1.d.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.b.c.j.e.n;
import d.b.j0.x.e0.k;
import d.b.j0.x.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52871a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f52872b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.b.c.j.e.a> f52873c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public f f52874d;

    /* renamed from: e  reason: collision with root package name */
    public c f52875e;

    /* renamed from: f  reason: collision with root package name */
    public d f52876f;

    /* renamed from: g  reason: collision with root package name */
    public e f52877g;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f52871a = tbPageContext;
        this.f52872b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52872b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f52874d = new f(this.f52871a, k.v0);
        this.f52875e = new c(this.f52871a, l.V);
        this.f52876f = new d(this.f52871a, k.D0);
        this.f52877g = new e(this.f52871a, k.B0);
        this.f52874d.o0(this.f52872b);
        this.f52875e.q0(this.f52872b);
        this.f52876f.n0(this.f52872b);
        this.f52877g.p0(this.f52872b);
        this.f52873c.add(this.f52874d);
        this.f52873c.add(this.f52875e);
        this.f52873c.add(this.f52876f);
        this.f52873c.add(this.f52877g);
        this.f52872b.a(this.f52873c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52872b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        c cVar = this.f52875e;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f52872b.setData(list);
    }

    public void g(int i) {
        f fVar = this.f52874d;
        if (fVar != null) {
            fVar.m0(i);
        }
        c cVar = this.f52875e;
        if (cVar != null) {
            cVar.o0(i);
        }
        d dVar = this.f52876f;
        if (dVar != null) {
            dVar.l0(i);
        }
        e eVar = this.f52877g;
        if (eVar != null) {
            eVar.n0(i);
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar = this.f52877g;
        if (eVar != null) {
            eVar.m0(bVar);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        f fVar = this.f52874d;
        if (fVar != null) {
            fVar.n0(bdUniqueId);
        }
        c cVar = this.f52875e;
        if (cVar != null) {
            cVar.p0(bdUniqueId);
        }
        d dVar = this.f52876f;
        if (dVar != null) {
            dVar.m0(bdUniqueId);
        }
        e eVar = this.f52877g;
        if (eVar != null) {
            eVar.o0(bdUniqueId);
        }
    }
}
