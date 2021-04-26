package d.a.j0.a1.f.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f50732a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f50733b;

    /* renamed from: c  reason: collision with root package name */
    public s f50734c;

    /* renamed from: d  reason: collision with root package name */
    public c f50735d;

    /* renamed from: e  reason: collision with root package name */
    public h f50736e;

    /* renamed from: f  reason: collision with root package name */
    public b f50737f;

    /* renamed from: g  reason: collision with root package name */
    public f f50738g;

    /* renamed from: h  reason: collision with root package name */
    public e f50739h;

    /* renamed from: i  reason: collision with root package name */
    public g f50740i;
    public i j;

    public d(TbPageContext tbPageContext, s sVar) {
        this.f50732a = tbPageContext;
        this.f50734c = sVar;
        a();
    }

    public final void a() {
        this.f50733b = new ArrayList();
        c cVar = new c(this.f50732a);
        this.f50735d = cVar;
        cVar.h0(this.f50734c);
        this.f50733b.add(this.f50735d);
        h hVar = new h(this.f50732a);
        this.f50736e = hVar;
        hVar.h0(this.f50734c);
        this.f50733b.add(this.f50736e);
        b bVar = new b(this.f50732a);
        this.f50737f = bVar;
        bVar.h0(this.f50734c);
        this.f50733b.add(this.f50737f);
        f fVar = new f(this.f50732a);
        this.f50738g = fVar;
        fVar.h0(this.f50734c);
        this.f50733b.add(this.f50738g);
        e eVar = new e(this.f50732a);
        this.f50739h = eVar;
        eVar.h0(this.f50734c);
        this.f50733b.add(this.f50739h);
        g gVar = new g(this.f50732a);
        this.f50740i = gVar;
        gVar.h0(this.f50734c);
        this.f50733b.add(this.f50740i);
        i iVar = new i(this.f50732a);
        this.j = iVar;
        iVar.h0(this.f50734c);
        this.f50733b.add(this.j);
        this.f50734c.a(this.f50733b);
    }

    public void b() {
        s sVar = this.f50734c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        s sVar = this.f50734c;
        if (sVar != null) {
            sVar.setData(list);
            b();
        }
    }

    public void d(d.a.i0.m.f fVar) {
        for (d.a.c.j.e.a aVar : this.f50733b) {
            if (aVar instanceof a) {
                ((a) aVar).g0(fVar);
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        for (d.a.c.j.e.a aVar : this.f50733b) {
            aVar.b0(bdUniqueId);
        }
    }
}
