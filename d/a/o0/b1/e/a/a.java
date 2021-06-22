package d.a.o0.b1.e.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.c.k.e.n;
import d.a.o0.z.e0.k;
import d.a.o0.z.e0.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55238a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55239b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d.a.c.k.e.a> f55240c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public f f55241d;

    /* renamed from: e  reason: collision with root package name */
    public c f55242e;

    /* renamed from: f  reason: collision with root package name */
    public d f55243f;

    /* renamed from: g  reason: collision with root package name */
    public e f55244g;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55238a = tbPageContext;
        this.f55239b = bdTypeRecyclerView;
        b();
    }

    public List<n> a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55239b;
        if (bdTypeRecyclerView != null) {
            return bdTypeRecyclerView.getData();
        }
        return null;
    }

    public final void b() {
        this.f55241d = new f(this.f55238a, k.B0);
        this.f55242e = new c(this.f55238a, l.W);
        this.f55243f = new d(this.f55238a, k.J0);
        this.f55244g = new e(this.f55238a, k.H0);
        this.f55241d.l0(this.f55239b);
        this.f55242e.p0(this.f55239b);
        this.f55243f.k0(this.f55239b);
        this.f55244g.m0(this.f55239b);
        this.f55240c.add(this.f55241d);
        this.f55240c.add(this.f55242e);
        this.f55240c.add(this.f55243f);
        this.f55240c.add(this.f55244g);
        this.f55239b.a(this.f55240c);
    }

    public void c() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55239b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
    }

    public void e() {
        c cVar = this.f55242e;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    public void f(List<n> list) {
        this.f55239b.setData(list);
    }

    public void g(int i2) {
        f fVar = this.f55241d;
        if (fVar != null) {
            fVar.j0(i2);
        }
        c cVar = this.f55242e;
        if (cVar != null) {
            cVar.l0(i2);
        }
        d dVar = this.f55243f;
        if (dVar != null) {
            dVar.i0(i2);
        }
        e eVar = this.f55244g;
        if (eVar != null) {
            eVar.k0(i2);
        }
    }

    public void h(NEGFeedBackView.b bVar) {
        e eVar = this.f55244g;
        if (eVar != null) {
            eVar.j0(bVar);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        f fVar = this.f55241d;
        if (fVar != null) {
            fVar.k0(bdUniqueId);
        }
        c cVar = this.f55242e;
        if (cVar != null) {
            cVar.m0(bdUniqueId);
        }
        d dVar = this.f55243f;
        if (dVar != null) {
            dVar.j0(bdUniqueId);
        }
        e eVar = this.f55244g;
        if (eVar != null) {
            eVar.l0(bdUniqueId);
        }
    }
}
