package d.b.i0.c2.k.c;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import d.b.i0.x.e0.k;
import d.b.i0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f52501a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.b.j.e.a> f52502b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f52503c;

    /* renamed from: d  reason: collision with root package name */
    public c f52504d;

    /* renamed from: e  reason: collision with root package name */
    public d f52505e;

    /* renamed from: f  reason: collision with root package name */
    public e f52506f;

    /* renamed from: g  reason: collision with root package name */
    public f f52507g;

    /* renamed from: h  reason: collision with root package name */
    public g f52508h;
    public h i;

    public b(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f52503c = bdTypeRecyclerView;
        this.f52501a = tbPageContext;
        a();
        d(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.f52502b);
    }

    public final void a() {
        this.f52506f = new e(this.f52501a, k.x0);
        this.f52505e = new d(this.f52501a, k.y0);
        this.f52504d = new c(this.f52501a, k.z0);
        this.f52507g = new f(this.f52501a, k.w0);
        this.f52508h = new g(this.f52501a, k.B0);
        this.i = new h(this.f52501a, l.V);
        this.f52502b.add(this.f52506f);
        this.f52502b.add(this.f52505e);
        this.f52502b.add(this.f52504d);
        this.f52502b.add(this.f52507g);
        this.f52502b.add(this.f52508h);
        this.f52502b.add(this.i);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52503c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        b();
    }

    public final void d(s sVar) {
        this.f52506f.n0(sVar);
        this.f52505e.n0(sVar);
        this.f52504d.n0(sVar);
        this.f52507g.n0(sVar);
        this.f52508h.n0(sVar);
        this.i.q0(sVar);
    }

    public void e(List<n> list) {
        this.f52503c.setData(list);
    }
}
