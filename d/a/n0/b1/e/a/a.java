package d.a.n0.b1.e.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.c.k.e.n;
import d.a.n0.z.e0.k;
import d.a.n0.z.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55113a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55114b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.k.e.a> f55115c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public f f55116d;

    /* renamed from: e  reason: collision with root package name */
    public c f55117e;

    /* renamed from: f  reason: collision with root package name */
    public d f55118f;

    /* renamed from: g  reason: collision with root package name */
    public e f55119g;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55113a = tbPageContext;
        this.f55114b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55114b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f55116d = new f(this.f55113a, k.w0);
        this.f55117e = new c(this.f55113a, l.W);
        this.f55118f = new d(this.f55113a, k.E0);
        this.f55119g = new e(this.f55113a, k.C0);
        this.f55116d.l0(this.f55114b);
        this.f55117e.p0(this.f55114b);
        this.f55118f.k0(this.f55114b);
        this.f55119g.m0(this.f55114b);
        this.f55115c.add(this.f55116d);
        this.f55115c.add(this.f55117e);
        this.f55115c.add(this.f55118f);
        this.f55115c.add(this.f55119g);
        this.f55114b.a(this.f55115c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55114b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        c cVar = this.f55117e;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f55114b.setData(list);
    }

    public void g(int i2) {
        f fVar = this.f55116d;
        if (fVar != null) {
            fVar.j0(i2);
        }
        c cVar = this.f55117e;
        if (cVar != null) {
            cVar.l0(i2);
        }
        d dVar = this.f55118f;
        if (dVar != null) {
            dVar.i0(i2);
        }
        e eVar = this.f55119g;
        if (eVar != null) {
            eVar.k0(i2);
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar = this.f55119g;
        if (eVar != null) {
            eVar.j0(bVar);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        f fVar = this.f55116d;
        if (fVar != null) {
            fVar.k0(bdUniqueId);
        }
        c cVar = this.f55117e;
        if (cVar != null) {
            cVar.m0(bdUniqueId);
        }
        d dVar = this.f55118f;
        if (dVar != null) {
            dVar.j0(bdUniqueId);
        }
        e eVar = this.f55119g;
        if (eVar != null) {
            eVar.l0(bdUniqueId);
        }
    }
}
