package d.a.n0.j2.c.q;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.i.a;
import d.a.i.g0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.o0;
import d.a.i.v0.a;
import d.a.n0.z.b0;
import d.a.n0.z.e0.k;
/* loaded from: classes5.dex */
public class b extends d.a.c.k.e.a<k, ThreadCardViewHolder<k>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<k> s;

    /* loaded from: classes5.dex */
    public class a extends b0<k> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.i() == null || view.getId() != R.id.forum_name_text) {
                return;
            }
            d.a.n0.j2.a.a(view, kVar, 7);
        }
    }

    /* renamed from: d.a.n0.j2.c.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1448b implements a.InterfaceC0598a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f59975a;

        public C1448b(g0 g0Var) {
            this.f59975a = g0Var;
        }

        @Override // d.a.i.a.InterfaceC0598a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null || aVar.i() == null || aVar.i().t1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.i().t1, b.this.f42909e, 4);
            d.a.n0.j2.a.a(this.f59975a.g(), aVar, 6);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.InterfaceC0598a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o0 f59977a;

        public c(o0 o0Var) {
            this.f59977a = o0Var;
        }

        @Override // d.a.i.a.InterfaceC0598a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null || aVar.i() == null || aVar.i().t1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.i().t1, b.this.f42909e, 4);
            d.a.n0.j2.a.a(this.f59977a.g(), aVar, 6);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements w {
        public d() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (b.this.s != null) {
                    b.this.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) kVar, view.getContext(), 4, false);
                threadCardViewHolder.b().o(new a.C0600a(1));
            }
        }
    }

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = 0;
        this.q = 0;
        this.s = new a(this);
        this.n = tbPageContext;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder<k> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.c(1024);
        dVar.c(32768);
        int i2 = this.p;
        if (i2 > 0) {
            dVar.b(i2);
        }
        dVar.r(false);
        dVar.w(false);
        bVar.o(dVar);
        g0 g0Var = new g0(this.n);
        g0Var.n(Boolean.FALSE);
        g0Var.v(ImageViewerConfig.FROM_CONCERN);
        g0Var.r(l.g(this.f42909e, R.dimen.tbds9));
        bVar.n(g0Var);
        bVar.l().d(l.g(this.f42909e, R.dimen.tbds25));
        g0 g0Var2 = new g0(this.n);
        g0Var2.n(Boolean.TRUE);
        g0Var2.v(ImageViewerConfig.FROM_CONCERN);
        g0Var2.y(d.a.m0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), d.a.m0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        g0Var2.w(new C1448b(g0Var2));
        bVar.h(g0Var2);
        o0 o0Var = new o0(this.n.getPageActivity());
        o0Var.n(Boolean.TRUE);
        o0Var.u(new c(o0Var));
        bVar.h(o0Var);
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.m0.r.q.e eVar = new d.a.m0.r.q.e();
        eVar.f53670b = 3;
        eVar.f53676h = 3;
        n0Var.v(eVar);
        n0Var.w(8);
        n0Var.A(6);
        n0Var.x(4);
        bVar.m(n0Var);
        l0 i3 = bVar.i();
        i3.r(4);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(i3);
        threadCardViewHolder.k(this.m);
        threadCardViewHolder.r(this.q);
        a0(new d());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67177e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().setPage(this.o);
        if (!this.r) {
            threadCardViewHolder.s();
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        d.a.n0.j2.a.b(kVar);
        return threadCardViewHolder.a();
    }

    public void k0(boolean z) {
        this.r = z;
    }

    public void l0(int i2) {
        this.q = i2;
    }

    public void m0(int i2) {
    }

    public void p0(int i2) {
        this.p = i2;
    }
}
