package d.a.o0.g1.b.p;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.c.k.e.x;
import d.a.o0.z.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f58940a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f58941b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f58942c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    public b f58943d;

    /* renamed from: e  reason: collision with root package name */
    public b f58944e;

    /* renamed from: f  reason: collision with root package name */
    public b f58945f;

    /* renamed from: g  reason: collision with root package name */
    public b f58946g;

    /* renamed from: h  reason: collision with root package name */
    public b f58947h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f58940a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58940a;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.D(i2);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        this.f58943d = new b(tbPageContext, a.x);
        this.f58944e = new b(tbPageContext, a.y);
        this.f58945f = new b(tbPageContext, a.B);
        this.f58946g = new b(tbPageContext, a.A);
        this.f58947h = new b(tbPageContext, a.z);
        this.f58942c.add(this.f58943d);
        this.f58942c.add(this.f58944e);
        this.f58942c.add(this.f58945f);
        this.f58942c.add(this.f58946g);
        this.f58942c.add(this.f58947h);
        this.f58940a.a(this.f58942c);
    }

    public void c() {
        this.f58940a.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        for (d.a.c.k.e.a aVar : this.f58942c) {
        }
    }

    public void e(w wVar) {
        for (d.a.c.k.e.a aVar : this.f58942c) {
            if (aVar != null) {
                aVar.a0(wVar);
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        this.f58940a.setData(arrayList);
        this.f58941b = arrayList;
    }

    public void g(x xVar) {
        for (d.a.c.k.e.a aVar : this.f58942c) {
            if (aVar != null) {
                aVar.b0(xVar);
            }
        }
    }

    public void h(b0 b0Var) {
        this.f58947h.h0(b0Var);
        this.f58946g.h0(b0Var);
        this.f58945f.h0(b0Var);
    }
}
