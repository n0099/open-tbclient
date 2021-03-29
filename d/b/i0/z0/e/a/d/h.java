package d.b.i0.z0.e.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62950a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.b.j.e.a> f62951b;

    /* renamed from: c  reason: collision with root package name */
    public s f62952c;

    /* renamed from: d  reason: collision with root package name */
    public g f62953d;

    /* renamed from: e  reason: collision with root package name */
    public k f62954e;

    /* renamed from: f  reason: collision with root package name */
    public b f62955f;

    /* renamed from: g  reason: collision with root package name */
    public d f62956g;

    /* renamed from: h  reason: collision with root package name */
    public c f62957h;
    public e i;
    public f j;

    public h(TbPageContext tbPageContext, s sVar) {
        this.f62950a = tbPageContext;
        this.f62952c = sVar;
        b();
    }

    public List<n> a() {
        return this.f62952c.getData();
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f62951b = arrayList;
        arrayList.add(new j(this.f62950a));
        this.f62951b.add(new i(this.f62950a));
        this.f62951b.add(new LoadingViewAdapter(this.f62950a));
        g gVar = new g(this.f62950a);
        this.f62953d = gVar;
        gVar.l0(this.f62952c);
        this.f62951b.add(this.f62953d);
        k kVar = new k(this.f62950a);
        this.f62954e = kVar;
        kVar.l0(this.f62952c);
        this.f62951b.add(this.f62954e);
        b bVar = new b(this.f62950a);
        this.f62955f = bVar;
        bVar.l0(this.f62952c);
        this.f62951b.add(this.f62955f);
        d dVar = new d(this.f62950a);
        this.f62956g = dVar;
        dVar.l0(this.f62952c);
        this.f62951b.add(this.f62956g);
        c cVar = new c(this.f62950a);
        this.f62957h = cVar;
        cVar.l0(this.f62952c);
        this.f62951b.add(this.f62957h);
        e eVar = new e(this.f62950a);
        this.i = eVar;
        eVar.l0(this.f62952c);
        this.f62951b.add(this.i);
        f fVar = new f(this.f62950a);
        this.j = fVar;
        fVar.l0(this.f62952c);
        this.f62951b.add(this.j);
        this.f62952c.a(this.f62951b);
    }

    public void c() {
        s sVar = this.f62952c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<n> list) {
        this.f62952c.setData(list);
    }

    public void e(d.b.h0.m.f fVar) {
        for (d.b.b.j.e.a aVar : this.f62951b) {
            if (aVar instanceof a) {
                ((a) aVar).j0(fVar);
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.b.b.j.e.a aVar : this.f62951b) {
            aVar.f0(bdUniqueId);
        }
    }
}
