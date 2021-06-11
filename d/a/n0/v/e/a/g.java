package d.a.n0.v.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f65575a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f65576b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f65577c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public f f65578d;

    /* renamed from: e  reason: collision with root package name */
    public c f65579e;

    /* renamed from: f  reason: collision with root package name */
    public a f65580f;

    /* renamed from: g  reason: collision with root package name */
    public b f65581g;

    public g(d.a.c.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.f65575a = fVar;
        this.f65576b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        if (z) {
            c cVar = new c((TbPageContext) this.f65575a, d.a.n0.v.h.b.a.f65680g);
            this.f65579e = cVar;
            this.f65577c.add(cVar);
        } else {
            f fVar = new f((TbPageContext) this.f65575a, d.a.n0.v.h.b.a.f65680g);
            this.f65578d = fVar;
            this.f65577c.add(fVar);
        }
        this.f65580f = new a((TbPageContext) this.f65575a, d.a.n0.v.e.b.a.f65582e);
        this.f65581g = new b((TbPageContext) this.f65575a, d.a.n0.v.e.b.b.f65583e);
        this.f65577c.add(this.f65580f);
        this.f65577c.add(this.f65581g);
        this.f65576b.a(this.f65577c);
    }

    public void b(d.a.n0.v.c cVar) {
        f fVar = this.f65578d;
        if (fVar != null) {
            fVar.h0(cVar);
        }
        c cVar2 = this.f65579e;
        if (cVar2 != null) {
            cVar2.h0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f65576b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
