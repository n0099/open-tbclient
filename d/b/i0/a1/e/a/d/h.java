package d.b.i0.a1.e.a.d;

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
    public TbPageContext f52569a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.c.j.e.a> f52570b;

    /* renamed from: c  reason: collision with root package name */
    public s f52571c;

    /* renamed from: d  reason: collision with root package name */
    public g f52572d;

    /* renamed from: e  reason: collision with root package name */
    public k f52573e;

    /* renamed from: f  reason: collision with root package name */
    public b f52574f;

    /* renamed from: g  reason: collision with root package name */
    public d f52575g;

    /* renamed from: h  reason: collision with root package name */
    public c f52576h;
    public e i;
    public f j;

    public h(TbPageContext tbPageContext, s sVar) {
        this.f52569a = tbPageContext;
        this.f52571c = sVar;
        b();
    }

    public List<n> a() {
        return this.f52571c.getData();
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f52570b = arrayList;
        arrayList.add(new j(this.f52569a));
        this.f52570b.add(new i(this.f52569a));
        this.f52570b.add(new LoadingViewAdapter(this.f52569a));
        g gVar = new g(this.f52569a);
        this.f52572d = gVar;
        gVar.l0(this.f52571c);
        this.f52570b.add(this.f52572d);
        k kVar = new k(this.f52569a);
        this.f52573e = kVar;
        kVar.l0(this.f52571c);
        this.f52570b.add(this.f52573e);
        b bVar = new b(this.f52569a);
        this.f52574f = bVar;
        bVar.l0(this.f52571c);
        this.f52570b.add(this.f52574f);
        d dVar = new d(this.f52569a);
        this.f52575g = dVar;
        dVar.l0(this.f52571c);
        this.f52570b.add(this.f52575g);
        c cVar = new c(this.f52569a);
        this.f52576h = cVar;
        cVar.l0(this.f52571c);
        this.f52570b.add(this.f52576h);
        e eVar = new e(this.f52569a);
        this.i = eVar;
        eVar.l0(this.f52571c);
        this.f52570b.add(this.i);
        f fVar = new f(this.f52569a);
        this.j = fVar;
        fVar.l0(this.f52571c);
        this.f52570b.add(this.j);
        this.f52571c.a(this.f52570b);
    }

    public void c() {
        s sVar = this.f52571c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<n> list) {
        this.f52571c.setData(list);
    }

    public void e(d.b.h0.m.f fVar) {
        for (d.b.c.j.e.a aVar : this.f52570b) {
            if (aVar instanceof a) {
                ((a) aVar).j0(fVar);
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.b.c.j.e.a aVar : this.f52570b) {
            aVar.f0(bdUniqueId);
        }
    }
}
