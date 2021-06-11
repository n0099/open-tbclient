package d.a.n0.g1.b.p;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.c.k.e.x;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f58815a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f58816b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f58817c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    public b f58818d;

    /* renamed from: e  reason: collision with root package name */
    public b f58819e;

    /* renamed from: f  reason: collision with root package name */
    public b f58820f;

    /* renamed from: g  reason: collision with root package name */
    public b f58821g;

    /* renamed from: h  reason: collision with root package name */
    public b f58822h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f58815a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58815a;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.D(i2);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        this.f58818d = new b(tbPageContext, a.x);
        this.f58819e = new b(tbPageContext, a.y);
        this.f58820f = new b(tbPageContext, a.B);
        this.f58821g = new b(tbPageContext, a.A);
        this.f58822h = new b(tbPageContext, a.z);
        this.f58817c.add(this.f58818d);
        this.f58817c.add(this.f58819e);
        this.f58817c.add(this.f58820f);
        this.f58817c.add(this.f58821g);
        this.f58817c.add(this.f58822h);
        this.f58815a.a(this.f58817c);
    }

    public void c() {
        this.f58815a.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        for (d.a.c.k.e.a aVar : this.f58817c) {
        }
    }

    public void e(w wVar) {
        for (d.a.c.k.e.a aVar : this.f58817c) {
            if (aVar != null) {
                aVar.a0(wVar);
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        this.f58815a.setData(arrayList);
        this.f58816b = arrayList;
    }

    public void g(x xVar) {
        for (d.a.c.k.e.a aVar : this.f58817c) {
            if (aVar != null) {
                aVar.b0(xVar);
            }
        }
    }

    public void h(b0 b0Var) {
        this.f58822h.h0(b0Var);
        this.f58821g.h0(b0Var);
        this.f58820f.h0(b0Var);
    }
}
