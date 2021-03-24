package d.b.i0.h2.c.q;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.b.j.e.w;
import d.b.i.a;
import d.b.i.d;
import d.b.i.f0;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.o0;
import d.b.i.r0;
import d.b.i.u0.a;
import d.b.i0.x.b0;
import d.b.i0.x.e0.k;
/* loaded from: classes5.dex */
public class f extends d.b.b.j.e.a<k, ThreadCardViewHolder<k>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<k> s;

    /* loaded from: classes5.dex */
    public class a extends b0<k> {
        public a(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.n() == null || view.getId() != R.id.forum_name_text) {
                return;
            }
            d.b.i0.h2.a.a(view, kVar, 7);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b {
        public b(f fVar) {
        }

        @Override // d.b.i.d.b
        public void a(d.b.h0.r.q.a aVar, View view) {
            if (view == null || aVar == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                d.b.i0.h2.a.a(view, aVar, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.InterfaceC1115a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f0 f55188a;

        public c(f0 f0Var) {
            this.f55188a = f0Var;
        }

        @Override // d.b.i.a.InterfaceC1115a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.n().r1, f.this.f42357e, 4);
            d.b.i0.h2.a.a(this.f55188a.g(), aVar, 6);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.InterfaceC1115a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r0 f55190a;

        public d(r0 r0Var) {
            this.f55190a = r0Var;
        }

        @Override // d.b.i.a.InterfaceC1115a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.n().r1, f.this.f42357e, 4);
            d.b.i0.h2.a.a(this.f55190a.g(), aVar, 6);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements w {
        public e() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (f.this.s != null) {
                    f.this.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) kVar, view.getContext(), 4, false);
                threadCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = 0;
        this.q = 0;
        this.s = new a(this);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
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
        dVar.s(new b(this));
        bVar.o(dVar);
        f0 f0Var = new f0(this.n);
        f0Var.n(Boolean.FALSE);
        f0Var.r(l.g(this.f42357e, R.dimen.tbds9));
        bVar.n(f0Var);
        bVar.l().d(l.g(this.f42357e, R.dimen.tbds25));
        f0 f0Var2 = new f0(this.n);
        f0Var2.n(Boolean.TRUE);
        f0Var2.y(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        f0Var2.w(new c(f0Var2));
        bVar.h(f0Var2);
        r0 r0Var = new r0(this.n.getPageActivity());
        r0Var.n(Boolean.TRUE);
        r0Var.w(new d(r0Var));
        bVar.h(r0Var);
        bVar.h(new o0(this.n.getPageActivity()));
        bVar.h(new d.b.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f50762b = 3;
        eVar.f50768h = 3;
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
        c0(new e());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62196e == null) {
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
        d.b.i0.h2.a.b(kVar);
        return threadCardViewHolder.a();
    }

    public void n0(boolean z) {
        this.r = z;
    }

    @Override // d.b.i0.m.f
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
