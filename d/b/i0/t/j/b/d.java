package d.b.i0.t.j.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60822a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60823b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f60824c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f60825d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.t.j.e.a f60826e;

    /* renamed from: f  reason: collision with root package name */
    public j f60827f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.b.i0.t.j.e.a aVar) {
        this.f60822a = tbPageContext;
        this.f60823b = bdTypeListView;
        this.f60826e = aVar;
        a();
    }

    public final void a() {
        c cVar = new c(this.f60822a);
        g gVar = new g(this.f60822a);
        h hVar = new h(this.f60822a);
        a aVar = new a(this.f60822a);
        f fVar = new f(this.f60822a);
        i iVar = new i(this.f60822a);
        e eVar = new e(this.f60822a);
        b bVar = new b(this.f60822a);
        this.f60827f = new j(this.f60822a);
        l lVar = new l(this.f60822a, this.f60826e);
        k kVar = new k(this.f60822a);
        this.f60824c.add(cVar);
        this.f60824c.add(this.f60827f);
        this.f60824c.add(gVar);
        this.f60824c.add(hVar);
        this.f60824c.add(aVar);
        this.f60824c.add(fVar);
        this.f60824c.add(iVar);
        this.f60824c.add(eVar);
        this.f60824c.add(bVar);
        this.f60824c.add(lVar);
        this.f60824c.add(kVar);
        this.f60823b.a(this.f60824c);
    }

    public void b(List<n> list) {
        if (this.f60823b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f60825d.clear();
        this.f60825d.addAll(list);
        this.f60823b.setData(this.f60825d);
    }

    public void c(String str) {
        j jVar = this.f60827f;
        if (jVar != null) {
            jVar.t0(str);
        }
    }

    public void d(String str) {
        j jVar = this.f60827f;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public void e(String str) {
        j jVar = this.f60827f;
        if (jVar != null) {
            jVar.u0(str);
        }
    }

    public void f(boolean z) {
        j jVar = this.f60827f;
        if (jVar != null) {
            jVar.v0(z);
        }
    }
}
