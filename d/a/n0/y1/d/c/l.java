package d.a.n0.y1.d.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f63387a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f63388b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f63389c;

    /* renamed from: d  reason: collision with root package name */
    public j f63390d;

    /* renamed from: e  reason: collision with root package name */
    public c f63391e;

    /* renamed from: f  reason: collision with root package name */
    public e f63392f;

    /* renamed from: g  reason: collision with root package name */
    public d f63393g;

    /* renamed from: h  reason: collision with root package name */
    public f f63394h;

    /* renamed from: i  reason: collision with root package name */
    public k f63395i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<d.a.c.j.e.a> o = new LinkedList();

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f63387a = tbPageContext;
        this.f63388b = bdUniqueId;
        this.f63389c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        j jVar = new j(this.f63387a, a2.P2, this.f63388b);
        this.f63390d = jVar;
        jVar.n0(this.f63389c);
        this.o.add(this.f63390d);
        c cVar = new c(this.f63387a, a2.U2, this.f63388b);
        this.f63391e = cVar;
        cVar.p0(this.f63389c);
        this.o.add(this.f63391e);
        e eVar = new e(this.f63387a, a2.S2, this.f63388b);
        this.f63392f = eVar;
        eVar.n0(this.f63389c);
        this.o.add(this.f63392f);
        d dVar = new d(this.f63387a, a2.T2, this.f63388b);
        this.f63393g = dVar;
        dVar.n0(this.f63389c);
        this.o.add(this.f63393g);
        f fVar = new f(this.f63387a, a2.Q2, this.f63388b);
        this.f63394h = fVar;
        fVar.n0(this.f63389c);
        this.o.add(this.f63394h);
        k kVar = new k(this.f63387a, a2.g3, this.f63388b);
        this.f63395i = kVar;
        kVar.s0(this.f63389c);
        this.o.add(this.f63395i);
        g gVar = new g(this.f63387a, a2.Z2, this.f63388b);
        this.j = gVar;
        gVar.n0(this.f63389c);
        this.o.add(this.j);
        h hVar = new h(this.f63387a, a2.V2, this.f63388b);
        this.k = hVar;
        hVar.n0(this.f63389c);
        this.o.add(this.k);
        b bVar = new b(this.f63387a, a2.Y2, this.f63388b);
        this.l = bVar;
        bVar.p0(this.f63389c);
        this.o.add(this.l);
        m mVar = new m(this.f63387a, w.f50154f);
        this.m = mVar;
        mVar.m0(this.f63389c);
        this.o.add(this.m);
        i iVar = new i(this.f63387a, d.a.n0.z.e0.k.p0);
        this.n = iVar;
        this.o.add(iVar);
        this.f63389c.a(this.o);
    }

    public void b(boolean z) {
        for (d.a.c.j.e.a aVar : this.o) {
            if (aVar instanceof a) {
                ((a) aVar).f0(z);
            }
        }
    }

    public void c() {
        this.f63389c.getAdapter().notifyDataSetChanged();
    }

    public void d(List<? extends n> list) {
        this.f63389c.setData(list);
    }
}
