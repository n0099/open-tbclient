package d.a.n0.v.d.b.a;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import d.a.c.a.f;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f65134a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f65135b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f65136c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f65137d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.v.d.g.a.a f65138e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.v.d.g.a.b f65139f;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f65134a = tbPageContext;
        this.f65135b = bdTypeListView;
        a();
    }

    public final void a() {
        d.a.n0.v.d.g.a.b bVar = new d.a.n0.v.d.g.a.b((TbPageContext) this.f65134a);
        this.f65139f = bVar;
        bVar.i0(1);
        d.a.n0.v.d.g.a.a aVar = new d.a.n0.v.d.g.a.a((TbPageContext) this.f65134a);
        this.f65138e = aVar;
        aVar.i0(1);
        this.f65137d = new a((TbPageContext) this.f65134a, d.a.n0.v.d.b.b.b.j);
        this.f65136c.add(this.f65139f);
        this.f65136c.add(this.f65138e);
        this.f65136c.add(this.f65137d);
        this.f65135b.a(this.f65136c);
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f65135b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f65135b.getAdapter2().notifyDataSetChanged();
    }

    public void c(d.a.n0.v.d.g.d.f fVar) {
        this.f65139f.k0(fVar);
        this.f65138e.k0(fVar);
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f65135b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }

    public void e(int i2) {
        this.f65139f.j0(i2);
        this.f65138e.j0(i2);
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        this.f65137d.k0(iAlaSquareTabController);
    }
}
