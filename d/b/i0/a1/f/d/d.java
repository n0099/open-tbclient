package d.b.i0.a1.f.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52607a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.c.j.e.a> f52608b;

    /* renamed from: c  reason: collision with root package name */
    public s f52609c;

    /* renamed from: d  reason: collision with root package name */
    public c f52610d;

    /* renamed from: e  reason: collision with root package name */
    public h f52611e;

    /* renamed from: f  reason: collision with root package name */
    public b f52612f;

    /* renamed from: g  reason: collision with root package name */
    public f f52613g;

    /* renamed from: h  reason: collision with root package name */
    public e f52614h;
    public g i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
        this.f52607a = tbPageContext;
        this.f52609c = sVar;
        a();
    }

    public final void a() {
        this.f52608b = new ArrayList();
        c cVar = new c(this.f52607a);
        this.f52610d = cVar;
        cVar.l0(this.f52609c);
        this.f52608b.add(this.f52610d);
        h hVar = new h(this.f52607a);
        this.f52611e = hVar;
        hVar.l0(this.f52609c);
        this.f52608b.add(this.f52611e);
        b bVar = new b(this.f52607a);
        this.f52612f = bVar;
        bVar.l0(this.f52609c);
        this.f52608b.add(this.f52612f);
        f fVar = new f(this.f52607a);
        this.f52613g = fVar;
        fVar.l0(this.f52609c);
        this.f52608b.add(this.f52613g);
        e eVar = new e(this.f52607a);
        this.f52614h = eVar;
        eVar.l0(this.f52609c);
        this.f52608b.add(this.f52614h);
        g gVar = new g(this.f52607a);
        this.i = gVar;
        gVar.l0(this.f52609c);
        this.f52608b.add(this.i);
        i iVar = new i(this.f52607a);
        this.j = iVar;
        iVar.l0(this.f52609c);
        this.f52608b.add(this.j);
        this.f52609c.a(this.f52608b);
    }

    public void b() {
        s sVar = this.f52609c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        s sVar = this.f52609c;
        if (sVar != null) {
            sVar.setData(list);
            b();
        }
    }

    public void d(d.b.h0.m.f fVar) {
        for (d.b.c.j.e.a aVar : this.f52608b) {
            if (aVar instanceof a) {
                ((a) aVar).j0(fVar);
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        for (d.b.c.j.e.a aVar : this.f52608b) {
            aVar.f0(bdUniqueId);
        }
    }
}
