package d.b.j0.q0.w1;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.a.f;
import d.b.c.j.e.n;
import d.b.j0.q0.w1.a;
import d.b.j0.q0.w1.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f60745a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60746b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f60747c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f60748d;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.f60745a = fVar;
        this.f60746b = bdTypeListView;
        a();
    }

    public final void a() {
        a aVar = new a((TbPageContext) this.f60745a, d.l);
        this.f60748d = aVar;
        this.f60747c.add(aVar);
        this.f60746b.a(this.f60747c);
    }

    public void b(a.InterfaceC1530a interfaceC1530a) {
        this.f60748d.j0(interfaceC1530a);
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f60746b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
