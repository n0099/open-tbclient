package d.a.k0.d2.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.adapter.PbRecomChildTitleAdapter;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.k0.d2.h.j;
import d.a.k0.d2.k.e.b0;
import d.a.k0.d2.o.i;
import d.a.k0.x.e0.k;
import d.a.k0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f52803a;

    /* renamed from: b  reason: collision with root package name */
    public i f52804b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f52805c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f52806d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public s f52807e;

    /* renamed from: f  reason: collision with root package name */
    public c f52808f;

    /* renamed from: g  reason: collision with root package name */
    public d f52809g;

    /* renamed from: h  reason: collision with root package name */
    public e f52810h;

    /* renamed from: i  reason: collision with root package name */
    public f f52811i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(i iVar, BdUniqueId bdUniqueId, s sVar) {
        this.f52807e = sVar;
        this.f52803a = bdUniqueId;
        this.f52804b = iVar;
        this.f52805c = iVar.getPageContext();
        a();
        d(sVar);
        sVar.a(this.f52806d);
    }

    public final void a() {
        this.f52810h = new e(this.f52805c, k.y0);
        this.f52809g = new d(this.f52805c, k.z0);
        this.f52808f = new c(this.f52805c, k.A0);
        this.f52811i = new f(this.f52805c, k.x0);
        this.j = new g(this.f52805c, k.C0);
        this.k = new h(this.f52805c, l.W);
        this.l = new PbRecomChildTitleAdapter(this.f52804b, d.a.k0.x.f0.e.f63218f);
        this.m = new b0(this.f52804b, j.f52733f, this.f52803a);
        this.f52806d.add(this.f52810h);
        this.f52806d.add(this.f52809g);
        this.f52806d.add(this.f52808f);
        this.f52806d.add(this.f52811i);
        this.f52806d.add(this.j);
        this.f52806d.add(this.k);
        this.f52806d.add(this.l);
        this.f52806d.add(this.m);
    }

    public void b() {
        s sVar = this.f52807e;
        if (sVar == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f52807e.getListAdapter().notifyDataSetChanged();
    }

    public void c() {
        b();
    }

    public final void d(s sVar) {
        this.f52810h.j0(sVar);
        this.f52809g.j0(sVar);
        this.f52808f.j0(sVar);
        this.f52811i.j0(sVar);
        this.j.j0(sVar);
        this.k.p0(sVar);
    }

    public void e(List<n> list) {
        this.f52807e.setData(list);
    }
}
