package d.a.n0.b1.f.a.d;

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
    public TbPageContext f55237a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55238b;

    /* renamed from: c  reason: collision with root package name */
    public s f55239c;

    /* renamed from: d  reason: collision with root package name */
    public g f55240d;

    /* renamed from: e  reason: collision with root package name */
    public k f55241e;

    /* renamed from: f  reason: collision with root package name */
    public b f55242f;

    /* renamed from: g  reason: collision with root package name */
    public d f55243g;

    /* renamed from: h  reason: collision with root package name */
    public c f55244h;

    /* renamed from: i  reason: collision with root package name */
    public e f55245i;
    public f j;

    public h(TbPageContext tbPageContext, s sVar) {
        this.f55237a = tbPageContext;
        this.f55239c = sVar;
        b();
    }

    public List<n> a() {
        return this.f55239c.getData();
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f55238b = arrayList;
        arrayList.add(new j(this.f55237a));
        this.f55238b.add(new i(this.f55237a));
        this.f55238b.add(new LoadingViewAdapter(this.f55237a));
        g gVar = new g(this.f55237a);
        this.f55240d = gVar;
        gVar.i0(this.f55239c);
        this.f55238b.add(this.f55240d);
        k kVar = new k(this.f55237a);
        this.f55241e = kVar;
        kVar.i0(this.f55239c);
        this.f55238b.add(this.f55241e);
        b bVar = new b(this.f55237a);
        this.f55242f = bVar;
        bVar.i0(this.f55239c);
        this.f55238b.add(this.f55242f);
        d dVar = new d(this.f55237a);
        this.f55243g = dVar;
        dVar.i0(this.f55239c);
        this.f55238b.add(this.f55243g);
        c cVar = new c(this.f55237a);
        this.f55244h = cVar;
        cVar.i0(this.f55239c);
        this.f55238b.add(this.f55244h);
        e eVar = new e(this.f55237a);
        this.f55245i = eVar;
        eVar.i0(this.f55239c);
        this.f55238b.add(this.f55245i);
        f fVar = new f(this.f55237a);
        this.j = fVar;
        fVar.i0(this.f55239c);
        this.f55238b.add(this.j);
        this.f55239c.a(this.f55238b);
    }

    public void c() {
        s sVar = this.f55239c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<n> list) {
        this.f55239c.setData(list);
    }

    public void e(d.a.m0.m.f fVar) {
        for (d.a.c.k.e.a aVar : this.f55238b) {
            if (aVar instanceof a) {
                ((a) aVar).h0(fVar);
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.a.c.k.e.a aVar : this.f55238b) {
            aVar.c0(bdUniqueId);
        }
    }
}
