package d.a.n0.r0.w1;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.a.f;
import d.a.c.k.e.n;
import d.a.n0.r0.w1.a;
import d.a.n0.r0.w1.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f63430a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f63431b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f63432c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f63433d;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.f63430a = fVar;
        this.f63431b = bdTypeListView;
        a();
    }

    public final void a() {
        a aVar = new a((TbPageContext) this.f63430a, d.l);
        this.f63433d = aVar;
        this.f63432c.add(aVar);
        this.f63431b.a(this.f63432c);
    }

    public void b(a.InterfaceC1612a interfaceC1612a) {
        this.f63433d.h0(interfaceC1612a);
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f63431b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
