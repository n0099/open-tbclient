package d.a.n0.v.j.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65732a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f65733b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f65734c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f65735d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.v.j.e.a f65736e;

    /* renamed from: f  reason: collision with root package name */
    public j f65737f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.a.n0.v.j.e.a aVar) {
        this.f65732a = tbPageContext;
        this.f65733b = bdTypeListView;
        this.f65736e = aVar;
        a();
    }

    public final void a() {
        c cVar = new c(this.f65732a);
        g gVar = new g(this.f65732a);
        h hVar = new h(this.f65732a);
        a aVar = new a(this.f65732a);
        f fVar = new f(this.f65732a);
        i iVar = new i(this.f65732a);
        e eVar = new e(this.f65732a);
        b bVar = new b(this.f65732a);
        this.f65737f = new j(this.f65732a);
        l lVar = new l(this.f65732a, this.f65736e);
        k kVar = new k(this.f65732a);
        this.f65734c.add(cVar);
        this.f65734c.add(this.f65737f);
        this.f65734c.add(gVar);
        this.f65734c.add(hVar);
        this.f65734c.add(aVar);
        this.f65734c.add(fVar);
        this.f65734c.add(iVar);
        this.f65734c.add(eVar);
        this.f65734c.add(bVar);
        this.f65734c.add(lVar);
        this.f65734c.add(kVar);
        this.f65733b.a(this.f65734c);
    }

    public void b(List<n> list) {
        if (this.f65733b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f65735d.clear();
        this.f65735d.addAll(list);
        this.f65733b.setData(this.f65735d);
    }

    public void c(String str) {
        j jVar = this.f65737f;
        if (jVar != null) {
            jVar.t0(str);
        }
    }

    public void d(String str) {
        j jVar = this.f65737f;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public void e(String str) {
        j jVar = this.f65737f;
        if (jVar != null) {
            jVar.v0(str);
        }
    }

    public void f(boolean z) {
        j jVar = this.f65737f;
        if (jVar != null) {
            jVar.w0(z);
        }
    }
}
