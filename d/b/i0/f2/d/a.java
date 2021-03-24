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
    public e f54740a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.f2.c.a f54741b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.f2.c.b f54742c;

    /* renamed from: d  reason: collision with root package name */
    public g f54743d;

    /* renamed from: e  reason: collision with root package name */
    public d f54744e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.f2.c.c f54745f;

    /* renamed from: g  reason: collision with root package name */
    public f f54746g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f54747h;
    public List<d.b.b.j.e.a> i = new ArrayList();

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f54747h = bdTypeListView;
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f54741b.h0();
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f54740a = new e(tbPageContext, i.f54786f);
        this.f54741b = new d.b.i0.f2.c.a(tbPageContext, d.b.i0.f2.e.d.k);
        this.f54742c = new d.b.i0.f2.c.b(tbPageContext, d.b.i0.f2.e.e.f54767e);
        this.f54743d = new g(tbPageContext, n.f54806f);
        this.f54744e = new d(tbPageContext, h.p);
        this.f54746g = new f(tbPageContext, k.f54796f);
        this.f54745f = new d.b.i0.f2.c.c(tbPageContext, d.b.i0.f2.e.g.f54776g);
        this.i.add(this.f54740a);
        this.i.add(this.f54741b);
        this.i.add(this.f54742c);
        this.i.add(this.f54743d);
        this.i.add(this.f54744e);
        this.i.add(this.f54745f);
        this.i.add(this.f54746g);
        bdTypeListView.a(this.i);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f54747h;
        if (bdTypeListView != null && (bdTypeListView.getAdapter2() instanceof d.b.b.j.e.e)) {
            this.f54747h.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        this.f54741b.l0();
    }
}
