package d.a.k0.q0.w1;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.a.f;
import d.a.c.j.e.n;
import d.a.k0.q0.w1.a;
import d.a.k0.q0.w1.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f59598a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f59599b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f59600c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f59601d;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.f59598a = fVar;
        this.f59599b = bdTypeListView;
        a();
    }

    public final void a() {
        a aVar = new a((TbPageContext) this.f59598a, d.l);
        this.f59601d = aVar;
        this.f59600c.add(aVar);
        this.f59599b.a(this.f59600c);
    }

    public void b(a.InterfaceC1543a interfaceC1543a) {
        this.f59601d.g0(interfaceC1543a);
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f59599b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
