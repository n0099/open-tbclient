package d.b.i0.w1.d.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f62130a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f62131b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f62132c;

    /* renamed from: d  reason: collision with root package name */
    public j f62133d;

    /* renamed from: e  reason: collision with root package name */
    public c f62134e;

    /* renamed from: f  reason: collision with root package name */
    public e f62135f;

    /* renamed from: g  reason: collision with root package name */
    public d f62136g;

    /* renamed from: h  reason: collision with root package name */
    public f f62137h;
    public k i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<d.b.b.j.e.a> o = new LinkedList();

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f62130a = tbPageContext;
        this.f62131b = bdUniqueId;
        this.f62132c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        j jVar = new j(this.f62130a, a2.N2, this.f62131b);
        this.f62133d = jVar;
        jVar.p0(this.f62132c);
        this.o.add(this.f62133d);
        c cVar = new c(this.f62130a, a2.S2, this.f62131b);
        this.f62134e = cVar;
        cVar.q0(this.f62132c);
        this.o.add(this.f62134e);
        e eVar = new e(this.f62130a, a2.Q2, this.f62131b);
        this.f62135f = eVar;
        eVar.p0(this.f62132c);
        this.o.add(this.f62135f);
        d dVar = new d(this.f62130a, a2.R2, this.f62131b);
        this.f62136g = dVar;
        dVar.p0(this.f62132c);
        this.o.add(this.f62136g);
        f fVar = new f(this.f62130a, a2.O2, this.f62131b);
        this.f62137h = fVar;
        fVar.p0(this.f62132c);
        this.o.add(this.f62137h);
        k kVar = new k(this.f62130a, a2.e3, this.f62131b);
        this.i = kVar;
        kVar.s0(this.f62132c);
        this.o.add(this.i);
        g gVar = new g(this.f62130a, a2.X2, this.f62131b);
        this.j = gVar;
        gVar.p0(this.f62132c);
        this.o.add(this.j);
        h hVar = new h(this.f62130a, a2.T2, this.f62131b);
        this.k = hVar;
        hVar.p0(this.f62132c);
        this.o.add(this.k);
        b bVar = new b(this.f62130a, a2.W2, this.f62131b);
        this.l = bVar;
        bVar.q0(this.f62132c);
        this.o.add(this.l);
        m mVar = new m(this.f62130a, w.f50912f);
        this.m = mVar;
        mVar.o0(this.f62132c);
        this.o.add(this.m);
        i iVar = new i(this.f62130a, d.b.i0.x.e0.k.o0);
        this.n = iVar;
        this.o.add(iVar);
        this.f62132c.a(this.o);
    }

    public void b(boolean z) {
        for (d.b.b.j.e.a aVar : this.o) {
            if (aVar instanceof a) {
                ((a) aVar).i0(z);
            }
        }
    }

    public void c() {
        this.f62132c.getAdapter().notifyDataSetChanged();
    }

    public void d(List<? extends n> list) {
        this.f62132c.setData(list);
    }
}
