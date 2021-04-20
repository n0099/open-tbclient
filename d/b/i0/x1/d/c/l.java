package d.b.i0.x1.d.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f63927a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f63928b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f63929c;

    /* renamed from: d  reason: collision with root package name */
    public j f63930d;

    /* renamed from: e  reason: collision with root package name */
    public c f63931e;

    /* renamed from: f  reason: collision with root package name */
    public e f63932f;

    /* renamed from: g  reason: collision with root package name */
    public d f63933g;

    /* renamed from: h  reason: collision with root package name */
    public f f63934h;
    public k i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<d.b.c.j.e.a> o = new LinkedList();

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f63927a = tbPageContext;
        this.f63928b = bdUniqueId;
        this.f63929c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        j jVar = new j(this.f63927a, a2.N2, this.f63928b);
        this.f63930d = jVar;
        jVar.p0(this.f63929c);
        this.o.add(this.f63930d);
        c cVar = new c(this.f63927a, a2.S2, this.f63928b);
        this.f63931e = cVar;
        cVar.q0(this.f63929c);
        this.o.add(this.f63931e);
        e eVar = new e(this.f63927a, a2.Q2, this.f63928b);
        this.f63932f = eVar;
        eVar.p0(this.f63929c);
        this.o.add(this.f63932f);
        d dVar = new d(this.f63927a, a2.R2, this.f63928b);
        this.f63933g = dVar;
        dVar.p0(this.f63929c);
        this.o.add(this.f63933g);
        f fVar = new f(this.f63927a, a2.O2, this.f63928b);
        this.f63934h = fVar;
        fVar.p0(this.f63929c);
        this.o.add(this.f63934h);
        k kVar = new k(this.f63927a, a2.e3, this.f63928b);
        this.i = kVar;
        kVar.s0(this.f63929c);
        this.o.add(this.i);
        g gVar = new g(this.f63927a, a2.X2, this.f63928b);
        this.j = gVar;
        gVar.p0(this.f63929c);
        this.o.add(this.j);
        h hVar = new h(this.f63927a, a2.T2, this.f63928b);
        this.k = hVar;
        hVar.p0(this.f63929c);
        this.o.add(this.k);
        b bVar = new b(this.f63927a, a2.W2, this.f63928b);
        this.l = bVar;
        bVar.q0(this.f63929c);
        this.o.add(this.l);
        m mVar = new m(this.f63927a, w.f51320f);
        this.m = mVar;
        mVar.o0(this.f63929c);
        this.o.add(this.m);
        i iVar = new i(this.f63927a, d.b.i0.x.e0.k.o0);
        this.n = iVar;
        this.o.add(iVar);
        this.f63929c.a(this.o);
    }

    public void b(boolean z) {
        for (d.b.c.j.e.a aVar : this.o) {
            if (aVar instanceof a) {
                ((a) aVar).i0(z);
            }
        }
    }

    public void c() {
        this.f63929c.getAdapter().notifyDataSetChanged();
    }

    public void d(List<? extends n> list) {
        this.f63929c.setData(list);
    }
}
