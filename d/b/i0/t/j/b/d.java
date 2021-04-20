package d.b.i0.t.j.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62386a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f62387b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f62388c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f62389d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.t.j.e.a f62390e;

    /* renamed from: f  reason: collision with root package name */
    public j f62391f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.b.i0.t.j.e.a aVar) {
        this.f62386a = tbPageContext;
        this.f62387b = bdTypeListView;
        this.f62390e = aVar;
        a();
    }

    public final void a() {
        c cVar = new c(this.f62386a);
        g gVar = new g(this.f62386a);
        h hVar = new h(this.f62386a);
        a aVar = new a(this.f62386a);
        f fVar = new f(this.f62386a);
        i iVar = new i(this.f62386a);
        e eVar = new e(this.f62386a);
        b bVar = new b(this.f62386a);
        this.f62391f = new j(this.f62386a);
        l lVar = new l(this.f62386a, this.f62390e);
        k kVar = new k(this.f62386a);
        this.f62388c.add(cVar);
        this.f62388c.add(this.f62391f);
        this.f62388c.add(gVar);
        this.f62388c.add(hVar);
        this.f62388c.add(aVar);
        this.f62388c.add(fVar);
        this.f62388c.add(iVar);
        this.f62388c.add(eVar);
        this.f62388c.add(bVar);
        this.f62388c.add(lVar);
        this.f62388c.add(kVar);
        this.f62387b.a(this.f62388c);
    }

    public void b(List<n> list) {
        if (this.f62387b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f62389d.clear();
        this.f62389d.addAll(list);
        this.f62387b.setData(this.f62389d);
    }

    public void c(String str) {
        j jVar = this.f62391f;
        if (jVar != null) {
            jVar.t0(str);
        }
    }

    public void d(String str) {
        j jVar = this.f62391f;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public void e(String str) {
        j jVar = this.f62391f;
        if (jVar != null) {
            jVar.u0(str);
        }
    }

    public void f(boolean z) {
        j jVar = this.f62391f;
        if (jVar != null) {
            jVar.v0(z);
        }
    }
}
