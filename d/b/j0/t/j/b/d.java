package d.b.j0.t.j.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62807a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f62808b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f62809c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f62810d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.t.j.e.a f62811e;

    /* renamed from: f  reason: collision with root package name */
    public j f62812f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.b.j0.t.j.e.a aVar) {
        this.f62807a = tbPageContext;
        this.f62808b = bdTypeListView;
        this.f62811e = aVar;
        a();
    }

    public final void a() {
        c cVar = new c(this.f62807a);
        g gVar = new g(this.f62807a);
        h hVar = new h(this.f62807a);
        a aVar = new a(this.f62807a);
        f fVar = new f(this.f62807a);
        i iVar = new i(this.f62807a);
        e eVar = new e(this.f62807a);
        b bVar = new b(this.f62807a);
        this.f62812f = new j(this.f62807a);
        l lVar = new l(this.f62807a, this.f62811e);
        k kVar = new k(this.f62807a);
        this.f62809c.add(cVar);
        this.f62809c.add(this.f62812f);
        this.f62809c.add(gVar);
        this.f62809c.add(hVar);
        this.f62809c.add(aVar);
        this.f62809c.add(fVar);
        this.f62809c.add(iVar);
        this.f62809c.add(eVar);
        this.f62809c.add(bVar);
        this.f62809c.add(lVar);
        this.f62809c.add(kVar);
        this.f62808b.a(this.f62809c);
    }

    public void b(List<n> list) {
        if (this.f62808b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f62810d.clear();
        this.f62810d.addAll(list);
        this.f62808b.setData(this.f62810d);
    }

    public void c(String str) {
        j jVar = this.f62812f;
        if (jVar != null) {
            jVar.t0(str);
        }
    }

    public void d(String str) {
        j jVar = this.f62812f;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public void e(String str) {
        j jVar = this.f62812f;
        if (jVar != null) {
            jVar.u0(str);
        }
    }

    public void f(boolean z) {
        j jVar = this.f62812f;
        if (jVar != null) {
            jVar.v0(z);
        }
    }
}
