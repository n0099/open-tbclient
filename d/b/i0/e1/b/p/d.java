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
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f54484a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f54485b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f54486c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    public b f54487d;

    /* renamed from: e  reason: collision with root package name */
    public b f54488e;

    /* renamed from: f  reason: collision with root package name */
    public b f54489f;

    /* renamed from: g  reason: collision with root package name */
    public b f54490g;

    /* renamed from: h  reason: collision with root package name */
    public b f54491h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f54484a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f54484a;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.D(i);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        this.f54487d = new b(tbPageContext, a.x);
        this.f54488e = new b(tbPageContext, a.y);
        this.f54489f = new b(tbPageContext, a.B);
        this.f54490g = new b(tbPageContext, a.A);
        this.f54491h = new b(tbPageContext, a.z);
        this.f54486c.add(this.f54487d);
        this.f54486c.add(this.f54488e);
        this.f54486c.add(this.f54489f);
        this.f54486c.add(this.f54490g);
        this.f54486c.add(this.f54491h);
        this.f54484a.a(this.f54486c);
    }

    public void c() {
        this.f54484a.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        for (d.b.b.j.e.a aVar : this.f54486c) {
        }
    }

    public void e(w wVar) {
        for (d.b.b.j.e.a aVar : this.f54486c) {
            if (aVar != null) {
                aVar.c0(wVar);
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        this.f54484a.setData(arrayList);
        this.f54485b = arrayList;
    }

    public void g(x xVar) {
        for (d.b.b.j.e.a aVar : this.f54486c) {
            if (aVar != null) {
                aVar.d0(xVar);
            }
        }
    }

    public void h(b0 b0Var) {
        this.f54491h.j0(b0Var);
        this.f54490g.j0(b0Var);
        this.f54489f.j0(b0Var);
    }
}
