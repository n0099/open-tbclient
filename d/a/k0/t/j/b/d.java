package d.a.k0.t.j.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61729a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61730b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f61731c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f61732d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.t.j.e.a f61733e;

    /* renamed from: f  reason: collision with root package name */
    public j f61734f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.a.k0.t.j.e.a aVar) {
        this.f61729a = tbPageContext;
        this.f61730b = bdTypeListView;
        this.f61733e = aVar;
        a();
    }

    public final void a() {
        c cVar = new c(this.f61729a);
        g gVar = new g(this.f61729a);
        h hVar = new h(this.f61729a);
        a aVar = new a(this.f61729a);
        f fVar = new f(this.f61729a);
        i iVar = new i(this.f61729a);
        e eVar = new e(this.f61729a);
        b bVar = new b(this.f61729a);
        this.f61734f = new j(this.f61729a);
        l lVar = new l(this.f61729a, this.f61733e);
        k kVar = new k(this.f61729a);
        this.f61731c.add(cVar);
        this.f61731c.add(this.f61734f);
        this.f61731c.add(gVar);
        this.f61731c.add(hVar);
        this.f61731c.add(aVar);
        this.f61731c.add(fVar);
        this.f61731c.add(iVar);
        this.f61731c.add(eVar);
        this.f61731c.add(bVar);
        this.f61731c.add(lVar);
        this.f61731c.add(kVar);
        this.f61730b.a(this.f61731c);
    }

    public void b(List<n> list) {
        if (this.f61730b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f61732d.clear();
        this.f61732d.addAll(list);
        this.f61730b.setData(this.f61732d);
    }

    public void c(String str) {
        j jVar = this.f61734f;
        if (jVar != null) {
            jVar.t0(str);
        }
    }

    public void d(String str) {
        j jVar = this.f61734f;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public void e(String str) {
        j jVar = this.f61734f;
        if (jVar != null) {
            jVar.u0(str);
        }
    }

    public void f(boolean z) {
        j jVar = this.f61734f;
        if (jVar != null) {
            jVar.v0(z);
        }
    }
}
