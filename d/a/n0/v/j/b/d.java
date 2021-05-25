package d.a.n0.v.j.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62017a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f62018b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f62019c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f62020d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.v.j.e.a f62021e;

    /* renamed from: f  reason: collision with root package name */
    public j f62022f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.a.n0.v.j.e.a aVar) {
        this.f62017a = tbPageContext;
        this.f62018b = bdTypeListView;
        this.f62021e = aVar;
        a();
    }

    public final void a() {
        c cVar = new c(this.f62017a);
        g gVar = new g(this.f62017a);
        h hVar = new h(this.f62017a);
        a aVar = new a(this.f62017a);
        f fVar = new f(this.f62017a);
        i iVar = new i(this.f62017a);
        e eVar = new e(this.f62017a);
        b bVar = new b(this.f62017a);
        this.f62022f = new j(this.f62017a);
        l lVar = new l(this.f62017a, this.f62021e);
        k kVar = new k(this.f62017a);
        this.f62019c.add(cVar);
        this.f62019c.add(this.f62022f);
        this.f62019c.add(gVar);
        this.f62019c.add(hVar);
        this.f62019c.add(aVar);
        this.f62019c.add(fVar);
        this.f62019c.add(iVar);
        this.f62019c.add(eVar);
        this.f62019c.add(bVar);
        this.f62019c.add(lVar);
        this.f62019c.add(kVar);
        this.f62018b.a(this.f62019c);
    }

    public void b(List<n> list) {
        if (this.f62018b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f62020d.clear();
        this.f62020d.addAll(list);
        this.f62018b.setData(this.f62020d);
    }

    public void c(String str) {
        j jVar = this.f62022f;
        if (jVar != null) {
            jVar.t0(str);
        }
    }

    public void d(String str) {
        j jVar = this.f62022f;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public void e(String str) {
        j jVar = this.f62022f;
        if (jVar != null) {
            jVar.u0(str);
        }
    }

    public void f(boolean z) {
        j jVar = this.f62022f;
        if (jVar != null) {
            jVar.v0(z);
        }
    }
}
