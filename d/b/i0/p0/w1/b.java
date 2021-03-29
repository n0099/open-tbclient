package d.b.i0.p0.w1;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.a.f;
import d.b.b.j.e.n;
import d.b.i0.p0.w1.a;
import d.b.i0.p0.w1.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f58656a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58657b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f58658c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f58659d;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.f58656a = fVar;
        this.f58657b = bdTypeListView;
        a();
    }

    public final void a() {
        a aVar = new a((TbPageContext) this.f58656a, d.l);
        this.f58659d = aVar;
        this.f58658c.add(aVar);
        this.f58657b.a(this.f58658c);
    }

    public void b(a.InterfaceC1444a interfaceC1444a) {
        this.f58659d.j0(interfaceC1444a);
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f58657b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
