package d.a.k0.t.d.b.a;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import d.a.c.a.f;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f61133a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61134b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f61135c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f61136d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.t.d.g.a.a f61137e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.t.d.g.a.b f61138f;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f61133a = tbPageContext;
        this.f61134b = bdTypeListView;
        a();
    }

    public final void a() {
        d.a.k0.t.d.g.a.b bVar = new d.a.k0.t.d.g.a.b((TbPageContext) this.f61133a);
        this.f61138f = bVar;
        bVar.h0(1);
        d.a.k0.t.d.g.a.a aVar = new d.a.k0.t.d.g.a.a((TbPageContext) this.f61133a);
        this.f61137e = aVar;
        aVar.h0(1);
        this.f61136d = new a((TbPageContext) this.f61133a, d.a.k0.t.d.b.b.b.j);
        this.f61135c.add(this.f61138f);
        this.f61135c.add(this.f61137e);
        this.f61135c.add(this.f61136d);
        this.f61134b.a(this.f61135c);
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f61134b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f61134b.getAdapter2().notifyDataSetChanged();
    }

    public void c(d.a.k0.t.d.g.d.f fVar) {
        this.f61138f.j0(fVar);
        this.f61137e.j0(fVar);
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f61134b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }

    public void e(int i2) {
        this.f61138f.i0(i2);
        this.f61137e.i0(i2);
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        this.f61136d.j0(iAlaSquareTabController);
    }
}
