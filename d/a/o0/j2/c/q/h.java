package d.a.o0.j2.c.q;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.p0;
import d.a.i.q0;
import d.a.i.u0;
import d.a.i.v0.a;
import d.a.o0.z.b0;
import d.a.o0.z.e0.k;
/* loaded from: classes5.dex */
public class h extends d.a.c.k.e.a<k, ThreadCardViewHolder<k>> implements d.a.o0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<k> s;

    /* loaded from: classes5.dex */
    public class a extends b0<k> {
        public a(h hVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.i() == null || view.getId() != R.id.forum_name_text) {
                return;
            }
            d.a.o0.j2.a.a(view, kVar, 7);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (h.this.s != null) {
                    h.this.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) kVar, view.getContext(), 4, false);
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = 0;
        this.q = 0;
        this.s = new a(this);
        this.n = tbPageContext;
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
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
        q0 q0Var = new q0(this.n.getPageActivity());
        bVar.n(q0Var);
        bVar.l().d(l.g(this.f43012e, R.dimen.tbds25));
        q0Var.u(2);
        bVar.h(new p0(this.n.getPageActivity()));
        u0 u0Var = new u0(this.n.getPageActivity());
        u0Var.x(this.n);
        u0Var.w(4);
        bVar.h(u0Var);
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.n0.r.q.e eVar = new d.a.n0.r.q.e();
        eVar.f53777b = 3;
        eVar.f53783h = 3;
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
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67302e == null) {
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
        d.a.o0.j2.a.b(kVar);
        return threadCardViewHolder.a();
    }

    public void i0(boolean z) {
        this.r = z;
    }

    public void j0(int i2) {
        this.q = i2;
    }

    public void k0(int i2) {
    }

    public void l0(int i2) {
        this.p = i2;
    }
}
