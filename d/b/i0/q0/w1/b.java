package d.b.i0.q0.w1;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.a.f;
import d.b.c.j.e.n;
import d.b.i0.q0.w1.a;
import d.b.i0.q0.w1.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f60324a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60325b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f60326c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f60327d;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.f60324a = fVar;
        this.f60325b = bdTypeListView;
        a();
    }

    public final void a() {
        a aVar = new a((TbPageContext) this.f60324a, d.l);
        this.f60327d = aVar;
        this.f60326c.add(aVar);
        this.f60325b.a(this.f60326c);
    }

    public void b(a.InterfaceC1507a interfaceC1507a) {
        this.f60327d.j0(interfaceC1507a);
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f60325b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
