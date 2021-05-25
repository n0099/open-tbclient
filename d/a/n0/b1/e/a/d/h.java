package d.a.n0.b1.e.a.d;

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
    public TbPageContext f51554a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51555b;

    /* renamed from: c  reason: collision with root package name */
    public s f51556c;

    /* renamed from: d  reason: collision with root package name */
    public g f51557d;

    /* renamed from: e  reason: collision with root package name */
    public k f51558e;

    /* renamed from: f  reason: collision with root package name */
    public b f51559f;

    /* renamed from: g  reason: collision with root package name */
    public d f51560g;

    /* renamed from: h  reason: collision with root package name */
    public c f51561h;

    /* renamed from: i  reason: collision with root package name */
    public e f51562i;
    public f j;

    public h(TbPageContext tbPageContext, s sVar) {
        this.f51554a = tbPageContext;
        this.f51556c = sVar;
        b();
    }

    public List<n> a() {
        return this.f51556c.getData();
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f51555b = arrayList;
        arrayList.add(new j(this.f51554a));
        this.f51555b.add(new i(this.f51554a));
        this.f51555b.add(new LoadingViewAdapter(this.f51554a));
        g gVar = new g(this.f51554a);
        this.f51557d = gVar;
        gVar.h0(this.f51556c);
        this.f51555b.add(this.f51557d);
        k kVar = new k(this.f51554a);
        this.f51558e = kVar;
        kVar.h0(this.f51556c);
        this.f51555b.add(this.f51558e);
        b bVar = new b(this.f51554a);
        this.f51559f = bVar;
        bVar.h0(this.f51556c);
        this.f51555b.add(this.f51559f);
        d dVar = new d(this.f51554a);
        this.f51560g = dVar;
        dVar.h0(this.f51556c);
        this.f51555b.add(this.f51560g);
        c cVar = new c(this.f51554a);
        this.f51561h = cVar;
        cVar.h0(this.f51556c);
        this.f51555b.add(this.f51561h);
        e eVar = new e(this.f51554a);
        this.f51562i = eVar;
        eVar.h0(this.f51556c);
        this.f51555b.add(this.f51562i);
        f fVar = new f(this.f51554a);
        this.j = fVar;
        fVar.h0(this.f51556c);
        this.f51555b.add(this.j);
        this.f51556c.a(this.f51555b);
    }

    public void c() {
        s sVar = this.f51556c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<n> list) {
        this.f51556c.setData(list);
    }

    public void e(d.a.m0.m.f fVar) {
        for (d.a.c.j.e.a aVar : this.f51555b) {
            if (aVar instanceof a) {
                ((a) aVar).g0(fVar);
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.a.c.j.e.a aVar : this.f51555b) {
            aVar.b0(bdUniqueId);
        }
    }
}
