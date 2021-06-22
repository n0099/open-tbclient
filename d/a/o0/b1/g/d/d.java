package d.a.o0.b1.g.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55402a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55403b;

    /* renamed from: c  reason: collision with root package name */
    public s f55404c;

    /* renamed from: d  reason: collision with root package name */
    public c f55405d;

    /* renamed from: e  reason: collision with root package name */
    public h f55406e;

    /* renamed from: f  reason: collision with root package name */
    public b f55407f;

    /* renamed from: g  reason: collision with root package name */
    public f f55408g;

    /* renamed from: h  reason: collision with root package name */
    public e f55409h;

    /* renamed from: i  reason: collision with root package name */
    public g f55410i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
        this.f55402a = tbPageContext;
        this.f55404c = sVar;
        a();
    }

    public final void a() {
        this.f55403b = new ArrayList();
        c cVar = new c(this.f55402a);
        this.f55405d = cVar;
        cVar.i0(this.f55404c);
        this.f55403b.add(this.f55405d);
        h hVar = new h(this.f55402a);
        this.f55406e = hVar;
        hVar.i0(this.f55404c);
        this.f55403b.add(this.f55406e);
        b bVar = new b(this.f55402a);
        this.f55407f = bVar;
        bVar.i0(this.f55404c);
        this.f55403b.add(this.f55407f);
        f fVar = new f(this.f55402a);
        this.f55408g = fVar;
        fVar.i0(this.f55404c);
        this.f55403b.add(this.f55408g);
        e eVar = new e(this.f55402a);
        this.f55409h = eVar;
        eVar.i0(this.f55404c);
        this.f55403b.add(this.f55409h);
        g gVar = new g(this.f55402a);
        this.f55410i = gVar;
        gVar.i0(this.f55404c);
        this.f55403b.add(this.f55410i);
        i iVar = new i(this.f55402a);
        this.j = iVar;
        iVar.i0(this.f55404c);
        this.f55403b.add(this.j);
        this.f55404c.a(this.f55403b);
    }

    public void b() {
        s sVar = this.f55404c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        s sVar = this.f55404c;
        if (sVar != null) {
            sVar.setData(list);
            b();
        }
    }

    public void d(d.a.n0.m.f fVar) {
        for (d.a.c.k.e.a aVar : this.f55403b) {
            if (aVar instanceof a) {
                ((a) aVar).h0(fVar);
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        for (d.a.c.k.e.a aVar : this.f55403b) {
            aVar.c0(bdUniqueId);
        }
    }
}
