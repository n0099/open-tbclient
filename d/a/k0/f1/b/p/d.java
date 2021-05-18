package d.a.k0.f1.b.p;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.c.j.e.x;
import d.a.k0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f54938a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f54939b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f54940c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    public b f54941d;

    /* renamed from: e  reason: collision with root package name */
    public b f54942e;

    /* renamed from: f  reason: collision with root package name */
    public b f54943f;

    /* renamed from: g  reason: collision with root package name */
    public b f54944g;

    /* renamed from: h  reason: collision with root package name */
    public b f54945h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f54938a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f54938a;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.D(i2);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        this.f54941d = new b(tbPageContext, a.x);
        this.f54942e = new b(tbPageContext, a.y);
        this.f54943f = new b(tbPageContext, a.B);
        this.f54944g = new b(tbPageContext, a.A);
        this.f54945h = new b(tbPageContext, a.z);
        this.f54940c.add(this.f54941d);
        this.f54940c.add(this.f54942e);
        this.f54940c.add(this.f54943f);
        this.f54940c.add(this.f54944g);
        this.f54940c.add(this.f54945h);
        this.f54938a.a(this.f54940c);
    }

    public void c() {
        this.f54938a.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        for (d.a.c.j.e.a aVar : this.f54940c) {
        }
    }

    public void e(w wVar) {
        for (d.a.c.j.e.a aVar : this.f54940c) {
            if (aVar != null) {
                aVar.Z(wVar);
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        this.f54938a.setData(arrayList);
        this.f54939b = arrayList;
    }

    public void g(x xVar) {
        for (d.a.c.j.e.a aVar : this.f54940c) {
            if (aVar != null) {
                aVar.a0(xVar);
            }
        }
    }

    public void h(b0 b0Var) {
        this.f54945h.g0(b0Var);
        this.f54944g.g0(b0Var);
        this.f54943f.g0(b0Var);
    }
}
