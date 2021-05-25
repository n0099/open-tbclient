package d.a.n0.r0.w1;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.a.f;
import d.a.c.j.e.n;
import d.a.n0.r0.w1.a;
import d.a.n0.r0.w1.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f59739a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f59740b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f59741c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f59742d;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.f59739a = fVar;
        this.f59740b = bdTypeListView;
        a();
    }

    public final void a() {
        a aVar = new a((TbPageContext) this.f59739a, d.l);
        this.f59742d = aVar;
        this.f59741c.add(aVar);
        this.f59740b.a(this.f59741c);
    }

    public void b(a.InterfaceC1556a interfaceC1556a) {
        this.f59742d.g0(interfaceC1556a);
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f59740b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
