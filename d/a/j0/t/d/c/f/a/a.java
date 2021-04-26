package d.a.j0.t.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.YYLiveUtil;
import d.a.j0.t.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.t.d.c.f.a.b f60509a;

    /* renamed from: b  reason: collision with root package name */
    public c f60510b;

    /* renamed from: c  reason: collision with root package name */
    public g f60511c;

    /* renamed from: d  reason: collision with root package name */
    public f f60512d;

    /* renamed from: e  reason: collision with root package name */
    public d f60513e;

    /* renamed from: f  reason: collision with root package name */
    public e f60514f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.c.j.e.a> f60515g = new LinkedList();

    /* renamed from: d.a.j0.t.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1559a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f60516a;

        public C1559a(a aVar, TbPageContext tbPageContext) {
            this.f60516a = tbPageContext;
        }

        @Override // d.a.j0.t.d.c.f.d.i
        public void a(d.a.j0.t.d.a.c cVar) {
            if (cVar == null || cVar.h() == null) {
                return;
            }
            if (cVar.h().q1() != null && cVar.h().q1().mYyExtData != null) {
                YYLiveUtil.jumpYYLiveRoom(this.f60516a, cVar.h().q1());
            } else {
                d.a.j0.t.d.c.c.i(this.f60516a.getPageActivity(), cVar.h());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f60517a;

        public b(a aVar, TbPageContext tbPageContext) {
            this.f60517a = tbPageContext;
        }

        @Override // d.a.j0.t.d.c.f.d.i
        public void a(d.a.j0.t.d.a.c cVar) {
            if (cVar == null || cVar.h() == null) {
                return;
            }
            d.a.j0.t.d.c.c.i(this.f60517a.getPageActivity(), cVar.h());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f60509a = new d.a.j0.t.d.c.f.a.b(tbPageContext);
        this.f60510b = new c(tbPageContext);
        this.f60511c = new g(tbPageContext);
        this.f60512d = new f(tbPageContext);
        this.f60513e = new d(tbPageContext);
        this.f60514f = new e(tbPageContext);
        this.f60510b.g0(new C1559a(this, tbPageContext));
        this.f60512d.g0(new b(this, tbPageContext));
        this.f60515g.add(this.f60509a);
        this.f60515g.add(this.f60510b);
        this.f60515g.add(this.f60511c);
        this.f60515g.add(this.f60512d);
        this.f60515g.add(this.f60513e);
        this.f60515g.add(this.f60514f);
    }

    public List<d.a.c.j.e.a> a() {
        return this.f60515g;
    }
}
