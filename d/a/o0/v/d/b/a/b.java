package d.a.o0.v.d.b.a;

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
    public f f65259a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f65260b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f65261c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f65262d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.v.d.g.a.a f65263e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.v.d.g.a.b f65264f;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f65259a = tbPageContext;
        this.f65260b = bdTypeListView;
        a();
    }

    public final void a() {
        d.a.o0.v.d.g.a.b bVar = new d.a.o0.v.d.g.a.b((TbPageContext) this.f65259a);
        this.f65264f = bVar;
        bVar.i0(1);
        d.a.o0.v.d.g.a.a aVar = new d.a.o0.v.d.g.a.a((TbPageContext) this.f65259a);
        this.f65263e = aVar;
        aVar.i0(1);
        this.f65262d = new a((TbPageContext) this.f65259a, d.a.o0.v.d.b.b.b.j);
        this.f65261c.add(this.f65264f);
        this.f65261c.add(this.f65263e);
        this.f65261c.add(this.f65262d);
        this.f65260b.a(this.f65261c);
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f65260b;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f65260b.getAdapter2().notifyDataSetChanged();
    }

    public void c(d.a.o0.v.d.g.d.f fVar) {
        this.f65264f.k0(fVar);
        this.f65263e.k0(fVar);
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView = this.f65260b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }

    public void e(int i2) {
        this.f65264f.j0(i2);
        this.f65263e.j0(i2);
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        this.f65262d.k0(iAlaSquareTabController);
    }
}
