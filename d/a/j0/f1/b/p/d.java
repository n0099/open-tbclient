package d.a.j0.f1.b.p;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.c.j.e.x;
import d.a.j0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f54231a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f54232b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f54233c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    public b f54234d;

    /* renamed from: e  reason: collision with root package name */
    public b f54235e;

    /* renamed from: f  reason: collision with root package name */
    public b f54236f;

    /* renamed from: g  reason: collision with root package name */
    public b f54237g;

    /* renamed from: h  reason: collision with root package name */
    public b f54238h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f54231a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f54231a;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.D(i2);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        this.f54234d = new b(tbPageContext, a.x);
        this.f54235e = new b(tbPageContext, a.y);
        this.f54236f = new b(tbPageContext, a.B);
        this.f54237g = new b(tbPageContext, a.A);
        this.f54238h = new b(tbPageContext, a.z);
        this.f54233c.add(this.f54234d);
        this.f54233c.add(this.f54235e);
        this.f54233c.add(this.f54236f);
        this.f54233c.add(this.f54237g);
        this.f54233c.add(this.f54238h);
        this.f54231a.a(this.f54233c);
    }

    public void c() {
        this.f54231a.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        for (d.a.c.j.e.a aVar : this.f54233c) {
        }
    }

    public void e(w wVar) {
        for (d.a.c.j.e.a aVar : this.f54233c) {
            if (aVar != null) {
                aVar.Z(wVar);
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        this.f54231a.setData(arrayList);
        this.f54232b = arrayList;
    }

    public void g(x xVar) {
        for (d.a.c.j.e.a aVar : this.f54233c) {
            if (aVar != null) {
                aVar.a0(xVar);
            }
        }
    }

    public void h(b0 b0Var) {
        this.f54238h.g0(b0Var);
        this.f54237g.g0(b0Var);
        this.f54236f.g0(b0Var);
    }
}
