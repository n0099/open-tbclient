package d.a.k0.a1.e.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51389a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51390b;

    /* renamed from: c  reason: collision with root package name */
    public s f51391c;

    /* renamed from: d  reason: collision with root package name */
    public g f51392d;

    /* renamed from: e  reason: collision with root package name */
    public k f51393e;

    /* renamed from: f  reason: collision with root package name */
    public b f51394f;

    /* renamed from: g  reason: collision with root package name */
    public d f51395g;

    /* renamed from: h  reason: collision with root package name */
    public c f51396h;

    /* renamed from: i  reason: collision with root package name */
    public e f51397i;
    public f j;

    public h(TbPageContext tbPageContext, s sVar) {
        this.f51389a = tbPageContext;
        this.f51391c = sVar;
        b();
    }

    public List<n> a() {
        return this.f51391c.getData();
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f51390b = arrayList;
        arrayList.add(new j(this.f51389a));
        this.f51390b.add(new i(this.f51389a));
        this.f51390b.add(new LoadingViewAdapter(this.f51389a));
        g gVar = new g(this.f51389a);
        this.f51392d = gVar;
        gVar.h0(this.f51391c);
        this.f51390b.add(this.f51392d);
        k kVar = new k(this.f51389a);
        this.f51393e = kVar;
        kVar.h0(this.f51391c);
        this.f51390b.add(this.f51393e);
        b bVar = new b(this.f51389a);
        this.f51394f = bVar;
        bVar.h0(this.f51391c);
        this.f51390b.add(this.f51394f);
        d dVar = new d(this.f51389a);
        this.f51395g = dVar;
        dVar.h0(this.f51391c);
        this.f51390b.add(this.f51395g);
        c cVar = new c(this.f51389a);
        this.f51396h = cVar;
        cVar.h0(this.f51391c);
        this.f51390b.add(this.f51396h);
        e eVar = new e(this.f51389a);
        this.f51397i = eVar;
        eVar.h0(this.f51391c);
        this.f51390b.add(this.f51397i);
        f fVar = new f(this.f51389a);
        this.j = fVar;
        fVar.h0(this.f51391c);
        this.f51390b.add(this.j);
        this.f51391c.a(this.f51390b);
    }

    public void c() {
        s sVar = this.f51391c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<n> list) {
        this.f51391c.setData(list);
    }

    public void e(d.a.j0.m.f fVar) {
        for (d.a.c.j.e.a aVar : this.f51390b) {
            if (aVar instanceof a) {
                ((a) aVar).g0(fVar);
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.a.c.j.e.a aVar : this.f51390b) {
            aVar.b0(bdUniqueId);
        }
    }
}
