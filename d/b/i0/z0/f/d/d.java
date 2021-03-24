package d.b.i0.z0.f.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62987a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.b.j.e.a> f62988b;

    /* renamed from: c  reason: collision with root package name */
    public s f62989c;

    /* renamed from: d  reason: collision with root package name */
    public c f62990d;

    /* renamed from: e  reason: collision with root package name */
    public h f62991e;

    /* renamed from: f  reason: collision with root package name */
    public b f62992f;

    /* renamed from: g  reason: collision with root package name */
    public f f62993g;

    /* renamed from: h  reason: collision with root package name */
    public e f62994h;
    public g i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
        this.f62987a = tbPageContext;
        this.f62989c = sVar;
        a();
    }

    public final void a() {
        this.f62988b = new ArrayList();
        c cVar = new c(this.f62987a);
        this.f62990d = cVar;
        cVar.l0(this.f62989c);
        this.f62988b.add(this.f62990d);
        h hVar = new h(this.f62987a);
        this.f62991e = hVar;
        hVar.l0(this.f62989c);
        this.f62988b.add(this.f62991e);
        b bVar = new b(this.f62987a);
        this.f62992f = bVar;
        bVar.l0(this.f62989c);
        this.f62988b.add(this.f62992f);
        f fVar = new f(this.f62987a);
        this.f62993g = fVar;
        fVar.l0(this.f62989c);
        this.f62988b.add(this.f62993g);
        e eVar = new e(this.f62987a);
        this.f62994h = eVar;
        eVar.l0(this.f62989c);
        this.f62988b.add(this.f62994h);
        g gVar = new g(this.f62987a);
        this.i = gVar;
        gVar.l0(this.f62989c);
        this.f62988b.add(this.i);
        i iVar = new i(this.f62987a);
        this.j = iVar;
        iVar.l0(this.f62989c);
        this.f62988b.add(this.j);
        this.f62989c.a(this.f62988b);
    }

    public void b() {
        s sVar = this.f62989c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        s sVar = this.f62989c;
        if (sVar != null) {
            sVar.setData(list);
            b();
        }
    }

    public void d(d.b.h0.m.f fVar) {
        for (d.b.b.j.e.a aVar : this.f62988b) {
            if (aVar instanceof a) {
                ((a) aVar).j0(fVar);
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        for (d.b.b.j.e.a aVar : this.f62988b) {
            aVar.f0(bdUniqueId);
        }
    }
}
