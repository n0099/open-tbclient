package d.a.n0.e2.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.adapter.PbRecomChildTitleAdapter;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.n0.e2.h.j;
import d.a.n0.e2.k.e.b0;
import d.a.n0.e2.o.i;
import d.a.n0.z.e0.k;
import d.a.n0.z.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f56698a;

    /* renamed from: b  reason: collision with root package name */
    public i f56699b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f56700c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f56701d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public s f56702e;

    /* renamed from: f  reason: collision with root package name */
    public c f56703f;

    /* renamed from: g  reason: collision with root package name */
    public d f56704g;

    /* renamed from: h  reason: collision with root package name */
    public e f56705h;

    /* renamed from: i  reason: collision with root package name */
    public f f56706i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(i iVar, BdUniqueId bdUniqueId, s sVar) {
        this.f56702e = sVar;
        this.f56698a = bdUniqueId;
        this.f56699b = iVar;
        this.f56700c = iVar.getPageContext();
        a();
        d(sVar);
        sVar.a(this.f56701d);
    }

    public final void a() {
        this.f56705h = new e(this.f56700c, k.y0);
        this.f56704g = new d(this.f56700c, k.z0);
        this.f56703f = new c(this.f56700c, k.A0);
        this.f56706i = new f(this.f56700c, k.x0);
        this.j = new g(this.f56700c, k.C0);
        this.k = new h(this.f56700c, l.W);
        this.l = new PbRecomChildTitleAdapter(this.f56699b, d.a.n0.z.f0.e.f67216f);
        this.m = new b0(this.f56699b, j.f56627f, this.f56698a);
        this.f56701d.add(this.f56705h);
        this.f56701d.add(this.f56704g);
        this.f56701d.add(this.f56703f);
        this.f56701d.add(this.f56706i);
        this.f56701d.add(this.j);
        this.f56701d.add(this.k);
        this.f56701d.add(this.l);
        this.f56701d.add(this.m);
    }

    public void b() {
        s sVar = this.f56702e;
        if (sVar == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f56702e.getListAdapter().notifyDataSetChanged();
    }

    public void c() {
        b();
    }

    public final void d(s sVar) {
        this.f56705h.k0(sVar);
        this.f56704g.k0(sVar);
        this.f56703f.k0(sVar);
        this.f56706i.k0(sVar);
        this.j.k0(sVar);
        this.k.p0(sVar);
    }

    public void e(List<n> list) {
        this.f56702e.setData(list);
    }
}
