package d.b.i0.f2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.i0.f2.c.d;
import d.b.i0.f2.c.e;
import d.b.i0.f2.c.f;
import d.b.i0.f2.c.g;
import d.b.i0.f2.e.h;
import d.b.i0.f2.e.i;
import d.b.i0.f2.e.k;
import d.b.i0.f2.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e f54741a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.f2.c.a f54742b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.f2.c.b f54743c;

    /* renamed from: d  reason: collision with root package name */
    public g f54744d;

    /* renamed from: e  reason: collision with root package name */
    public d f54745e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.f2.c.c f54746f;

    /* renamed from: g  reason: collision with root package name */
    public f f54747g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f54748h;
    public List<d.b.b.j.e.a> i = new ArrayList();

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f54748h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f54742b.h0();
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f54741a = new e(tbPageContext, i.f54787f);
        this.f54742b = new d.b.i0.f2.c.a(tbPageContext, d.b.i0.f2.e.d.k);
        this.f54743c = new d.b.i0.f2.c.b(tbPageContext, d.b.i0.f2.e.e.f54768e);
        this.f54744d = new g(tbPageContext, n.f54807f);
        this.f54745e = new d(tbPageContext, h.p);
        this.f54747g = new f(tbPageContext, k.f54797f);
        this.f54746f = new d.b.i0.f2.c.c(tbPageContext, d.b.i0.f2.e.g.f54777g);
        this.i.add(this.f54741a);
        this.i.add(this.f54742b);
        this.i.add(this.f54743c);
        this.i.add(this.f54744d);
        this.i.add(this.f54745e);
        this.i.add(this.f54746f);
        this.i.add(this.f54747g);
        bdTypeListView.a(this.i);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f54748h;
        if (bdTypeListView != null && (bdTypeListView.getAdapter2() instanceof d.b.b.j.e.e)) {
            this.f54748h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        this.f54742b.l0();
    }
}
