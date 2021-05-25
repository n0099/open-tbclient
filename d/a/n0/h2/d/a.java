package d.a.n0.h2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.n0.h2.c.d;
import d.a.n0.h2.c.e;
import d.a.n0.h2.c.f;
import d.a.n0.h2.c.g;
import d.a.n0.h2.e.h;
import d.a.n0.h2.e.i;
import d.a.n0.h2.e.k;
import d.a.n0.h2.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e f55511a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.h2.c.a f55512b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.h2.c.b f55513c;

    /* renamed from: d  reason: collision with root package name */
    public g f55514d;

    /* renamed from: e  reason: collision with root package name */
    public d f55515e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.h2.c.c f55516f;

    /* renamed from: g  reason: collision with root package name */
    public f f55517g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f55518h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.j.e.a> f55519i = new ArrayList();

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55518h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f55512b.e0();
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55511a = new e(tbPageContext, i.f55561f);
        this.f55512b = new d.a.n0.h2.c.a(tbPageContext, d.a.n0.h2.e.d.k);
        this.f55513c = new d.a.n0.h2.c.b(tbPageContext, d.a.n0.h2.e.e.f55540e);
        this.f55514d = new g(tbPageContext, n.f55581f);
        this.f55515e = new d(tbPageContext, h.p);
        this.f55517g = new f(tbPageContext, k.f55571f);
        this.f55516f = new d.a.n0.h2.c.c(tbPageContext, d.a.n0.h2.e.g.f55550g);
        this.f55519i.add(this.f55511a);
        this.f55519i.add(this.f55512b);
        this.f55519i.add(this.f55513c);
        this.f55519i.add(this.f55514d);
        this.f55519i.add(this.f55515e);
        this.f55519i.add(this.f55516f);
        this.f55519i.add(this.f55517g);
        bdTypeListView.a(this.f55519i);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f55518h;
        if (bdTypeListView != null && (bdTypeListView.getAdapter2() instanceof d.a.c.j.e.e)) {
            this.f55518h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        this.f55512b.h0();
    }
}
