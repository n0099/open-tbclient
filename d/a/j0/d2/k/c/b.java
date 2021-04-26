package d.a.j0.d2.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.adapter.PbRecomChildTitleAdapter;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.j0.d2.h.j;
import d.a.j0.d2.k.e.b0;
import d.a.j0.d2.o.i;
import d.a.j0.x.e0.k;
import d.a.j0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f52104a;

    /* renamed from: b  reason: collision with root package name */
    public i f52105b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f52106c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f52107d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public s f52108e;

    /* renamed from: f  reason: collision with root package name */
    public c f52109f;

    /* renamed from: g  reason: collision with root package name */
    public d f52110g;

    /* renamed from: h  reason: collision with root package name */
    public e f52111h;

    /* renamed from: i  reason: collision with root package name */
    public f f52112i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(i iVar, BdUniqueId bdUniqueId, s sVar) {
        this.f52108e = sVar;
        this.f52104a = bdUniqueId;
        this.f52105b = iVar;
        this.f52106c = iVar.getPageContext();
        a();
        d(sVar);
        sVar.a(this.f52107d);
    }

    public final void a() {
        this.f52111h = new e(this.f52106c, k.x0);
        this.f52110g = new d(this.f52106c, k.y0);
        this.f52109f = new c(this.f52106c, k.z0);
        this.f52112i = new f(this.f52106c, k.w0);
        this.j = new g(this.f52106c, k.B0);
        this.k = new h(this.f52106c, l.V);
        this.l = new PbRecomChildTitleAdapter(this.f52105b, d.a.j0.x.f0.e.f62494f);
        this.m = new b0(this.f52105b, j.f52034f, this.f52104a);
        this.f52107d.add(this.f52111h);
        this.f52107d.add(this.f52110g);
        this.f52107d.add(this.f52109f);
        this.f52107d.add(this.f52112i);
        this.f52107d.add(this.j);
        this.f52107d.add(this.k);
        this.f52107d.add(this.l);
        this.f52107d.add(this.m);
    }

    public void b() {
        s sVar = this.f52108e;
        if (sVar == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f52108e.getListAdapter().notifyDataSetChanged();
    }

    public void c() {
        b();
    }

    public final void d(s sVar) {
        this.f52111h.j0(sVar);
        this.f52110g.j0(sVar);
        this.f52109f.j0(sVar);
        this.f52112i.j0(sVar);
        this.j.j0(sVar);
        this.k.p0(sVar);
    }

    public void e(List<n> list) {
        this.f52108e.setData(list);
    }
}
