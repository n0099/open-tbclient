package d.a.o0.v.j.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65857a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f65858b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f65859c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f65860d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.v.j.e.a f65861e;

    /* renamed from: f  reason: collision with root package name */
    public j f65862f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.a.o0.v.j.e.a aVar) {
        this.f65857a = tbPageContext;
        this.f65858b = bdTypeListView;
        this.f65861e = aVar;
        a();
    }

    public final void a() {
        c cVar = new c(this.f65857a);
        g gVar = new g(this.f65857a);
        h hVar = new h(this.f65857a);
        a aVar = new a(this.f65857a);
        f fVar = new f(this.f65857a);
        i iVar = new i(this.f65857a);
        e eVar = new e(this.f65857a);
        b bVar = new b(this.f65857a);
        this.f65862f = new j(this.f65857a);
        l lVar = new l(this.f65857a, this.f65861e);
        k kVar = new k(this.f65857a);
        this.f65859c.add(cVar);
        this.f65859c.add(this.f65862f);
        this.f65859c.add(gVar);
        this.f65859c.add(hVar);
        this.f65859c.add(aVar);
        this.f65859c.add(fVar);
        this.f65859c.add(iVar);
        this.f65859c.add(eVar);
        this.f65859c.add(bVar);
        this.f65859c.add(lVar);
        this.f65859c.add(kVar);
        this.f65858b.a(this.f65859c);
    }

    public void b(List<n> list) {
        if (this.f65858b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f65860d.clear();
        this.f65860d.addAll(list);
        this.f65858b.setData(this.f65860d);
    }

    public void c(String str) {
        j jVar = this.f65862f;
        if (jVar != null) {
            jVar.t0(str);
        }
    }

    public void d(String str) {
        j jVar = this.f65862f;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public void e(String str) {
        j jVar = this.f65862f;
        if (jVar != null) {
            jVar.v0(str);
        }
    }

    public void f(boolean z) {
        j jVar = this.f65862f;
        if (jVar != null) {
            jVar.w0(z);
        }
    }
}
