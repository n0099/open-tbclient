package d.a.n0.y1.d.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f67102a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f67103b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f67104c;

    /* renamed from: d  reason: collision with root package name */
    public j f67105d;

    /* renamed from: e  reason: collision with root package name */
    public c f67106e;

    /* renamed from: f  reason: collision with root package name */
    public e f67107f;

    /* renamed from: g  reason: collision with root package name */
    public d f67108g;

    /* renamed from: h  reason: collision with root package name */
    public f f67109h;

    /* renamed from: i  reason: collision with root package name */
    public k f67110i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<d.a.c.k.e.a> o = new LinkedList();

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f67102a = tbPageContext;
        this.f67103b = bdUniqueId;
        this.f67104c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        j jVar = new j(this.f67102a, a2.S2, this.f67103b);
        this.f67105d = jVar;
        jVar.m0(this.f67104c);
        this.o.add(this.f67105d);
        c cVar = new c(this.f67102a, a2.X2, this.f67103b);
        this.f67106e = cVar;
        cVar.p0(this.f67104c);
        this.o.add(this.f67106e);
        e eVar = new e(this.f67102a, a2.V2, this.f67103b);
        this.f67107f = eVar;
        eVar.m0(this.f67104c);
        this.o.add(this.f67107f);
        d dVar = new d(this.f67102a, a2.W2, this.f67103b);
        this.f67108g = dVar;
        dVar.m0(this.f67104c);
        this.o.add(this.f67108g);
        f fVar = new f(this.f67102a, a2.T2, this.f67103b);
        this.f67109h = fVar;
        fVar.m0(this.f67104c);
        this.o.add(this.f67109h);
        k kVar = new k(this.f67102a, a2.j3, this.f67103b);
        this.f67110i = kVar;
        kVar.s0(this.f67104c);
        this.o.add(this.f67110i);
        g gVar = new g(this.f67102a, a2.c3, this.f67103b);
        this.j = gVar;
        gVar.m0(this.f67104c);
        this.o.add(this.j);
        h hVar = new h(this.f67102a, a2.Y2, this.f67103b);
        this.k = hVar;
        hVar.m0(this.f67104c);
        this.o.add(this.k);
        b bVar = new b(this.f67102a, a2.b3, this.f67103b);
        this.l = bVar;
        bVar.p0(this.f67104c);
        this.o.add(this.l);
        m mVar = new m(this.f67102a, w.f53830f);
        this.m = mVar;
        mVar.l0(this.f67104c);
        this.o.add(this.m);
        i iVar = new i(this.f67102a, d.a.n0.z.e0.k.p0);
        this.n = iVar;
        this.o.add(iVar);
        this.f67104c.a(this.o);
    }

    public void b(boolean z) {
        for (d.a.c.k.e.a aVar : this.o) {
            if (aVar instanceof a) {
                ((a) aVar).g0(z);
            }
        }
    }

    public void c() {
        this.f67104c.getAdapter().notifyDataSetChanged();
    }

    public void d(List<? extends n> list) {
        this.f67104c.setData(list);
    }
}
