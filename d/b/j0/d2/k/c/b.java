package d.b.j0.d2.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.adapter.PbRecomChildTitleAdapter;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import d.b.j0.d2.h.j;
import d.b.j0.d2.k.e.b0;
import d.b.j0.d2.o.i;
import d.b.j0.x.e0.k;
import d.b.j0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f54318a;

    /* renamed from: b  reason: collision with root package name */
    public i f54319b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f54320c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f54321d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public s f54322e;

    /* renamed from: f  reason: collision with root package name */
    public c f54323f;

    /* renamed from: g  reason: collision with root package name */
    public d f54324g;

    /* renamed from: h  reason: collision with root package name */
    public e f54325h;
    public f i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(i iVar, BdUniqueId bdUniqueId, s sVar) {
        this.f54322e = sVar;
        this.f54318a = bdUniqueId;
        this.f54319b = iVar;
        this.f54320c = iVar.getPageContext();
        a();
        d(sVar);
        sVar.a(this.f54321d);
    }

    public final void a() {
        this.f54325h = new e(this.f54320c, k.x0);
        this.f54324g = new d(this.f54320c, k.y0);
        this.f54323f = new c(this.f54320c, k.z0);
        this.i = new f(this.f54320c, k.w0);
        this.j = new g(this.f54320c, k.B0);
        this.k = new h(this.f54320c, l.V);
        this.l = new PbRecomChildTitleAdapter(this.f54319b, d.b.j0.x.f0.e.f64228f);
        this.m = new b0(this.f54319b, j.f54253f, this.f54318a);
        this.f54321d.add(this.f54325h);
        this.f54321d.add(this.f54324g);
        this.f54321d.add(this.f54323f);
        this.f54321d.add(this.i);
        this.f54321d.add(this.j);
        this.f54321d.add(this.k);
        this.f54321d.add(this.l);
        this.f54321d.add(this.m);
    }

    public void b() {
        s sVar = this.f54322e;
        if (sVar == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f54322e.getListAdapter().notifyDataSetChanged();
    }

    public void c() {
        b();
    }

    public final void d(s sVar) {
        this.f54325h.n0(sVar);
        this.f54324g.n0(sVar);
        this.f54323f.n0(sVar);
        this.i.n0(sVar);
        this.j.n0(sVar);
        this.k.q0(sVar);
    }

    public void e(List<n> list) {
        this.f54322e.setData(list);
    }
}
