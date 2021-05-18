package d.a.k0.t.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.YYLiveUtil;
import d.a.k0.t.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.t.d.c.f.a.b f61233a;

    /* renamed from: b  reason: collision with root package name */
    public c f61234b;

    /* renamed from: c  reason: collision with root package name */
    public g f61235c;

    /* renamed from: d  reason: collision with root package name */
    public f f61236d;

    /* renamed from: e  reason: collision with root package name */
    public d f61237e;

    /* renamed from: f  reason: collision with root package name */
    public e f61238f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.c.j.e.a> f61239g = new LinkedList();

    /* renamed from: d.a.k0.t.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1624a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f61240a;

        public C1624a(a aVar, TbPageContext tbPageContext) {
            this.f61240a = tbPageContext;
        }

        @Override // d.a.k0.t.d.c.f.d.i
        public void a(d.a.k0.t.d.a.c cVar) {
            if (cVar == null || cVar.h() == null) {
                return;
            }
            if (cVar.h().q1() != null && cVar.h().q1().mYyExtData != null) {
                YYLiveUtil.jumpYYLiveRoom(this.f61240a, cVar.h().q1());
            } else {
                d.a.k0.t.d.c.c.i(this.f61240a.getPageActivity(), cVar.h());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f61241a;

        public b(a aVar, TbPageContext tbPageContext) {
            this.f61241a = tbPageContext;
        }

        @Override // d.a.k0.t.d.c.f.d.i
        public void a(d.a.k0.t.d.a.c cVar) {
            if (cVar == null || cVar.h() == null) {
                return;
            }
            d.a.k0.t.d.c.c.i(this.f61241a.getPageActivity(), cVar.h());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f61233a = new d.a.k0.t.d.c.f.a.b(tbPageContext);
        this.f61234b = new c(tbPageContext);
        this.f61235c = new g(tbPageContext);
        this.f61236d = new f(tbPageContext);
        this.f61237e = new d(tbPageContext);
        this.f61238f = new e(tbPageContext);
        this.f61234b.g0(new C1624a(this, tbPageContext));
        this.f61236d.g0(new b(this, tbPageContext));
        this.f61239g.add(this.f61233a);
        this.f61239g.add(this.f61234b);
        this.f61239g.add(this.f61235c);
        this.f61239g.add(this.f61236d);
        this.f61239g.add(this.f61237e);
        this.f61239g.add(this.f61238f);
    }

    public List<d.a.c.j.e.a> a() {
        return this.f61239g;
    }
}
