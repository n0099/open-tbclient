package d.b.i0.d2.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.adapter.PbRecomChildTitleAdapter;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import d.b.i0.d2.h.j;
import d.b.i0.d2.k.e.b0;
import d.b.i0.d2.o.i;
import d.b.i0.x.e0.k;
import d.b.i0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f53897a;

    /* renamed from: b  reason: collision with root package name */
    public i f53898b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f53899c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f53900d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public s f53901e;

    /* renamed from: f  reason: collision with root package name */
    public c f53902f;

    /* renamed from: g  reason: collision with root package name */
    public d f53903g;

    /* renamed from: h  reason: collision with root package name */
    public e f53904h;
    public f i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(i iVar, BdUniqueId bdUniqueId, s sVar) {
        this.f53901e = sVar;
        this.f53897a = bdUniqueId;
        this.f53898b = iVar;
        this.f53899c = iVar.getPageContext();
        a();
        d(sVar);
        sVar.a(this.f53900d);
    }

    public final void a() {
        this.f53904h = new e(this.f53899c, k.x0);
        this.f53903g = new d(this.f53899c, k.y0);
        this.f53902f = new c(this.f53899c, k.z0);
        this.i = new f(this.f53899c, k.w0);
        this.j = new g(this.f53899c, k.B0);
        this.k = new h(this.f53899c, l.V);
        this.l = new PbRecomChildTitleAdapter(this.f53898b, d.b.i0.x.f0.e.f63807f);
        this.m = new b0(this.f53898b, j.f53832f, this.f53897a);
        this.f53900d.add(this.f53904h);
        this.f53900d.add(this.f53903g);
        this.f53900d.add(this.f53902f);
        this.f53900d.add(this.i);
        this.f53900d.add(this.j);
        this.f53900d.add(this.k);
        this.f53900d.add(this.l);
        this.f53900d.add(this.m);
    }

    public void b() {
        s sVar = this.f53901e;
        if (sVar == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f53901e.getListAdapter().notifyDataSetChanged();
    }

    public void c() {
        b();
    }

    public final void d(s sVar) {
        this.f53904h.n0(sVar);
        this.f53903g.n0(sVar);
        this.f53902f.n0(sVar);
        this.i.n0(sVar);
        this.j.n0(sVar);
        this.k.q0(sVar);
    }

    public void e(List<n> list) {
        this.f53901e.setData(list);
    }
}
