package d.a.o0.y1.d.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f67227a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f67228b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f67229c;

    /* renamed from: d  reason: collision with root package name */
    public j f67230d;

    /* renamed from: e  reason: collision with root package name */
    public c f67231e;

    /* renamed from: f  reason: collision with root package name */
    public e f67232f;

    /* renamed from: g  reason: collision with root package name */
    public d f67233g;

    /* renamed from: h  reason: collision with root package name */
    public f f67234h;

    /* renamed from: i  reason: collision with root package name */
    public k f67235i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<d.a.c.k.e.a> o = new LinkedList();

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f67227a = tbPageContext;
        this.f67228b = bdUniqueId;
        this.f67229c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        j jVar = new j(this.f67227a, a2.S2, this.f67228b);
        this.f67230d = jVar;
        jVar.m0(this.f67229c);
        this.o.add(this.f67230d);
        c cVar = new c(this.f67227a, a2.X2, this.f67228b);
        this.f67231e = cVar;
        cVar.p0(this.f67229c);
        this.o.add(this.f67231e);
        e eVar = new e(this.f67227a, a2.V2, this.f67228b);
        this.f67232f = eVar;
        eVar.m0(this.f67229c);
        this.o.add(this.f67232f);
        d dVar = new d(this.f67227a, a2.W2, this.f67228b);
        this.f67233g = dVar;
        dVar.m0(this.f67229c);
        this.o.add(this.f67233g);
        f fVar = new f(this.f67227a, a2.T2, this.f67228b);
        this.f67234h = fVar;
        fVar.m0(this.f67229c);
        this.o.add(this.f67234h);
        k kVar = new k(this.f67227a, a2.j3, this.f67228b);
        this.f67235i = kVar;
        kVar.s0(this.f67229c);
        this.o.add(this.f67235i);
        g gVar = new g(this.f67227a, a2.c3, this.f67228b);
        this.j = gVar;
        gVar.m0(this.f67229c);
        this.o.add(this.j);
        h hVar = new h(this.f67227a, a2.Y2, this.f67228b);
        this.k = hVar;
        hVar.m0(this.f67229c);
        this.o.add(this.k);
        b bVar = new b(this.f67227a, a2.b3, this.f67228b);
        this.l = bVar;
        bVar.p0(this.f67229c);
        this.o.add(this.l);
        m mVar = new m(this.f67227a, w.f53937f);
        this.m = mVar;
        mVar.l0(this.f67229c);
        this.o.add(this.m);
        i iVar = new i(this.f67227a, d.a.o0.z.e0.k.u0);
        this.n = iVar;
        this.o.add(iVar);
        this.f67229c.a(this.o);
    }

    public void b(boolean z) {
        for (d.a.c.k.e.a aVar : this.o) {
            if (aVar instanceof a) {
                ((a) aVar).g0(z);
            }
        }
    }

    public void c() {
        this.f67229c.getAdapter().notifyDataSetChanged();
    }

    public void d(List<? extends n> list) {
        this.f67229c.setData(list);
    }
}
