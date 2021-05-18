package d.a.k0.x1.d.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f63340a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f63341b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f63342c;

    /* renamed from: d  reason: collision with root package name */
    public j f63343d;

    /* renamed from: e  reason: collision with root package name */
    public c f63344e;

    /* renamed from: f  reason: collision with root package name */
    public e f63345f;

    /* renamed from: g  reason: collision with root package name */
    public d f63346g;

    /* renamed from: h  reason: collision with root package name */
    public f f63347h;

    /* renamed from: i  reason: collision with root package name */
    public k f63348i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<d.a.c.j.e.a> o = new LinkedList();

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f63340a = tbPageContext;
        this.f63341b = bdUniqueId;
        this.f63342c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        j jVar = new j(this.f63340a, a2.O2, this.f63341b);
        this.f63343d = jVar;
        jVar.n0(this.f63342c);
        this.o.add(this.f63343d);
        c cVar = new c(this.f63340a, a2.T2, this.f63341b);
        this.f63344e = cVar;
        cVar.p0(this.f63342c);
        this.o.add(this.f63344e);
        e eVar = new e(this.f63340a, a2.R2, this.f63341b);
        this.f63345f = eVar;
        eVar.n0(this.f63342c);
        this.o.add(this.f63345f);
        d dVar = new d(this.f63340a, a2.S2, this.f63341b);
        this.f63346g = dVar;
        dVar.n0(this.f63342c);
        this.o.add(this.f63346g);
        f fVar = new f(this.f63340a, a2.P2, this.f63341b);
        this.f63347h = fVar;
        fVar.n0(this.f63342c);
        this.o.add(this.f63347h);
        k kVar = new k(this.f63340a, a2.f3, this.f63341b);
        this.f63348i = kVar;
        kVar.s0(this.f63342c);
        this.o.add(this.f63348i);
        g gVar = new g(this.f63340a, a2.Y2, this.f63341b);
        this.j = gVar;
        gVar.n0(this.f63342c);
        this.o.add(this.j);
        h hVar = new h(this.f63340a, a2.U2, this.f63341b);
        this.k = hVar;
        hVar.n0(this.f63342c);
        this.o.add(this.k);
        b bVar = new b(this.f63340a, a2.X2, this.f63341b);
        this.l = bVar;
        bVar.p0(this.f63342c);
        this.o.add(this.l);
        m mVar = new m(this.f63340a, w.f50110f);
        this.m = mVar;
        mVar.m0(this.f63342c);
        this.o.add(this.m);
        i iVar = new i(this.f63340a, d.a.k0.x.e0.k.p0);
        this.n = iVar;
        this.o.add(iVar);
        this.f63342c.a(this.o);
    }

    public void b(boolean z) {
        for (d.a.c.j.e.a aVar : this.o) {
            if (aVar instanceof a) {
                ((a) aVar).f0(z);
            }
        }
    }

    public void c() {
        this.f63342c.getAdapter().notifyDataSetChanged();
    }

    public void d(List<? extends n> list) {
        this.f63342c.setData(list);
    }
}
