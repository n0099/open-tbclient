package d.a.n0.v.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.YYLiveUtil;
import d.a.n0.v.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.v.d.c.f.a.b f61521a;

    /* renamed from: b  reason: collision with root package name */
    public c f61522b;

    /* renamed from: c  reason: collision with root package name */
    public g f61523c;

    /* renamed from: d  reason: collision with root package name */
    public f f61524d;

    /* renamed from: e  reason: collision with root package name */
    public d f61525e;

    /* renamed from: f  reason: collision with root package name */
    public e f61526f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.c.j.e.a> f61527g = new LinkedList();

    /* renamed from: d.a.n0.v.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1644a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f61528a;

        public C1644a(a aVar, TbPageContext tbPageContext) {
            this.f61528a = tbPageContext;
        }

        @Override // d.a.n0.v.d.c.f.d.i
        public void a(d.a.n0.v.d.a.c cVar) {
            if (cVar == null || cVar.h() == null) {
                return;
            }
            if (cVar.h().r1() != null && cVar.h().r1().mYyExtData != null) {
                YYLiveUtil.jumpYYLiveRoom(this.f61528a, cVar.h().r1());
            } else {
                d.a.n0.v.d.c.c.i(this.f61528a.getPageActivity(), cVar.h());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f61529a;

        public b(a aVar, TbPageContext tbPageContext) {
            this.f61529a = tbPageContext;
        }

        @Override // d.a.n0.v.d.c.f.d.i
        public void a(d.a.n0.v.d.a.c cVar) {
            if (cVar == null || cVar.h() == null) {
                return;
            }
            d.a.n0.v.d.c.c.i(this.f61529a.getPageActivity(), cVar.h());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f61521a = new d.a.n0.v.d.c.f.a.b(tbPageContext);
        this.f61522b = new c(tbPageContext);
        this.f61523c = new g(tbPageContext);
        this.f61524d = new f(tbPageContext);
        this.f61525e = new d(tbPageContext);
        this.f61526f = new e(tbPageContext);
        this.f61522b.g0(new C1644a(this, tbPageContext));
        this.f61524d.g0(new b(this, tbPageContext));
        this.f61527g.add(this.f61521a);
        this.f61527g.add(this.f61522b);
        this.f61527g.add(this.f61523c);
        this.f61527g.add(this.f61524d);
        this.f61527g.add(this.f61525e);
        this.f61527g.add(this.f61526f);
    }

    public List<d.a.c.j.e.a> a() {
        return this.f61527g;
    }
}
