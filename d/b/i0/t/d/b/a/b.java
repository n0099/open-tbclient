package d.b.i0.t.d.b.a;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import d.b.b.a.f;
import d.b.b.j.e.n;
import d.b.i0.t.d.g.d.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f60244a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60245b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f60246c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f60247d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.t.d.g.a.a f60248e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.t.d.g.a.b f60249f;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f60244a = tbPageContext;
        this.f60245b = bdTypeListView;
        a();
    }

    public final void a() {
        d.b.i0.t.d.g.a.b bVar = new d.b.i0.t.d.g.a.b((TbPageContext) this.f60244a);
        this.f60249f = bVar;
        bVar.l0(1);
        d.b.i0.t.d.g.a.a aVar = new d.b.i0.t.d.g.a.a((TbPageContext) this.f60244a);
        this.f60248e = aVar;
        aVar.l0(1);
        this.f60247d = new a((TbPageContext) this.f60244a, d.b.i0.t.d.b.b.b.j);
        this.f60246c.add(this.f60249f);
        this.f60246c.add(this.f60248e);
        this.f60246c.add(this.f60247d);
        this.f60245b.a(this.f60246c);
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f60245b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f60245b.getAdapter2().notifyDataSetChanged();
    }

    public void c(g gVar) {
        this.f60249f.n0(gVar);
        this.f60248e.n0(gVar);
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f60245b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }

    public void e(int i) {
        this.f60249f.m0(i);
        this.f60248e.m0(i);
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        this.f60247d.n0(iAlaSquareTabController);
    }
}
