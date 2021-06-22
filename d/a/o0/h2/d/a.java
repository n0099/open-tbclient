package d.a.o0.h2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.o0.h2.c.d;
import d.a.o0.h2.c.e;
import d.a.o0.h2.c.f;
import d.a.o0.h2.c.g;
import d.a.o0.h2.e.h;
import d.a.o0.h2.e.i;
import d.a.o0.h2.e.k;
import d.a.o0.h2.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e f59325a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.h2.c.a f59326b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.h2.c.b f59327c;

    /* renamed from: d  reason: collision with root package name */
    public g f59328d;

    /* renamed from: e  reason: collision with root package name */
    public d f59329e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.h2.c.c f59330f;

    /* renamed from: g  reason: collision with root package name */
    public f f59331g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f59332h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59333i = new ArrayList();

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f59332h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f59326b.e0();
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f59325a = new e(tbPageContext, i.f59375f);
        this.f59326b = new d.a.o0.h2.c.a(tbPageContext, d.a.o0.h2.e.d.k);
        this.f59327c = new d.a.o0.h2.c.b(tbPageContext, d.a.o0.h2.e.e.f59354e);
        this.f59328d = new g(tbPageContext, n.f59395f);
        this.f59329e = new d(tbPageContext, h.p);
        this.f59331g = new f(tbPageContext, k.f59385f);
        this.f59330f = new d.a.o0.h2.c.c(tbPageContext, d.a.o0.h2.e.g.f59364g);
        this.f59333i.add(this.f59325a);
        this.f59333i.add(this.f59326b);
        this.f59333i.add(this.f59327c);
        this.f59333i.add(this.f59328d);
        this.f59333i.add(this.f59329e);
        this.f59333i.add(this.f59330f);
        this.f59333i.add(this.f59331g);
        bdTypeListView.a(this.f59333i);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f59332h;
        if (bdTypeListView != null && (bdTypeListView.getAdapter2() instanceof d.a.c.k.e.e)) {
            this.f59332h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        this.f59326b.i0();
    }
}
