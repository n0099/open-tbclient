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
    public e f59200a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.h2.c.a f59201b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.h2.c.b f59202c;

    /* renamed from: d  reason: collision with root package name */
    public g f59203d;

    /* renamed from: e  reason: collision with root package name */
    public d f59204e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.h2.c.c f59205f;

    /* renamed from: g  reason: collision with root package name */
    public f f59206g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f59207h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59208i = new ArrayList();

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f59207h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f59201b.e0();
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f59200a = new e(tbPageContext, i.f59250f);
        this.f59201b = new d.a.n0.h2.c.a(tbPageContext, d.a.n0.h2.e.d.k);
        this.f59202c = new d.a.n0.h2.c.b(tbPageContext, d.a.n0.h2.e.e.f59229e);
        this.f59203d = new g(tbPageContext, n.f59270f);
        this.f59204e = new d(tbPageContext, h.p);
        this.f59206g = new f(tbPageContext, k.f59260f);
        this.f59205f = new d.a.n0.h2.c.c(tbPageContext, d.a.n0.h2.e.g.f59239g);
        this.f59208i.add(this.f59200a);
        this.f59208i.add(this.f59201b);
        this.f59208i.add(this.f59202c);
        this.f59208i.add(this.f59203d);
        this.f59208i.add(this.f59204e);
        this.f59208i.add(this.f59205f);
        this.f59208i.add(this.f59206g);
        bdTypeListView.a(this.f59208i);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f59207h;
        if (bdTypeListView != null && (bdTypeListView.getAdapter2() instanceof d.a.c.k.e.e)) {
            this.f59207h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        this.f59201b.i0();
    }
}
