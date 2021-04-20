package d.b.i0.t.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.a.f f62239a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f62240b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f62241c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public f f62242d;

    /* renamed from: e  reason: collision with root package name */
    public c f62243e;

    /* renamed from: f  reason: collision with root package name */
    public a f62244f;

    /* renamed from: g  reason: collision with root package name */
    public b f62245g;

    public g(d.b.c.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.f62239a = fVar;
        this.f62240b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        if (z) {
            c cVar = new c((TbPageContext) this.f62239a, d.b.i0.t.h.b.a.f62336g);
            this.f62243e = cVar;
            this.f62241c.add(cVar);
        } else {
            f fVar = new f((TbPageContext) this.f62239a, d.b.i0.t.h.b.a.f62336g);
            this.f62242d = fVar;
            this.f62241c.add(fVar);
        }
        this.f62244f = new a((TbPageContext) this.f62239a, d.b.i0.t.e.b.a.f62246e);
        this.f62245g = new b((TbPageContext) this.f62239a, d.b.i0.t.e.b.b.f62247e);
        this.f62241c.add(this.f62244f);
        this.f62241c.add(this.f62245g);
        this.f62240b.a(this.f62241c);
    }

    public void b(d.b.i0.t.c cVar) {
        f fVar = this.f62242d;
        if (fVar != null) {
            fVar.j0(cVar);
        }
        c cVar2 = this.f62243e;
        if (cVar2 != null) {
            cVar2.j0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f62240b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
