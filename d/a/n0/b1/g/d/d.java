package d.a.n0.b1.g.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55277a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55278b;

    /* renamed from: c  reason: collision with root package name */
    public s f55279c;

    /* renamed from: d  reason: collision with root package name */
    public c f55280d;

    /* renamed from: e  reason: collision with root package name */
    public h f55281e;

    /* renamed from: f  reason: collision with root package name */
    public b f55282f;

    /* renamed from: g  reason: collision with root package name */
    public f f55283g;

    /* renamed from: h  reason: collision with root package name */
    public e f55284h;

    /* renamed from: i  reason: collision with root package name */
    public g f55285i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
        this.f55277a = tbPageContext;
        this.f55279c = sVar;
        a();
    }

    public final void a() {
        this.f55278b = new ArrayList();
        c cVar = new c(this.f55277a);
        this.f55280d = cVar;
        cVar.i0(this.f55279c);
        this.f55278b.add(this.f55280d);
        h hVar = new h(this.f55277a);
        this.f55281e = hVar;
        hVar.i0(this.f55279c);
        this.f55278b.add(this.f55281e);
        b bVar = new b(this.f55277a);
        this.f55282f = bVar;
        bVar.i0(this.f55279c);
        this.f55278b.add(this.f55282f);
        f fVar = new f(this.f55277a);
        this.f55283g = fVar;
        fVar.i0(this.f55279c);
        this.f55278b.add(this.f55283g);
        e eVar = new e(this.f55277a);
        this.f55284h = eVar;
        eVar.i0(this.f55279c);
        this.f55278b.add(this.f55284h);
        g gVar = new g(this.f55277a);
        this.f55285i = gVar;
        gVar.i0(this.f55279c);
        this.f55278b.add(this.f55285i);
        i iVar = new i(this.f55277a);
        this.j = iVar;
        iVar.i0(this.f55279c);
        this.f55278b.add(this.j);
        this.f55279c.a(this.f55278b);
    }

    public void b() {
        s sVar = this.f55279c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        s sVar = this.f55279c;
        if (sVar != null) {
            sVar.setData(list);
            b();
        }
    }

    public void d(d.a.m0.m.f fVar) {
        for (d.a.c.k.e.a aVar : this.f55278b) {
            if (aVar instanceof a) {
                ((a) aVar).h0(fVar);
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        for (d.a.c.k.e.a aVar : this.f55278b) {
            aVar.c0(bdUniqueId);
        }
    }
}
