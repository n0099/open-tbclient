package d.b.i0.f1.b.p;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.c.j.e.x;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f55925a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f55926b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f55927c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    public b f55928d;

    /* renamed from: e  reason: collision with root package name */
    public b f55929e;

    /* renamed from: f  reason: collision with root package name */
    public b f55930f;

    /* renamed from: g  reason: collision with root package name */
    public b f55931g;

    /* renamed from: h  reason: collision with root package name */
    public b f55932h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f55925a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55925a;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.D(i);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        this.f55928d = new b(tbPageContext, a.x);
        this.f55929e = new b(tbPageContext, a.y);
        this.f55930f = new b(tbPageContext, a.B);
        this.f55931g = new b(tbPageContext, a.A);
        this.f55932h = new b(tbPageContext, a.z);
        this.f55927c.add(this.f55928d);
        this.f55927c.add(this.f55929e);
        this.f55927c.add(this.f55930f);
        this.f55927c.add(this.f55931g);
        this.f55927c.add(this.f55932h);
        this.f55925a.a(this.f55927c);
    }

    public void c() {
        this.f55925a.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        for (d.b.c.j.e.a aVar : this.f55927c) {
        }
    }

    public void e(w wVar) {
        for (d.b.c.j.e.a aVar : this.f55927c) {
            if (aVar != null) {
                aVar.c0(wVar);
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        this.f55925a.setData(arrayList);
        this.f55926b = arrayList;
    }

    public void g(x xVar) {
        for (d.b.c.j.e.a aVar : this.f55927c) {
            if (aVar != null) {
                aVar.d0(xVar);
            }
        }
    }

    public void h(b0 b0Var) {
        this.f55932h.j0(b0Var);
        this.f55931g.j0(b0Var);
        this.f55930f.j0(b0Var);
    }
}
