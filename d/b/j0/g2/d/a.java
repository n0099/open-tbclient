package d.b.j0.g2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.j0.g2.c.d;
import d.b.j0.g2.c.e;
import d.b.j0.g2.c.f;
import d.b.j0.g2.c.g;
import d.b.j0.g2.e.h;
import d.b.j0.g2.e.i;
import d.b.j0.g2.e.k;
import d.b.j0.g2.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e f56632a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.g2.c.a f56633b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.g2.c.b f56634c;

    /* renamed from: d  reason: collision with root package name */
    public g f56635d;

    /* renamed from: e  reason: collision with root package name */
    public d f56636e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.g2.c.c f56637f;

    /* renamed from: g  reason: collision with root package name */
    public f f56638g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f56639h;
    public List<d.b.c.j.e.a> i = new ArrayList();

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56639h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f56633b.h0();
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56632a = new e(tbPageContext, i.f56678f);
        this.f56633b = new d.b.j0.g2.c.a(tbPageContext, d.b.j0.g2.e.d.k);
        this.f56634c = new d.b.j0.g2.c.b(tbPageContext, d.b.j0.g2.e.e.f56659e);
        this.f56635d = new g(tbPageContext, n.f56698f);
        this.f56636e = new d(tbPageContext, h.p);
        this.f56638g = new f(tbPageContext, k.f56688f);
        this.f56637f = new d.b.j0.g2.c.c(tbPageContext, d.b.j0.g2.e.g.f56668g);
        this.i.add(this.f56632a);
        this.i.add(this.f56633b);
        this.i.add(this.f56634c);
        this.i.add(this.f56635d);
        this.i.add(this.f56636e);
        this.i.add(this.f56637f);
        this.i.add(this.f56638g);
        bdTypeListView.a(this.i);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f56639h;
        if (bdTypeListView != null && (bdTypeListView.getAdapter2() instanceof d.b.c.j.e.e)) {
            this.f56639h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        this.f56633b.l0();
    }
}
