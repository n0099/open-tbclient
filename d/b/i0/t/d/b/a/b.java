package d.b.i0.t.d.b.a;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import d.b.c.a.f;
import d.b.c.j.e.n;
import d.b.i0.t.d.g.d.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f61809a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61810b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f61811c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f61812d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.t.d.g.a.a f61813e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.t.d.g.a.b f61814f;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f61809a = tbPageContext;
        this.f61810b = bdTypeListView;
        a();
    }

    public final void a() {
        d.b.i0.t.d.g.a.b bVar = new d.b.i0.t.d.g.a.b((TbPageContext) this.f61809a);
        this.f61814f = bVar;
        bVar.l0(1);
        d.b.i0.t.d.g.a.a aVar = new d.b.i0.t.d.g.a.a((TbPageContext) this.f61809a);
        this.f61813e = aVar;
        aVar.l0(1);
        this.f61812d = new a((TbPageContext) this.f61809a, d.b.i0.t.d.b.b.b.j);
        this.f61811c.add(this.f61814f);
        this.f61811c.add(this.f61813e);
        this.f61811c.add(this.f61812d);
        this.f61810b.a(this.f61811c);
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f61810b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f61810b.getAdapter2().notifyDataSetChanged();
    }

    public void c(g gVar) {
        this.f61814f.n0(gVar);
        this.f61813e.n0(gVar);
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f61810b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }

    public void e(int i) {
        this.f61814f.m0(i);
        this.f61813e.m0(i);
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        this.f61812d.n0(iAlaSquareTabController);
    }
}
