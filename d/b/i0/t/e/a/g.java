package d.b.i0.t.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.a.f f60674a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60675b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f60676c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public f f60677d;

    /* renamed from: e  reason: collision with root package name */
    public c f60678e;

    /* renamed from: f  reason: collision with root package name */
    public a f60679f;

    /* renamed from: g  reason: collision with root package name */
    public b f60680g;

    public g(d.b.b.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.f60674a = fVar;
        this.f60675b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        if (z) {
            c cVar = new c((TbPageContext) this.f60674a, d.b.i0.t.h.b.a.f60771g);
            this.f60678e = cVar;
            this.f60676c.add(cVar);
        } else {
            f fVar = new f((TbPageContext) this.f60674a, d.b.i0.t.h.b.a.f60771g);
            this.f60677d = fVar;
            this.f60676c.add(fVar);
        }
        this.f60679f = new a((TbPageContext) this.f60674a, d.b.i0.t.e.b.a.f60681e);
        this.f60680g = new b((TbPageContext) this.f60674a, d.b.i0.t.e.b.b.f60682e);
        this.f60676c.add(this.f60679f);
        this.f60676c.add(this.f60680g);
        this.f60675b.a(this.f60676c);
    }

    public void b(d.b.i0.t.c cVar) {
        f fVar = this.f60677d;
        if (fVar != null) {
            fVar.j0(cVar);
        }
        c cVar2 = this.f60678e;
        if (cVar2 != null) {
            cVar2.j0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f60675b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
