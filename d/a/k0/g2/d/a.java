package d.a.k0.g2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.k0.g2.c.d;
import d.a.k0.g2.c.e;
import d.a.k0.g2.c.f;
import d.a.k0.g2.c.g;
import d.a.k0.g2.e.h;
import d.a.k0.g2.e.i;
import d.a.k0.g2.e.k;
import d.a.k0.g2.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e f55237a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.g2.c.a f55238b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.g2.c.b f55239c;

    /* renamed from: d  reason: collision with root package name */
    public g f55240d;

    /* renamed from: e  reason: collision with root package name */
    public d f55241e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.g2.c.c f55242f;

    /* renamed from: g  reason: collision with root package name */
    public f f55243g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f55244h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.j.e.a> f55245i = new ArrayList();

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55244h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f55238b.e0();
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55237a = new e(tbPageContext, i.f55287f);
        this.f55238b = new d.a.k0.g2.c.a(tbPageContext, d.a.k0.g2.e.d.k);
        this.f55239c = new d.a.k0.g2.c.b(tbPageContext, d.a.k0.g2.e.e.f55266e);
        this.f55240d = new g(tbPageContext, n.f55307f);
        this.f55241e = new d(tbPageContext, h.p);
        this.f55243g = new f(tbPageContext, k.f55297f);
        this.f55242f = new d.a.k0.g2.c.c(tbPageContext, d.a.k0.g2.e.g.f55276g);
        this.f55245i.add(this.f55237a);
        this.f55245i.add(this.f55238b);
        this.f55245i.add(this.f55239c);
        this.f55245i.add(this.f55240d);
        this.f55245i.add(this.f55241e);
        this.f55245i.add(this.f55242f);
        this.f55245i.add(this.f55243g);
        bdTypeListView.a(this.f55245i);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f55244h;
        if (bdTypeListView != null && (bdTypeListView.getAdapter2() instanceof d.a.c.j.e.e)) {
            this.f55244h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        this.f55238b.h0();
    }
}
