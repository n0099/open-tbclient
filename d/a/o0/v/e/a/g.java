package d.a.o0.v.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f65700a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f65701b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f65702c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public f f65703d;

    /* renamed from: e  reason: collision with root package name */
    public c f65704e;

    /* renamed from: f  reason: collision with root package name */
    public a f65705f;

    /* renamed from: g  reason: collision with root package name */
    public b f65706g;

    public g(d.a.c.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.f65700a = fVar;
        this.f65701b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        if (z) {
            c cVar = new c((TbPageContext) this.f65700a, d.a.o0.v.h.b.a.f65805g);
            this.f65704e = cVar;
            this.f65702c.add(cVar);
        } else {
            f fVar = new f((TbPageContext) this.f65700a, d.a.o0.v.h.b.a.f65805g);
            this.f65703d = fVar;
            this.f65702c.add(fVar);
        }
        this.f65705f = new a((TbPageContext) this.f65700a, d.a.o0.v.e.b.a.f65707e);
        this.f65706g = new b((TbPageContext) this.f65700a, d.a.o0.v.e.b.b.f65708e);
        this.f65702c.add(this.f65705f);
        this.f65702c.add(this.f65706g);
        this.f65701b.a(this.f65702c);
    }

    public void b(d.a.o0.v.c cVar) {
        f fVar = this.f65703d;
        if (fVar != null) {
            fVar.h0(cVar);
        }
        c cVar2 = this.f65704e;
        if (cVar2 != null) {
            cVar2.h0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f65701b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
        }
    }
}
