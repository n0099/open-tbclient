package d.a.o0.r0.w1;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.a.f;
import d.a.c.k.e.n;
import d.a.o0.r0.w1.a;
import d.a.o0.r0.w1.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public f f63555a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f63556b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f63557c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public a f63558d;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.f63555a = fVar;
        this.f63556b = bdTypeListView;
        a();
    }

    public final void a() {
        a aVar = new a((TbPageContext) this.f63555a, d.l);
        this.f63558d = aVar;
        this.f63557c.add(aVar);
        this.f63556b.a(this.f63557c);
    }

    public void b(a.InterfaceC1616a interfaceC1616a) {
        this.f63558d.h0(interfaceC1616a);
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f63556b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
