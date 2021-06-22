package d.a.o0.e2.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.adapter.PbRecomChildTitleAdapter;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.o0.e2.h.j;
import d.a.o0.e2.k.e.b0;
import d.a.o0.e2.o.i;
import d.a.o0.z.e0.k;
import d.a.o0.z.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f56823a;

    /* renamed from: b  reason: collision with root package name */
    public i f56824b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f56825c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f56826d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public s f56827e;

    /* renamed from: f  reason: collision with root package name */
    public c f56828f;

    /* renamed from: g  reason: collision with root package name */
    public d f56829g;

    /* renamed from: h  reason: collision with root package name */
    public e f56830h;

    /* renamed from: i  reason: collision with root package name */
    public f f56831i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(i iVar, BdUniqueId bdUniqueId, s sVar) {
        this.f56827e = sVar;
        this.f56823a = bdUniqueId;
        this.f56824b = iVar;
        this.f56825c = iVar.getPageContext();
        a();
        d(sVar);
        sVar.a(this.f56826d);
    }

    public final void a() {
        this.f56830h = new e(this.f56825c, k.D0);
        this.f56829g = new d(this.f56825c, k.E0);
        this.f56828f = new c(this.f56825c, k.F0);
        this.f56831i = new f(this.f56825c, k.C0);
        this.j = new g(this.f56825c, k.H0);
        this.k = new h(this.f56825c, l.W);
        this.l = new PbRecomChildTitleAdapter(this.f56824b, d.a.o0.z.f0.e.f67341f);
        this.m = new b0(this.f56824b, j.f56752f, this.f56823a);
        this.f56826d.add(this.f56830h);
        this.f56826d.add(this.f56829g);
        this.f56826d.add(this.f56828f);
        this.f56826d.add(this.f56831i);
        this.f56826d.add(this.j);
        this.f56826d.add(this.k);
        this.f56826d.add(this.l);
        this.f56826d.add(this.m);
    }

    public void b() {
        s sVar = this.f56827e;
        if (sVar == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f56827e.getListAdapter().notifyDataSetChanged();
    }

    public void c() {
        b();
    }

    public final void d(s sVar) {
        this.f56830h.k0(sVar);
        this.f56829g.k0(sVar);
        this.f56828f.k0(sVar);
        this.f56831i.k0(sVar);
        this.j.k0(sVar);
        this.k.p0(sVar);
    }

    public void e(List<n> list) {
        this.f56827e.setData(list);
    }
}
