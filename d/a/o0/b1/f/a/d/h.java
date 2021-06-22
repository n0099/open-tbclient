package d.a.o0.b1.f.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55362a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55363b;

    /* renamed from: c  reason: collision with root package name */
    public s f55364c;

    /* renamed from: d  reason: collision with root package name */
    public g f55365d;

    /* renamed from: e  reason: collision with root package name */
    public k f55366e;

    /* renamed from: f  reason: collision with root package name */
    public b f55367f;

    /* renamed from: g  reason: collision with root package name */
    public d f55368g;

    /* renamed from: h  reason: collision with root package name */
    public c f55369h;

    /* renamed from: i  reason: collision with root package name */
    public e f55370i;
    public f j;

    public h(TbPageContext tbPageContext, s sVar) {
        this.f55362a = tbPageContext;
        this.f55364c = sVar;
        b();
    }

    public List<n> a() {
        return this.f55364c.getData();
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f55363b = arrayList;
        arrayList.add(new j(this.f55362a));
        this.f55363b.add(new i(this.f55362a));
        this.f55363b.add(new LoadingViewAdapter(this.f55362a));
        g gVar = new g(this.f55362a);
        this.f55365d = gVar;
        gVar.i0(this.f55364c);
        this.f55363b.add(this.f55365d);
        k kVar = new k(this.f55362a);
        this.f55366e = kVar;
        kVar.i0(this.f55364c);
        this.f55363b.add(this.f55366e);
        b bVar = new b(this.f55362a);
        this.f55367f = bVar;
        bVar.i0(this.f55364c);
        this.f55363b.add(this.f55367f);
        d dVar = new d(this.f55362a);
        this.f55368g = dVar;
        dVar.i0(this.f55364c);
        this.f55363b.add(this.f55368g);
        c cVar = new c(this.f55362a);
        this.f55369h = cVar;
        cVar.i0(this.f55364c);
        this.f55363b.add(this.f55369h);
        e eVar = new e(this.f55362a);
        this.f55370i = eVar;
        eVar.i0(this.f55364c);
        this.f55363b.add(this.f55370i);
        f fVar = new f(this.f55362a);
        this.j = fVar;
        fVar.i0(this.f55364c);
        this.f55363b.add(this.j);
        this.f55364c.a(this.f55363b);
    }

    public void c() {
        s sVar = this.f55364c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<n> list) {
        this.f55364c.setData(list);
    }

    public void e(d.a.n0.m.f fVar) {
        for (d.a.c.k.e.a aVar : this.f55363b) {
            if (aVar instanceof a) {
                ((a) aVar).h0(fVar);
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.a.c.k.e.a aVar : this.f55363b) {
            aVar.c0(bdUniqueId);
        }
    }
}
