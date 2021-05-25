package d.a.n0.v.d.b.a;

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
    public f f61421a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61422b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f61423c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f61424d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.v.d.g.a.a f61425e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.v.d.g.a.b f61426f;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f61421a = tbPageContext;
        this.f61422b = bdTypeListView;
        a();
    }

    public final void a() {
        d.a.n0.v.d.g.a.b bVar = new d.a.n0.v.d.g.a.b((TbPageContext) this.f61421a);
        this.f61426f = bVar;
        bVar.h0(1);
        d.a.n0.v.d.g.a.a aVar = new d.a.n0.v.d.g.a.a((TbPageContext) this.f61421a);
        this.f61425e = aVar;
        aVar.h0(1);
        this.f61424d = new a((TbPageContext) this.f61421a, d.a.n0.v.d.b.b.b.j);
        this.f61423c.add(this.f61426f);
        this.f61423c.add(this.f61425e);
        this.f61423c.add(this.f61424d);
        this.f61422b.a(this.f61423c);
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f61422b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f61422b.getAdapter2().notifyDataSetChanged();
    }

    public void c(d.a.n0.v.d.g.d.f fVar) {
        this.f61426f.j0(fVar);
        this.f61425e.j0(fVar);
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f61422b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }

    public void e(int i2) {
        this.f61426f.i0(i2);
        this.f61425e.i0(i2);
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        this.f61424d.j0(iAlaSquareTabController);
    }
}
