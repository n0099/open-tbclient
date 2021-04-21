package d.b.j0.x1.d.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f64348a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f64349b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f64350c;

    /* renamed from: d  reason: collision with root package name */
    public j f64351d;

    /* renamed from: e  reason: collision with root package name */
    public c f64352e;

    /* renamed from: f  reason: collision with root package name */
    public e f64353f;

    /* renamed from: g  reason: collision with root package name */
    public d f64354g;

    /* renamed from: h  reason: collision with root package name */
    public f f64355h;
    public k i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<d.b.c.j.e.a> o = new LinkedList();

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f64348a = tbPageContext;
        this.f64349b = bdUniqueId;
        this.f64350c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        j jVar = new j(this.f64348a, a2.N2, this.f64349b);
        this.f64351d = jVar;
        jVar.p0(this.f64350c);
        this.o.add(this.f64351d);
        c cVar = new c(this.f64348a, a2.S2, this.f64349b);
        this.f64352e = cVar;
        cVar.q0(this.f64350c);
        this.o.add(this.f64352e);
        e eVar = new e(this.f64348a, a2.Q2, this.f64349b);
        this.f64353f = eVar;
        eVar.p0(this.f64350c);
        this.o.add(this.f64353f);
        d dVar = new d(this.f64348a, a2.R2, this.f64349b);
        this.f64354g = dVar;
        dVar.p0(this.f64350c);
        this.o.add(this.f64354g);
        f fVar = new f(this.f64348a, a2.O2, this.f64349b);
        this.f64355h = fVar;
        fVar.p0(this.f64350c);
        this.o.add(this.f64355h);
        k kVar = new k(this.f64348a, a2.e3, this.f64349b);
        this.i = kVar;
        kVar.s0(this.f64350c);
        this.o.add(this.i);
        g gVar = new g(this.f64348a, a2.X2, this.f64349b);
        this.j = gVar;
        gVar.p0(this.f64350c);
        this.o.add(this.j);
        h hVar = new h(this.f64348a, a2.T2, this.f64349b);
        this.k = hVar;
        hVar.p0(this.f64350c);
        this.o.add(this.k);
        b bVar = new b(this.f64348a, a2.W2, this.f64349b);
        this.l = bVar;
        bVar.q0(this.f64350c);
        this.o.add(this.l);
        m mVar = new m(this.f64348a, w.f51656f);
        this.m = mVar;
        mVar.o0(this.f64350c);
        this.o.add(this.m);
        i iVar = new i(this.f64348a, d.b.j0.x.e0.k.o0);
        this.n = iVar;
        this.o.add(iVar);
        this.f64350c.a(this.o);
    }

    public void b(boolean z) {
        for (d.b.c.j.e.a aVar : this.o) {
            if (aVar instanceof a) {
                ((a) aVar).i0(z);
            }
        }
    }

    public void c() {
        this.f64350c.getAdapter().notifyDataSetChanged();
    }

    public void d(List<? extends n> list) {
        this.f64350c.setData(list);
    }
}
