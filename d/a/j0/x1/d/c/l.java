package d.a.j0.x1.d.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f62616a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f62617b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f62618c;

    /* renamed from: d  reason: collision with root package name */
    public j f62619d;

    /* renamed from: e  reason: collision with root package name */
    public c f62620e;

    /* renamed from: f  reason: collision with root package name */
    public e f62621f;

    /* renamed from: g  reason: collision with root package name */
    public d f62622g;

    /* renamed from: h  reason: collision with root package name */
    public f f62623h;

    /* renamed from: i  reason: collision with root package name */
    public k f62624i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<d.a.c.j.e.a> o = new LinkedList();

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f62616a = tbPageContext;
        this.f62617b = bdUniqueId;
        this.f62618c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        j jVar = new j(this.f62616a, a2.N2, this.f62617b);
        this.f62619d = jVar;
        jVar.n0(this.f62618c);
        this.o.add(this.f62619d);
        c cVar = new c(this.f62616a, a2.S2, this.f62617b);
        this.f62620e = cVar;
        cVar.p0(this.f62618c);
        this.o.add(this.f62620e);
        e eVar = new e(this.f62616a, a2.Q2, this.f62617b);
        this.f62621f = eVar;
        eVar.n0(this.f62618c);
        this.o.add(this.f62621f);
        d dVar = new d(this.f62616a, a2.R2, this.f62617b);
        this.f62622g = dVar;
        dVar.n0(this.f62618c);
        this.o.add(this.f62622g);
        f fVar = new f(this.f62616a, a2.O2, this.f62617b);
        this.f62623h = fVar;
        fVar.n0(this.f62618c);
        this.o.add(this.f62623h);
        k kVar = new k(this.f62616a, a2.e3, this.f62617b);
        this.f62624i = kVar;
        kVar.r0(this.f62618c);
        this.o.add(this.f62624i);
        g gVar = new g(this.f62616a, a2.X2, this.f62617b);
        this.j = gVar;
        gVar.n0(this.f62618c);
        this.o.add(this.j);
        h hVar = new h(this.f62616a, a2.T2, this.f62617b);
        this.k = hVar;
        hVar.n0(this.f62618c);
        this.o.add(this.k);
        b bVar = new b(this.f62616a, a2.W2, this.f62617b);
        this.l = bVar;
        bVar.p0(this.f62618c);
        this.o.add(this.l);
        m mVar = new m(this.f62616a, w.f49291f);
        this.m = mVar;
        mVar.m0(this.f62618c);
        this.o.add(this.m);
        i iVar = new i(this.f62616a, d.a.j0.x.e0.k.o0);
        this.n = iVar;
        this.o.add(iVar);
        this.f62618c.a(this.o);
    }

    public void b(boolean z) {
        for (d.a.c.j.e.a aVar : this.o) {
            if (aVar instanceof a) {
                ((a) aVar).f0(z);
            }
        }
    }

    public void c() {
        this.f62618c.getAdapter().notifyDataSetChanged();
    }

    public void d(List<? extends n> list) {
        this.f62618c.setData(list);
    }
}
