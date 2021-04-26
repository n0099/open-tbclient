package d.a.j0.t.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f60848a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60849b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f60850c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public f f60851d;

    /* renamed from: e  reason: collision with root package name */
    public c f60852e;

    /* renamed from: f  reason: collision with root package name */
    public a f60853f;

    /* renamed from: g  reason: collision with root package name */
    public b f60854g;

    public g(d.a.c.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.f60848a = fVar;
        this.f60849b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        if (z) {
            c cVar = new c((TbPageContext) this.f60848a, d.a.j0.t.h.b.a.f60953g);
            this.f60852e = cVar;
            this.f60850c.add(cVar);
        } else {
            f fVar = new f((TbPageContext) this.f60848a, d.a.j0.t.h.b.a.f60953g);
            this.f60851d = fVar;
            this.f60850c.add(fVar);
        }
        this.f60853f = new a((TbPageContext) this.f60848a, d.a.j0.t.e.b.a.f60855e);
        this.f60854g = new b((TbPageContext) this.f60848a, d.a.j0.t.e.b.b.f60856e);
        this.f60850c.add(this.f60853f);
        this.f60850c.add(this.f60854g);
        this.f60849b.a(this.f60850c);
    }

    public void b(d.a.j0.t.c cVar) {
        f fVar = this.f60851d;
        if (fVar != null) {
            fVar.g0(cVar);
        }
        c cVar2 = this.f60852e;
        if (cVar2 != null) {
            cVar2.g0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f60849b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
