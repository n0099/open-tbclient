package d.b.j0.a1.e.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52990a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.c.j.e.a> f52991b;

    /* renamed from: c  reason: collision with root package name */
    public s f52992c;

    /* renamed from: d  reason: collision with root package name */
    public g f52993d;

    /* renamed from: e  reason: collision with root package name */
    public k f52994e;

    /* renamed from: f  reason: collision with root package name */
    public b f52995f;

    /* renamed from: g  reason: collision with root package name */
    public d f52996g;

    /* renamed from: h  reason: collision with root package name */
    public c f52997h;
    public e i;
    public f j;

    public h(TbPageContext tbPageContext, s sVar) {
        this.f52990a = tbPageContext;
        this.f52992c = sVar;
        b();
    }

    public List<n> a() {
        return this.f52992c.getData();
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f52991b = arrayList;
        arrayList.add(new j(this.f52990a));
        this.f52991b.add(new i(this.f52990a));
        this.f52991b.add(new LoadingViewAdapter(this.f52990a));
        g gVar = new g(this.f52990a);
        this.f52993d = gVar;
        gVar.l0(this.f52992c);
        this.f52991b.add(this.f52993d);
        k kVar = new k(this.f52990a);
        this.f52994e = kVar;
        kVar.l0(this.f52992c);
        this.f52991b.add(this.f52994e);
        b bVar = new b(this.f52990a);
        this.f52995f = bVar;
        bVar.l0(this.f52992c);
        this.f52991b.add(this.f52995f);
        d dVar = new d(this.f52990a);
        this.f52996g = dVar;
        dVar.l0(this.f52992c);
        this.f52991b.add(this.f52996g);
        c cVar = new c(this.f52990a);
        this.f52997h = cVar;
        cVar.l0(this.f52992c);
        this.f52991b.add(this.f52997h);
        e eVar = new e(this.f52990a);
        this.i = eVar;
        eVar.l0(this.f52992c);
        this.f52991b.add(this.i);
        f fVar = new f(this.f52990a);
        this.j = fVar;
        fVar.l0(this.f52992c);
        this.f52991b.add(this.j);
        this.f52992c.a(this.f52991b);
    }

    public void c() {
        s sVar = this.f52992c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<n> list) {
        this.f52992c.setData(list);
    }

    public void e(d.b.i0.m.f fVar) {
        for (d.b.c.j.e.a aVar : this.f52991b) {
            if (aVar instanceof a) {
                ((a) aVar).j0(fVar);
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.b.c.j.e.a aVar : this.f52991b) {
            aVar.f0(bdUniqueId);
        }
    }
}
