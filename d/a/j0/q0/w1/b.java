package d.a.j0.q0.w1;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.a.f;
import d.a.c.j.e.n;
import d.a.j0.q0.w1.a;
import d.a.j0.q0.w1.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f58856a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58857b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f58858c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f58859d;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.f58856a = fVar;
        this.f58857b = bdTypeListView;
        a();
    }

    public final void a() {
        a aVar = new a((TbPageContext) this.f58856a, d.l);
        this.f58859d = aVar;
        this.f58858c.add(aVar);
        this.f58857b.a(this.f58858c);
    }

    public void b(a.InterfaceC1469a interfaceC1469a) {
        this.f58859d.g0(interfaceC1469a);
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f58857b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
