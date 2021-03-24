package d.b.i0.e1.b.p;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.w;
import d.b.b.j.e.x;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f54483a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f54484b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f54485c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    public b f54486d;

    /* renamed from: e  reason: collision with root package name */
    public b f54487e;

    /* renamed from: f  reason: collision with root package name */
    public b f54488f;

    /* renamed from: g  reason: collision with root package name */
    public b f54489g;

    /* renamed from: h  reason: collision with root package name */
    public b f54490h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f54483a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f54483a;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.D(i);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        this.f54486d = new b(tbPageContext, a.x);
        this.f54487e = new b(tbPageContext, a.y);
        this.f54488f = new b(tbPageContext, a.B);
        this.f54489g = new b(tbPageContext, a.A);
        this.f54490h = new b(tbPageContext, a.z);
        this.f54485c.add(this.f54486d);
        this.f54485c.add(this.f54487e);
        this.f54485c.add(this.f54488f);
        this.f54485c.add(this.f54489g);
        this.f54485c.add(this.f54490h);
        this.f54483a.a(this.f54485c);
    }

    public void c() {
        this.f54483a.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        for (d.b.b.j.e.a aVar : this.f54485c) {
        }
    }

    public void e(w wVar) {
        for (d.b.b.j.e.a aVar : this.f54485c) {
            if (aVar != null) {
                aVar.c0(wVar);
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        this.f54483a.setData(arrayList);
        this.f54484b = arrayList;
    }

    public void g(x xVar) {
        for (d.b.b.j.e.a aVar : this.f54485c) {
            if (aVar != null) {
                aVar.d0(xVar);
            }
        }
    }

    public void h(b0 b0Var) {
        this.f54490h.j0(b0Var);
        this.f54489g.j0(b0Var);
        this.f54488f.j0(b0Var);
    }
}
