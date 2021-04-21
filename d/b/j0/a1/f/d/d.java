package d.b.j0.a1.f.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53028a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.c.j.e.a> f53029b;

    /* renamed from: c  reason: collision with root package name */
    public s f53030c;

    /* renamed from: d  reason: collision with root package name */
    public c f53031d;

    /* renamed from: e  reason: collision with root package name */
    public h f53032e;

    /* renamed from: f  reason: collision with root package name */
    public b f53033f;

    /* renamed from: g  reason: collision with root package name */
    public f f53034g;

    /* renamed from: h  reason: collision with root package name */
    public e f53035h;
    public g i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
        this.f53028a = tbPageContext;
        this.f53030c = sVar;
        a();
    }

    public final void a() {
        this.f53029b = new ArrayList();
        c cVar = new c(this.f53028a);
        this.f53031d = cVar;
        cVar.l0(this.f53030c);
        this.f53029b.add(this.f53031d);
        h hVar = new h(this.f53028a);
        this.f53032e = hVar;
        hVar.l0(this.f53030c);
        this.f53029b.add(this.f53032e);
        b bVar = new b(this.f53028a);
        this.f53033f = bVar;
        bVar.l0(this.f53030c);
        this.f53029b.add(this.f53033f);
        f fVar = new f(this.f53028a);
        this.f53034g = fVar;
        fVar.l0(this.f53030c);
        this.f53029b.add(this.f53034g);
        e eVar = new e(this.f53028a);
        this.f53035h = eVar;
        eVar.l0(this.f53030c);
        this.f53029b.add(this.f53035h);
        g gVar = new g(this.f53028a);
        this.i = gVar;
        gVar.l0(this.f53030c);
        this.f53029b.add(this.i);
        i iVar = new i(this.f53028a);
        this.j = iVar;
        iVar.l0(this.f53030c);
        this.f53029b.add(this.j);
        this.f53030c.a(this.f53029b);
    }

    public void b() {
        s sVar = this.f53030c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        s sVar = this.f53030c;
        if (sVar != null) {
            sVar.setData(list);
            b();
        }
    }

    public void d(d.b.i0.m.f fVar) {
        for (d.b.c.j.e.a aVar : this.f53029b) {
            if (aVar instanceof a) {
                ((a) aVar).j0(fVar);
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        for (d.b.c.j.e.a aVar : this.f53029b) {
            aVar.f0(bdUniqueId);
        }
    }
}
