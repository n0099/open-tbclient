package d.b.i0.g2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.i0.g2.c.d;
import d.b.i0.g2.c.e;
import d.b.i0.g2.c.f;
import d.b.i0.g2.c.g;
import d.b.i0.g2.e.h;
import d.b.i0.g2.e.i;
import d.b.i0.g2.e.k;
import d.b.i0.g2.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e f56211a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.g2.c.a f56212b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.g2.c.b f56213c;

    /* renamed from: d  reason: collision with root package name */
    public g f56214d;

    /* renamed from: e  reason: collision with root package name */
    public d f56215e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.g2.c.c f56216f;

    /* renamed from: g  reason: collision with root package name */
    public f f56217g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f56218h;
    public List<d.b.c.j.e.a> i = new ArrayList();

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56218h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f56212b.h0();
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56211a = new e(tbPageContext, i.f56257f);
        this.f56212b = new d.b.i0.g2.c.a(tbPageContext, d.b.i0.g2.e.d.k);
        this.f56213c = new d.b.i0.g2.c.b(tbPageContext, d.b.i0.g2.e.e.f56238e);
        this.f56214d = new g(tbPageContext, n.f56277f);
        this.f56215e = new d(tbPageContext, h.p);
        this.f56217g = new f(tbPageContext, k.f56267f);
        this.f56216f = new d.b.i0.g2.c.c(tbPageContext, d.b.i0.g2.e.g.f56247g);
        this.i.add(this.f56211a);
        this.i.add(this.f56212b);
        this.i.add(this.f56213c);
        this.i.add(this.f56214d);
        this.i.add(this.f56215e);
        this.i.add(this.f56216f);
        this.i.add(this.f56217g);
        bdTypeListView.a(this.i);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f56218h;
        if (bdTypeListView != null && (bdTypeListView.getAdapter2() instanceof d.b.c.j.e.e)) {
            this.f56218h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        this.f56212b.l0();
    }
}
