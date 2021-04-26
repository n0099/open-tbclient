package d.a.j0.t.j.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61005a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61006b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f61007c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f61008d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.t.j.e.a f61009e;

    /* renamed from: f  reason: collision with root package name */
    public j f61010f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.a.j0.t.j.e.a aVar) {
        this.f61005a = tbPageContext;
        this.f61006b = bdTypeListView;
        this.f61009e = aVar;
        a();
    }

    public final void a() {
        c cVar = new c(this.f61005a);
        g gVar = new g(this.f61005a);
        h hVar = new h(this.f61005a);
        a aVar = new a(this.f61005a);
        f fVar = new f(this.f61005a);
        i iVar = new i(this.f61005a);
        e eVar = new e(this.f61005a);
        b bVar = new b(this.f61005a);
        this.f61010f = new j(this.f61005a);
        l lVar = new l(this.f61005a, this.f61009e);
        k kVar = new k(this.f61005a);
        this.f61007c.add(cVar);
        this.f61007c.add(this.f61010f);
        this.f61007c.add(gVar);
        this.f61007c.add(hVar);
        this.f61007c.add(aVar);
        this.f61007c.add(fVar);
        this.f61007c.add(iVar);
        this.f61007c.add(eVar);
        this.f61007c.add(bVar);
        this.f61007c.add(lVar);
        this.f61007c.add(kVar);
        this.f61006b.a(this.f61007c);
    }

    public void b(List<n> list) {
        if (this.f61006b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f61008d.clear();
        this.f61008d.addAll(list);
        this.f61006b.setData(this.f61008d);
    }

    public void c(String str) {
        j jVar = this.f61010f;
        if (jVar != null) {
            jVar.t0(str);
        }
    }

    public void d(String str) {
        j jVar = this.f61010f;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public void e(String str) {
        j jVar = this.f61010f;
        if (jVar != null) {
            jVar.u0(str);
        }
    }

    public void f(boolean z) {
        j jVar = this.f61010f;
        if (jVar != null) {
            jVar.v0(z);
        }
    }
}
