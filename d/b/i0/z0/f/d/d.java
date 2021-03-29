package d.b.i0.z0.f.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62988a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.b.j.e.a> f62989b;

    /* renamed from: c  reason: collision with root package name */
    public s f62990c;

    /* renamed from: d  reason: collision with root package name */
    public c f62991d;

    /* renamed from: e  reason: collision with root package name */
    public h f62992e;

    /* renamed from: f  reason: collision with root package name */
    public b f62993f;

    /* renamed from: g  reason: collision with root package name */
    public f f62994g;

    /* renamed from: h  reason: collision with root package name */
    public e f62995h;
    public g i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
        this.f62988a = tbPageContext;
        this.f62990c = sVar;
        a();
    }

    public final void a() {
        this.f62989b = new ArrayList();
        c cVar = new c(this.f62988a);
        this.f62991d = cVar;
        cVar.l0(this.f62990c);
        this.f62989b.add(this.f62991d);
        h hVar = new h(this.f62988a);
        this.f62992e = hVar;
        hVar.l0(this.f62990c);
        this.f62989b.add(this.f62992e);
        b bVar = new b(this.f62988a);
        this.f62993f = bVar;
        bVar.l0(this.f62990c);
        this.f62989b.add(this.f62993f);
        f fVar = new f(this.f62988a);
        this.f62994g = fVar;
        fVar.l0(this.f62990c);
        this.f62989b.add(this.f62994g);
        e eVar = new e(this.f62988a);
        this.f62995h = eVar;
        eVar.l0(this.f62990c);
        this.f62989b.add(this.f62995h);
        g gVar = new g(this.f62988a);
        this.i = gVar;
        gVar.l0(this.f62990c);
        this.f62989b.add(this.i);
        i iVar = new i(this.f62988a);
        this.j = iVar;
        iVar.l0(this.f62990c);
        this.f62989b.add(this.j);
        this.f62990c.a(this.f62989b);
    }

    public void b() {
        s sVar = this.f62990c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        s sVar = this.f62990c;
        if (sVar != null) {
            sVar.setData(list);
            b();
        }
    }

    public void d(d.b.h0.m.f fVar) {
        for (d.b.b.j.e.a aVar : this.f62989b) {
            if (aVar instanceof a) {
                ((a) aVar).j0(fVar);
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        for (d.b.b.j.e.a aVar : this.f62989b) {
            aVar.f0(bdUniqueId);
        }
    }
}
