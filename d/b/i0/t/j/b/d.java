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
    public TbPageContext f60821a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60822b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f60823c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f60824d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.t.j.e.a f60825e;

    /* renamed from: f  reason: collision with root package name */
    public j f60826f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, d.b.i0.t.j.e.a aVar) {
        this.f60821a = tbPageContext;
        this.f60822b = bdTypeListView;
        this.f60825e = aVar;
        a();
    }

    public final void a() {
        c cVar = new c(this.f60821a);
        g gVar = new g(this.f60821a);
        h hVar = new h(this.f60821a);
        a aVar = new a(this.f60821a);
        f fVar = new f(this.f60821a);
        i iVar = new i(this.f60821a);
        e eVar = new e(this.f60821a);
        b bVar = new b(this.f60821a);
        this.f60826f = new j(this.f60821a);
        l lVar = new l(this.f60821a, this.f60825e);
        k kVar = new k(this.f60821a);
        this.f60823c.add(cVar);
        this.f60823c.add(this.f60826f);
        this.f60823c.add(gVar);
        this.f60823c.add(hVar);
        this.f60823c.add(aVar);
        this.f60823c.add(fVar);
        this.f60823c.add(iVar);
        this.f60823c.add(eVar);
        this.f60823c.add(bVar);
        this.f60823c.add(lVar);
        this.f60823c.add(kVar);
        this.f60822b.a(this.f60823c);
    }

    public void b(List<n> list) {
        if (this.f60822b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f60824d.clear();
        this.f60824d.addAll(list);
        this.f60822b.setData(this.f60824d);
    }

    public void c(String str) {
        j jVar = this.f60826f;
        if (jVar != null) {
            jVar.t0(str);
        }
    }

    public void d(String str) {
        j jVar = this.f60826f;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public void e(String str) {
        j jVar = this.f60826f;
        if (jVar != null) {
            jVar.u0(str);
        }
    }

    public void f(boolean z) {
        j jVar = this.f60826f;
        if (jVar != null) {
            jVar.v0(z);
        }
    }
}
