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
    public TbPageContext<?> f52502a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.b.j.e.a> f52503b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f52504c;

    /* renamed from: d  reason: collision with root package name */
    public c f52505d;

    /* renamed from: e  reason: collision with root package name */
    public d f52506e;

    /* renamed from: f  reason: collision with root package name */
    public e f52507f;

    /* renamed from: g  reason: collision with root package name */
    public f f52508g;

    /* renamed from: h  reason: collision with root package name */
    public g f52509h;
    public h i;

    public b(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f52504c = bdTypeRecyclerView;
        this.f52502a = tbPageContext;
        a();
        d(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.f52503b);
    }

    public final void a() {
        this.f52507f = new e(this.f52502a, k.x0);
        this.f52506e = new d(this.f52502a, k.y0);
        this.f52505d = new c(this.f52502a, k.z0);
        this.f52508g = new f(this.f52502a, k.w0);
        this.f52509h = new g(this.f52502a, k.B0);
        this.i = new h(this.f52502a, l.V);
        this.f52503b.add(this.f52507f);
        this.f52503b.add(this.f52506e);
        this.f52503b.add(this.f52505d);
        this.f52503b.add(this.f52508g);
        this.f52503b.add(this.f52509h);
        this.f52503b.add(this.i);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52504c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c() {
        b();
    }

    public final void d(s sVar) {
        this.f52507f.n0(sVar);
        this.f52506e.n0(sVar);
        this.f52505d.n0(sVar);
        this.f52508g.n0(sVar);
        this.f52509h.n0(sVar);
        this.i.q0(sVar);
    }

    public void e(List<n> list) {
        this.f52504c.setData(list);
    }
}
