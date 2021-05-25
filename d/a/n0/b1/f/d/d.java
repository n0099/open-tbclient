package d.a.n0.b1.f.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51594a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51595b;

    /* renamed from: c  reason: collision with root package name */
    public s f51596c;

    /* renamed from: d  reason: collision with root package name */
    public c f51597d;

    /* renamed from: e  reason: collision with root package name */
    public h f51598e;

    /* renamed from: f  reason: collision with root package name */
    public b f51599f;

    /* renamed from: g  reason: collision with root package name */
    public f f51600g;

    /* renamed from: h  reason: collision with root package name */
    public e f51601h;

    /* renamed from: i  reason: collision with root package name */
    public g f51602i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
        this.f51594a = tbPageContext;
        this.f51596c = sVar;
        a();
    }

    public final void a() {
        this.f51595b = new ArrayList();
        c cVar = new c(this.f51594a);
        this.f51597d = cVar;
        cVar.h0(this.f51596c);
        this.f51595b.add(this.f51597d);
        h hVar = new h(this.f51594a);
        this.f51598e = hVar;
        hVar.h0(this.f51596c);
        this.f51595b.add(this.f51598e);
        b bVar = new b(this.f51594a);
        this.f51599f = bVar;
        bVar.h0(this.f51596c);
        this.f51595b.add(this.f51599f);
        f fVar = new f(this.f51594a);
        this.f51600g = fVar;
        fVar.h0(this.f51596c);
        this.f51595b.add(this.f51600g);
        e eVar = new e(this.f51594a);
        this.f51601h = eVar;
        eVar.h0(this.f51596c);
        this.f51595b.add(this.f51601h);
        g gVar = new g(this.f51594a);
        this.f51602i = gVar;
        gVar.h0(this.f51596c);
        this.f51595b.add(this.f51602i);
        i iVar = new i(this.f51594a);
        this.j = iVar;
        iVar.h0(this.f51596c);
        this.f51595b.add(this.j);
        this.f51596c.a(this.f51595b);
    }

    public void b() {
        s sVar = this.f51596c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        s sVar = this.f51596c;
        if (sVar != null) {
            sVar.setData(list);
            b();
        }
    }

    public void d(d.a.m0.m.f fVar) {
        for (d.a.c.j.e.a aVar : this.f51595b) {
            if (aVar instanceof a) {
                ((a) aVar).g0(fVar);
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        for (d.a.c.j.e.a aVar : this.f51595b) {
            aVar.b0(bdUniqueId);
        }
    }
}
