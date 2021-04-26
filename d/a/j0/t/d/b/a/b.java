package d.a.j0.t.d.b.a;

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
    public f f60409a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60410b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f60411c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f60412d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.t.d.g.a.a f60413e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.t.d.g.a.b f60414f;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f60409a = tbPageContext;
        this.f60410b = bdTypeListView;
        a();
    }

    public final void a() {
        d.a.j0.t.d.g.a.b bVar = new d.a.j0.t.d.g.a.b((TbPageContext) this.f60409a);
        this.f60414f = bVar;
        bVar.h0(1);
        d.a.j0.t.d.g.a.a aVar = new d.a.j0.t.d.g.a.a((TbPageContext) this.f60409a);
        this.f60413e = aVar;
        aVar.h0(1);
        this.f60412d = new a((TbPageContext) this.f60409a, d.a.j0.t.d.b.b.b.j);
        this.f60411c.add(this.f60414f);
        this.f60411c.add(this.f60413e);
        this.f60411c.add(this.f60412d);
        this.f60410b.a(this.f60411c);
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f60410b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f60410b.getAdapter2().notifyDataSetChanged();
    }

    public void c(d.a.j0.t.d.g.d.f fVar) {
        this.f60414f.j0(fVar);
        this.f60413e.j0(fVar);
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f60410b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }

    public void e(int i2) {
        this.f60414f.i0(i2);
        this.f60413e.i0(i2);
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        this.f60412d.j0(iAlaSquareTabController);
    }
}
