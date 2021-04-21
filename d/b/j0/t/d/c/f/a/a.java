package d.b.j0.t.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import d.b.j0.t.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.j0.t.d.c.f.a.b f62331a;

    /* renamed from: b  reason: collision with root package name */
    public c f62332b;

    /* renamed from: c  reason: collision with root package name */
    public g f62333c;

    /* renamed from: d  reason: collision with root package name */
    public f f62334d;

    /* renamed from: e  reason: collision with root package name */
    public d f62335e;

    /* renamed from: f  reason: collision with root package name */
    public e f62336f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.c.j.e.a> f62337g = new LinkedList();

    /* renamed from: d.b.j0.t.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1619a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f62338a;

        public C1619a(a aVar, TbPageContext tbPageContext) {
            this.f62338a = tbPageContext;
        }

        @Override // d.b.j0.t.d.c.f.d.i
        public void a(d.b.j0.t.d.a.c cVar) {
            if (cVar == null || cVar.g() == null) {
                return;
            }
            d.b.j0.t.d.c.c.g(this.f62338a.getPageActivity(), cVar.g());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f62339a;

        public b(a aVar, TbPageContext tbPageContext) {
            this.f62339a = tbPageContext;
        }

        @Override // d.b.j0.t.d.c.f.d.i
        public void a(d.b.j0.t.d.a.c cVar) {
            if (cVar == null || cVar.g() == null) {
                return;
            }
            d.b.j0.t.d.c.c.g(this.f62339a.getPageActivity(), cVar.g());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f62331a = new d.b.j0.t.d.c.f.a.b(tbPageContext);
        this.f62332b = new c(tbPageContext);
        this.f62333c = new g(tbPageContext);
        this.f62334d = new f(tbPageContext);
        this.f62335e = new d(tbPageContext);
        this.f62336f = new e(tbPageContext);
        this.f62332b.j0(new C1619a(this, tbPageContext));
        this.f62334d.j0(new b(this, tbPageContext));
        this.f62337g.add(this.f62331a);
        this.f62337g.add(this.f62332b);
        this.f62337g.add(this.f62333c);
        this.f62337g.add(this.f62334d);
        this.f62337g.add(this.f62335e);
        this.f62337g.add(this.f62336f);
    }

    public List<d.b.c.j.e.a> a() {
        return this.f62337g;
    }
}
