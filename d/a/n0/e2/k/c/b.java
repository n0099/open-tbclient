package d.a.n0.e2.k.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.adapter.PbRecomChildTitleAdapter;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.n0.e2.h.j;
import d.a.n0.e2.k.e.b0;
import d.a.n0.e2.o.i;
import d.a.n0.z.e0.k;
import d.a.n0.z.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f53009a;

    /* renamed from: b  reason: collision with root package name */
    public i f53010b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f53011c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f53012d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public s f53013e;

    /* renamed from: f  reason: collision with root package name */
    public c f53014f;

    /* renamed from: g  reason: collision with root package name */
    public d f53015g;

    /* renamed from: h  reason: collision with root package name */
    public e f53016h;

    /* renamed from: i  reason: collision with root package name */
    public f f53017i;
    public g j;
    public h k;
    public PbRecomChildTitleAdapter l;
    public b0 m;

    public b(i iVar, BdUniqueId bdUniqueId, s sVar) {
        this.f53013e = sVar;
        this.f53009a = bdUniqueId;
        this.f53010b = iVar;
        this.f53011c = iVar.getPageContext();
        a();
        d(sVar);
        sVar.a(this.f53012d);
    }

    public final void a() {
        this.f53016h = new e(this.f53011c, k.y0);
        this.f53015g = new d(this.f53011c, k.z0);
        this.f53014f = new c(this.f53011c, k.A0);
        this.f53017i = new f(this.f53011c, k.x0);
        this.j = new g(this.f53011c, k.C0);
        this.k = new h(this.f53011c, l.W);
        this.l = new PbRecomChildTitleAdapter(this.f53010b, d.a.n0.z.f0.e.f63498f);
        this.m = new b0(this.f53010b, j.f52938f, this.f53009a);
        this.f53012d.add(this.f53016h);
        this.f53012d.add(this.f53015g);
        this.f53012d.add(this.f53014f);
        this.f53012d.add(this.f53017i);
        this.f53012d.add(this.j);
        this.f53012d.add(this.k);
        this.f53012d.add(this.l);
        this.f53012d.add(this.m);
    }

    public void b() {
        s sVar = this.f53013e;
        if (sVar == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f53013e.getListAdapter().notifyDataSetChanged();
    }

    public void c() {
        b();
    }

    public final void d(s sVar) {
        this.f53016h.j0(sVar);
        this.f53015g.j0(sVar);
        this.f53014f.j0(sVar);
        this.f53017i.j0(sVar);
        this.j.j0(sVar);
        this.k.p0(sVar);
    }

    public void e(List<n> list) {
        this.f53013e.setData(list);
    }
}
