package d.b.j0.f1.b.p;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.c.j.e.x;
import d.b.j0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f56346a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f56347b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f56348c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    public b f56349d;

    /* renamed from: e  reason: collision with root package name */
    public b f56350e;

    /* renamed from: f  reason: collision with root package name */
    public b f56351f;

    /* renamed from: g  reason: collision with root package name */
    public b f56352g;

    /* renamed from: h  reason: collision with root package name */
    public b f56353h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f56346a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f56346a;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.D(i);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        this.f56349d = new b(tbPageContext, a.x);
        this.f56350e = new b(tbPageContext, a.y);
        this.f56351f = new b(tbPageContext, a.B);
        this.f56352g = new b(tbPageContext, a.A);
        this.f56353h = new b(tbPageContext, a.z);
        this.f56348c.add(this.f56349d);
        this.f56348c.add(this.f56350e);
        this.f56348c.add(this.f56351f);
        this.f56348c.add(this.f56352g);
        this.f56348c.add(this.f56353h);
        this.f56346a.a(this.f56348c);
    }

    public void c() {
        this.f56346a.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        for (d.b.c.j.e.a aVar : this.f56348c) {
        }
    }

    public void e(w wVar) {
        for (d.b.c.j.e.a aVar : this.f56348c) {
            if (aVar != null) {
                aVar.c0(wVar);
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        this.f56346a.setData(arrayList);
        this.f56347b = arrayList;
    }

    public void g(x xVar) {
        for (d.b.c.j.e.a aVar : this.f56348c) {
            if (aVar != null) {
                aVar.d0(xVar);
            }
        }
    }

    public void h(b0 b0Var) {
        this.f56353h.j0(b0Var);
        this.f56352g.j0(b0Var);
        this.f56351f.j0(b0Var);
    }
}
