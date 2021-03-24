package d.b.i0.t.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import d.b.i0.t.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.t.d.c.f.a.b f60345a;

    /* renamed from: b  reason: collision with root package name */
    public c f60346b;

    /* renamed from: c  reason: collision with root package name */
    public g f60347c;

    /* renamed from: d  reason: collision with root package name */
    public f f60348d;

    /* renamed from: e  reason: collision with root package name */
    public d f60349e;

    /* renamed from: f  reason: collision with root package name */
    public e f60350f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.b.j.e.a> f60351g = new LinkedList();

    /* renamed from: d.b.i0.t.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1542a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f60352a;

        public C1542a(a aVar, TbPageContext tbPageContext) {
            this.f60352a = tbPageContext;
        }

        @Override // d.b.i0.t.d.c.f.d.i
        public void a(d.b.i0.t.d.a.c cVar) {
            if (cVar == null || cVar.g() == null) {
                return;
            }
            d.b.i0.t.d.c.c.g(this.f60352a.getPageActivity(), cVar.g());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f60353a;

        public b(a aVar, TbPageContext tbPageContext) {
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

    public a(TbPageContext tbPageContext) {
        this.f60345a = new d.b.i0.t.d.c.f.a.b(tbPageContext);
        this.f60346b = new c(tbPageContext);
        this.f60347c = new g(tbPageContext);
        this.f60348d = new f(tbPageContext);
        this.f60349e = new d(tbPageContext);
        this.f60350f = new e(tbPageContext);
        this.f60346b.j0(new C1542a(this, tbPageContext));
        this.f60348d.j0(new b(this, tbPageContext));
        this.f60351g.add(this.f60345a);
        this.f60351g.add(this.f60346b);
        this.f60351g.add(this.f60347c);
        this.f60351g.add(this.f60348d);
        this.f60351g.add(this.f60349e);
        this.f60351g.add(this.f60350f);
    }

    public List<d.b.b.j.e.a> a() {
        return this.f60351g;
    }
}
