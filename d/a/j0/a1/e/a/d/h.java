package d.a.j0.a1.e.a.d;

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
    public TbPageContext f50692a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f50693b;

    /* renamed from: c  reason: collision with root package name */
    public s f50694c;

    /* renamed from: d  reason: collision with root package name */
    public g f50695d;

    /* renamed from: e  reason: collision with root package name */
    public k f50696e;

    /* renamed from: f  reason: collision with root package name */
    public b f50697f;

    /* renamed from: g  reason: collision with root package name */
    public d f50698g;

    /* renamed from: h  reason: collision with root package name */
    public c f50699h;

    /* renamed from: i  reason: collision with root package name */
    public e f50700i;
    public f j;

    public h(TbPageContext tbPageContext, s sVar) {
        this.f50692a = tbPageContext;
        this.f50694c = sVar;
        b();
    }

    public List<n> a() {
        return this.f50694c.getData();
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f50693b = arrayList;
        arrayList.add(new j(this.f50692a));
        this.f50693b.add(new i(this.f50692a));
        this.f50693b.add(new LoadingViewAdapter(this.f50692a));
        g gVar = new g(this.f50692a);
        this.f50695d = gVar;
        gVar.h0(this.f50694c);
        this.f50693b.add(this.f50695d);
        k kVar = new k(this.f50692a);
        this.f50696e = kVar;
        kVar.h0(this.f50694c);
        this.f50693b.add(this.f50696e);
        b bVar = new b(this.f50692a);
        this.f50697f = bVar;
        bVar.h0(this.f50694c);
        this.f50693b.add(this.f50697f);
        d dVar = new d(this.f50692a);
        this.f50698g = dVar;
        dVar.h0(this.f50694c);
        this.f50693b.add(this.f50698g);
        c cVar = new c(this.f50692a);
        this.f50699h = cVar;
        cVar.h0(this.f50694c);
        this.f50693b.add(this.f50699h);
        e eVar = new e(this.f50692a);
        this.f50700i = eVar;
        eVar.h0(this.f50694c);
        this.f50693b.add(this.f50700i);
        f fVar = new f(this.f50692a);
        this.j = fVar;
        fVar.h0(this.f50694c);
        this.f50693b.add(this.j);
        this.f50694c.a(this.f50693b);
    }

    public void c() {
        s sVar = this.f50694c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<n> list) {
        this.f50694c.setData(list);
    }

    public void e(d.a.i0.m.f fVar) {
        for (d.a.c.j.e.a aVar : this.f50693b) {
            if (aVar instanceof a) {
                ((a) aVar).g0(fVar);
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.a.c.j.e.a aVar : this.f50693b) {
            aVar.b0(bdUniqueId);
        }
    }
}
