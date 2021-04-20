package d.b.i0.t.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import d.b.i0.t.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.t.d.c.f.a.b f61910a;

    /* renamed from: b  reason: collision with root package name */
    public c f61911b;

    /* renamed from: c  reason: collision with root package name */
    public g f61912c;

    /* renamed from: d  reason: collision with root package name */
    public f f61913d;

    /* renamed from: e  reason: collision with root package name */
    public d f61914e;

    /* renamed from: f  reason: collision with root package name */
    public e f61915f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.c.j.e.a> f61916g = new LinkedList();

    /* renamed from: d.b.i0.t.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1596a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f61917a;

        public C1596a(a aVar, TbPageContext tbPageContext) {
            this.f61917a = tbPageContext;
        }

        @Override // d.b.i0.t.d.c.f.d.i
        public void a(d.b.i0.t.d.a.c cVar) {
            if (cVar == null || cVar.g() == null) {
                return;
            }
            d.b.i0.t.d.c.c.g(this.f61917a.getPageActivity(), cVar.g());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f61918a;

        public b(a aVar, TbPageContext tbPageContext) {
            this.f61918a = tbPageContext;
        }

        @Override // d.b.i0.t.d.c.f.d.i
        public void a(d.b.i0.t.d.a.c cVar) {
            if (cVar == null || cVar.g() == null) {
                return;
            }
            d.b.i0.t.d.c.c.g(this.f61918a.getPageActivity(), cVar.g());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f61910a = new d.b.i0.t.d.c.f.a.b(tbPageContext);
        this.f61911b = new c(tbPageContext);
        this.f61912c = new g(tbPageContext);
        this.f61913d = new f(tbPageContext);
        this.f61914e = new d(tbPageContext);
        this.f61915f = new e(tbPageContext);
        this.f61911b.j0(new C1596a(this, tbPageContext));
        this.f61913d.j0(new b(this, tbPageContext));
        this.f61916g.add(this.f61910a);
        this.f61916g.add(this.f61911b);
        this.f61916g.add(this.f61912c);
        this.f61916g.add(this.f61913d);
        this.f61916g.add(this.f61914e);
        this.f61916g.add(this.f61915f);
    }

    public List<d.b.c.j.e.a> a() {
        return this.f61916g;
    }
}
