package d.b.j0.i2.c.q;

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
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.i.a;
import d.b.i.f0;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.n0;
import d.b.i.u0.a;
import d.b.j0.x.b0;
import d.b.j0.x.e0.k;
/* loaded from: classes3.dex */
public class b extends d.b.c.j.e.a<k, ThreadCardViewHolder<k>> implements d.b.j0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<k> s;

    /* loaded from: classes3.dex */
    public class a extends b0<k> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.n() == null || view.getId() != R.id.forum_name_text) {
                return;
            }
            d.b.j0.i2.a.a(view, kVar, 7);
        }
    }

    /* renamed from: d.b.j0.i2.c.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1363b implements a.InterfaceC1070a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f0 f57454a;

        public C1363b(f0 f0Var) {
            this.f57454a = f0Var;
        }

        @Override // d.b.i.a.InterfaceC1070a
        public void a(d.b.i0.r.q.a aVar) {
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.n().r1, b.this.f43095e, 4);
            d.b.j0.i2.a.a(this.f57454a.g(), aVar, 6);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.InterfaceC1070a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n0 f57456a;

        public c(n0 n0Var) {
            this.f57456a = n0Var;
        }

        @Override // d.b.i.a.InterfaceC1070a
        public void a(d.b.i0.r.q.a aVar) {
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.n().r1, b.this.f43095e, 4);
            d.b.j0.i2.a.a(this.f57456a.g(), aVar, 6);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements w {
        public d() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (b.this.s != null) {
                    b.this.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) kVar, view.getContext(), 4, false);
                threadCardViewHolder.b().o(new a.C1072a(1));
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder<k> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.c(1024);
        dVar.c(32768);
        int i = this.p;
        if (i > 0) {
            dVar.b(i);
        }
        dVar.r(false);
        dVar.w(false);
        bVar.o(dVar);
        f0 f0Var = new f0(this.n);
        f0Var.n(Boolean.FALSE);
        f0Var.v(ImageViewerConfig.FROM_CONCERN);
        f0Var.r(l.g(this.f43095e, R.dimen.tbds9));
        bVar.n(f0Var);
        bVar.l().d(l.g(this.f43095e, R.dimen.tbds25));
        f0 f0Var2 = new f0(this.n);
        f0Var2.n(Boolean.TRUE);
        f0Var2.v(ImageViewerConfig.FROM_CONCERN);
        f0Var2.y(d.b.i0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), d.b.i0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        f0Var2.w(new C1363b(f0Var2));
        bVar.h(f0Var2);
        n0 n0Var = new n0(this.n.getPageActivity());
        n0Var.n(Boolean.TRUE);
        n0Var.u(new c(n0Var));
        bVar.h(n0Var);
        bVar.h(new d.b.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.b.i0.r.q.e eVar = new d.b.i0.r.q.e();
        eVar.f51506b = 3;
        eVar.f51512h = 3;
        m0Var.v(eVar);
        m0Var.w(8);
        m0Var.A(6);
        m0Var.x(4);
        bVar.m(m0Var);
        k0 i2 = bVar.i();
        i2.r(4);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
        threadCardViewHolder.k(this.m);
        threadCardViewHolder.r(this.q);
        c0(new d());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f64193e == null) {
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
        d.b.j0.i2.a.b(kVar);
        return threadCardViewHolder.a();
    }

    public void n0(boolean z) {
        this.r = z;
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.o = str;
    }

    public void o0(int i) {
        this.q = i;
    }

    public void p0(int i) {
    }

    public void q0(int i) {
        this.p = i;
    }
}
