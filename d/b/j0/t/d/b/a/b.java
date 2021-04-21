package d.b.j0.t.d.b.a;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import d.b.c.a.f;
import d.b.c.j.e.n;
import d.b.j0.t.d.g.d.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f62230a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f62231b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f62232c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f62233d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.t.d.g.a.a f62234e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.t.d.g.a.b f62235f;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f62230a = tbPageContext;
        this.f62231b = bdTypeListView;
        a();
    }

    public final void a() {
        d.b.j0.t.d.g.a.b bVar = new d.b.j0.t.d.g.a.b((TbPageContext) this.f62230a);
        this.f62235f = bVar;
        bVar.l0(1);
        d.b.j0.t.d.g.a.a aVar = new d.b.j0.t.d.g.a.a((TbPageContext) this.f62230a);
        this.f62234e = aVar;
        aVar.l0(1);
        this.f62233d = new a((TbPageContext) this.f62230a, d.b.j0.t.d.b.b.b.j);
        this.f62232c.add(this.f62235f);
        this.f62232c.add(this.f62234e);
        this.f62232c.add(this.f62233d);
        this.f62231b.a(this.f62232c);
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f62231b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f62231b.getAdapter2().notifyDataSetChanged();
    }

    public void c(g gVar) {
        this.f62235f.n0(gVar);
        this.f62234e.n0(gVar);
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f62231b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }

    public void e(int i) {
        this.f62235f.m0(i);
        this.f62234e.m0(i);
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        this.f62233d.n0(iAlaSquareTabController);
    }
}
