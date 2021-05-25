package d.a.n0.g1.b.p;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.c.j.e.x;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f55126a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f55127b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f55128c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    public b f55129d;

    /* renamed from: e  reason: collision with root package name */
    public b f55130e;

    /* renamed from: f  reason: collision with root package name */
    public b f55131f;

    /* renamed from: g  reason: collision with root package name */
    public b f55132g;

    /* renamed from: h  reason: collision with root package name */
    public b f55133h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f55126a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55126a;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.D(i2);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        this.f55129d = new b(tbPageContext, a.x);
        this.f55130e = new b(tbPageContext, a.y);
        this.f55131f = new b(tbPageContext, a.B);
        this.f55132g = new b(tbPageContext, a.A);
        this.f55133h = new b(tbPageContext, a.z);
        this.f55128c.add(this.f55129d);
        this.f55128c.add(this.f55130e);
        this.f55128c.add(this.f55131f);
        this.f55128c.add(this.f55132g);
        this.f55128c.add(this.f55133h);
        this.f55126a.a(this.f55128c);
    }

    public void c() {
        this.f55126a.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        for (d.a.c.j.e.a aVar : this.f55128c) {
        }
    }

    public void e(w wVar) {
        for (d.a.c.j.e.a aVar : this.f55128c) {
            if (aVar != null) {
                aVar.Z(wVar);
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        this.f55126a.setData(arrayList);
        this.f55127b = arrayList;
    }

    public void g(x xVar) {
        for (d.a.c.j.e.a aVar : this.f55128c) {
            if (aVar != null) {
                aVar.a0(xVar);
            }
        }
    }

    public void h(b0 b0Var) {
        this.f55133h.g0(b0Var);
        this.f55132g.g0(b0Var);
        this.f55131f.g0(b0Var);
    }
}
