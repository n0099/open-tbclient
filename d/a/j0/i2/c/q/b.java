package d.a.j0.i2.c.q;

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
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.i.a;
import d.a.i.f0;
import d.a.i.k0;
import d.a.i.m0;
import d.a.i.n0;
import d.a.i.u0.a;
import d.a.j0.x.b0;
import d.a.j0.x.e0.k;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<k, ThreadCardViewHolder<k>> implements d.a.j0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<k> s;

    /* loaded from: classes4.dex */
    public class a extends b0<k> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.m() == null || view.getId() != R.id.forum_name_text) {
                return;
            }
            d.a.j0.i2.a.a(view, kVar, 7);
        }
    }

    /* renamed from: d.a.j0.i2.c.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1302b implements a.InterfaceC1009a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f0 f55395a;

        public C1302b(f0 f0Var) {
            this.f55395a = f0Var;
        }

        @Override // d.a.i.a.InterfaceC1009a
        public void a(d.a.i0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.m().r1, b.this.f40319e, 4);
            d.a.j0.i2.a.a(this.f55395a.g(), aVar, 6);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.InterfaceC1009a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n0 f55397a;

        public c(n0 n0Var) {
            this.f55397a = n0Var;
        }

        @Override // d.a.i.a.InterfaceC1009a
        public void a(d.a.i0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.m().r1, b.this.f40319e, 4);
            d.a.j0.i2.a.a(this.f55397a.g(), aVar, 6);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements w {
        public d() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (b.this.s != null) {
                    b.this.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) kVar, view.getContext(), 4, false);
                threadCardViewHolder.b().o(new a.C1011a(1));
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

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<k> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity());
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
        f0 f0Var = new f0(this.n);
        f0Var.n(Boolean.FALSE);
        f0Var.v(ImageViewerConfig.FROM_CONCERN);
        f0Var.r(l.g(this.f40319e, R.dimen.tbds9));
        bVar.n(f0Var);
        bVar.l().d(l.g(this.f40319e, R.dimen.tbds25));
        f0 f0Var2 = new f0(this.n);
        f0Var2.n(Boolean.TRUE);
        f0Var2.v(ImageViewerConfig.FROM_CONCERN);
        f0Var2.y(d.a.i0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), d.a.i0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        f0Var2.w(new C1302b(f0Var2));
        bVar.h(f0Var2);
        n0 n0Var = new n0(this.n.getPageActivity());
        n0Var.n(Boolean.TRUE);
        n0Var.u(new c(n0Var));
        bVar.h(n0Var);
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.a.i0.r.q.e eVar = new d.a.i0.r.q.e();
        eVar.f49131b = 3;
        eVar.f49137h = 3;
        m0Var.v(eVar);
        m0Var.w(8);
        m0Var.A(6);
        m0Var.x(4);
        bVar.m(m0Var);
        k0 i3 = bVar.i();
        i3.r(4);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(i3);
        threadCardViewHolder.j(this.m);
        threadCardViewHolder.q(this.q);
        Z(new d());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62455e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().setPage(this.o);
        if (!this.r) {
            threadCardViewHolder.r();
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        d.a.j0.i2.a.b(kVar);
        return threadCardViewHolder.a();
    }

    public void j0(boolean z) {
        this.r = z;
    }

    public void m0(int i2) {
        this.q = i2;
    }

    public void n0(int i2) {
    }

    public void p0(int i2) {
        this.p = i2;
    }
}
