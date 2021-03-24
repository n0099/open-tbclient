package d.b.i0.z0.e.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62949a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.b.j.e.a> f62950b;

    /* renamed from: c  reason: collision with root package name */
    public s f62951c;

    /* renamed from: d  reason: collision with root package name */
    public g f62952d;

    /* renamed from: e  reason: collision with root package name */
    public k f62953e;

    /* renamed from: f  reason: collision with root package name */
    public b f62954f;

    /* renamed from: g  reason: collision with root package name */
    public d f62955g;

    /* renamed from: h  reason: collision with root package name */
    public c f62956h;
    public e i;
    public f j;

    public h(TbPageContext tbPageContext, s sVar) {
        this.f62949a = tbPageContext;
        this.f62951c = sVar;
        b();
    }

    public List<n> a() {
        return this.f62951c.getData();
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f62950b = arrayList;
        arrayList.add(new j(this.f62949a));
        this.f62950b.add(new i(this.f62949a));
        this.f62950b.add(new LoadingViewAdapter(this.f62949a));
        g gVar = new g(this.f62949a);
        this.f62952d = gVar;
        gVar.l0(this.f62951c);
        this.f62950b.add(this.f62952d);
        k kVar = new k(this.f62949a);
        this.f62953e = kVar;
        kVar.l0(this.f62951c);
        this.f62950b.add(this.f62953e);
        b bVar = new b(this.f62949a);
        this.f62954f = bVar;
        bVar.l0(this.f62951c);
        this.f62950b.add(this.f62954f);
        d dVar = new d(this.f62949a);
        this.f62955g = dVar;
        dVar.l0(this.f62951c);
        this.f62950b.add(this.f62955g);
        c cVar = new c(this.f62949a);
        this.f62956h = cVar;
        cVar.l0(this.f62951c);
        this.f62950b.add(this.f62956h);
        e eVar = new e(this.f62949a);
        this.i = eVar;
        eVar.l0(this.f62951c);
        this.f62950b.add(this.i);
        f fVar = new f(this.f62949a);
        this.j = fVar;
        fVar.l0(this.f62951c);
        this.f62950b.add(this.j);
        this.f62951c.a(this.f62950b);
    }

    public void c() {
        s sVar = this.f62951c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<n> list) {
        this.f62951c.setData(list);
    }

    public void e(d.b.h0.m.f fVar) {
        for (d.b.b.j.e.a aVar : this.f62950b) {
            if (aVar instanceof a) {
                ((a) aVar).j0(fVar);
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.b.b.j.e.a aVar : this.f62950b) {
            aVar.f0(bdUniqueId);
        }
    }
}
