package d.b.i0.t.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import d.b.i0.t.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.t.d.c.f.a.b f60346a;

    /* renamed from: b  reason: collision with root package name */
    public c f60347b;

    /* renamed from: c  reason: collision with root package name */
    public g f60348c;

    /* renamed from: d  reason: collision with root package name */
    public f f60349d;

    /* renamed from: e  reason: collision with root package name */
    public d f60350e;

    /* renamed from: f  reason: collision with root package name */
    public e f60351f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.b.j.e.a> f60352g = new LinkedList();

    /* renamed from: d.b.i0.t.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1543a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f60353a;

        public C1543a(a aVar, TbPageContext tbPageContext) {
            this.f60353a = tbPageContext;
        }

        @Override // d.b.i0.t.d.c.f.d.i
        public void a(d.b.i0.t.d.a.c cVar) {
            if (cVar == null || cVar.g() == null) {
                return;
            }
            d.b.i0.t.d.c.c.g(this.f60353a.getPageActivity(), cVar.g());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f60354a;

        public b(a aVar, TbPageContext tbPageContext) {
            this.f60354a = tbPageContext;
        }

        @Override // d.b.i0.t.d.c.f.d.i
        public void a(d.b.i0.t.d.a.c cVar) {
            if (cVar == null || cVar.g() == null) {
                return;
            }
            d.b.i0.t.d.c.c.g(this.f60354a.getPageActivity(), cVar.g());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f60346a = new d.b.i0.t.d.c.f.a.b(tbPageContext);
        this.f60347b = new c(tbPageContext);
        this.f60348c = new g(tbPageContext);
        this.f60349d = new f(tbPageContext);
        this.f60350e = new d(tbPageContext);
        this.f60351f = new e(tbPageContext);
        this.f60347b.j0(new C1543a(this, tbPageContext));
        this.f60349d.j0(new b(this, tbPageContext));
        this.f60352g.add(this.f60346a);
        this.f60352g.add(this.f60347b);
        this.f60352g.add(this.f60348c);
        this.f60352g.add(this.f60349d);
        this.f60352g.add(this.f60350e);
        this.f60352g.add(this.f60351f);
    }

    public List<d.b.b.j.e.a> a() {
        return this.f60352g;
    }
}
