package d.b.i0.t.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.a.f f60675a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60676b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f60677c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public f f60678d;

    /* renamed from: e  reason: collision with root package name */
    public c f60679e;

    /* renamed from: f  reason: collision with root package name */
    public a f60680f;

    /* renamed from: g  reason: collision with root package name */
    public b f60681g;

    public g(d.b.b.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.f60675a = fVar;
        this.f60676b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        if (z) {
            c cVar = new c((TbPageContext) this.f60675a, d.b.i0.t.h.b.a.f60772g);
            this.f60679e = cVar;
            this.f60677c.add(cVar);
        } else {
            f fVar = new f((TbPageContext) this.f60675a, d.b.i0.t.h.b.a.f60772g);
            this.f60678d = fVar;
            this.f60677c.add(fVar);
        }
        this.f60680f = new a((TbPageContext) this.f60675a, d.b.i0.t.e.b.a.f60682e);
        this.f60681g = new b((TbPageContext) this.f60675a, d.b.i0.t.e.b.b.f60683e);
        this.f60677c.add(this.f60680f);
        this.f60677c.add(this.f60681g);
        this.f60676b.a(this.f60677c);
    }

    public void b(d.b.i0.t.c cVar) {
        f fVar = this.f60678d;
        if (fVar != null) {
            fVar.j0(cVar);
        }
        c cVar2 = this.f60679e;
        if (cVar2 != null) {
            cVar2.j0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f60676b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
