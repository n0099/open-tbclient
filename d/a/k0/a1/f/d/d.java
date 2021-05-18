package d.a.k0.a1.f.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51429a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51430b;

    /* renamed from: c  reason: collision with root package name */
    public s f51431c;

    /* renamed from: d  reason: collision with root package name */
    public c f51432d;

    /* renamed from: e  reason: collision with root package name */
    public h f51433e;

    /* renamed from: f  reason: collision with root package name */
    public b f51434f;

    /* renamed from: g  reason: collision with root package name */
    public f f51435g;

    /* renamed from: h  reason: collision with root package name */
    public e f51436h;

    /* renamed from: i  reason: collision with root package name */
    public g f51437i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
        this.f51429a = tbPageContext;
        this.f51431c = sVar;
        a();
    }

    public final void a() {
        this.f51430b = new ArrayList();
        c cVar = new c(this.f51429a);
        this.f51432d = cVar;
        cVar.h0(this.f51431c);
        this.f51430b.add(this.f51432d);
        h hVar = new h(this.f51429a);
        this.f51433e = hVar;
        hVar.h0(this.f51431c);
        this.f51430b.add(this.f51433e);
        b bVar = new b(this.f51429a);
        this.f51434f = bVar;
        bVar.h0(this.f51431c);
        this.f51430b.add(this.f51434f);
        f fVar = new f(this.f51429a);
        this.f51435g = fVar;
        fVar.h0(this.f51431c);
        this.f51430b.add(this.f51435g);
        e eVar = new e(this.f51429a);
        this.f51436h = eVar;
        eVar.h0(this.f51431c);
        this.f51430b.add(this.f51436h);
        g gVar = new g(this.f51429a);
        this.f51437i = gVar;
        gVar.h0(this.f51431c);
        this.f51430b.add(this.f51437i);
        i iVar = new i(this.f51429a);
        this.j = iVar;
        iVar.h0(this.f51431c);
        this.f51430b.add(this.j);
        this.f51431c.a(this.f51430b);
    }

    public void b() {
        s sVar = this.f51431c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        s sVar = this.f51431c;
        if (sVar != null) {
            sVar.setData(list);
            b();
        }
    }

    public void d(d.a.j0.m.f fVar) {
        for (d.a.c.j.e.a aVar : this.f51430b) {
            if (aVar instanceof a) {
                ((a) aVar).g0(fVar);
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        for (d.a.c.j.e.a aVar : this.f51430b) {
            aVar.b0(bdUniqueId);
        }
    }
}
