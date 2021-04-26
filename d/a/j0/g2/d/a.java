package d.a.j0.g2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.j0.g2.c.d;
import d.a.j0.g2.c.e;
import d.a.j0.g2.c.f;
import d.a.j0.g2.c.g;
import d.a.j0.g2.e.h;
import d.a.j0.g2.e.i;
import d.a.j0.g2.e.k;
import d.a.j0.g2.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e f54530a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.g2.c.a f54531b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.g2.c.b f54532c;

    /* renamed from: d  reason: collision with root package name */
    public g f54533d;

    /* renamed from: e  reason: collision with root package name */
    public d f54534e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.g2.c.c f54535f;

    /* renamed from: g  reason: collision with root package name */
    public f f54536g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f54537h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.j.e.a> f54538i = new ArrayList();

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f54537h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f54531b.e0();
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f54530a = new e(tbPageContext, i.f54580f);
        this.f54531b = new d.a.j0.g2.c.a(tbPageContext, d.a.j0.g2.e.d.k);
        this.f54532c = new d.a.j0.g2.c.b(tbPageContext, d.a.j0.g2.e.e.f54559e);
        this.f54533d = new g(tbPageContext, n.f54600f);
        this.f54534e = new d(tbPageContext, h.p);
        this.f54536g = new f(tbPageContext, k.f54590f);
        this.f54535f = new d.a.j0.g2.c.c(tbPageContext, d.a.j0.g2.e.g.f54569g);
        this.f54538i.add(this.f54530a);
        this.f54538i.add(this.f54531b);
        this.f54538i.add(this.f54532c);
        this.f54538i.add(this.f54533d);
        this.f54538i.add(this.f54534e);
        this.f54538i.add(this.f54535f);
        this.f54538i.add(this.f54536g);
        bdTypeListView.a(this.f54538i);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f54537h;
        if (bdTypeListView != null && (bdTypeListView.getAdapter2() instanceof d.a.c.j.e.e)) {
            this.f54537h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        this.f54531b.h0();
    }
}
