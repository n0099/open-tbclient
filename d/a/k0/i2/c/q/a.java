package d.a.k0.i2.c.q;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.i.d;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.k0.x.b0;
import d.a.k0.x.e0.k;
/* loaded from: classes5.dex */
public class a extends d.a.c.j.e.a<d.a.k0.x.e0.e, ThreadCardViewHolder<d.a.k0.x.e0.e>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<d.a.k0.x.e0.e> s;

    /* renamed from: d.a.k0.i2.c.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1373a extends b0<d.a.k0.x.e0.e> {
        public C1373a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.k0.x.e0.e eVar) {
            if (view == null || eVar == null || eVar.m() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.bottom_mask) {
                if (id == R.id.forum_name_text) {
                    d.a.k0.i2.a.a(view, eVar, 7);
                    return;
                }
                return;
            }
            d.a.k0.i2.a.a(view, eVar, 2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b {
        public b() {
        }

        @Override // d.a.i.d.b
        public void a(d.a.j0.r.q.a aVar, View view) {
            a.this.s0(view, aVar);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends b0<d.a.j0.r.q.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.j0.r.q.a aVar) {
            a.this.s0(view, aVar);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements w {
        public d() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            a.this.h0(view, nVar);
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = 0;
        this.q = 0;
        this.s = new C1373a(this);
        this.n = tbPageContext;
        g0();
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.o = str;
    }

    public final void g0() {
        k.l0 = "c13542";
    }

    public final void h0(View view, n nVar) {
        if ((nVar instanceof d.a.k0.x.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.a.k0.x.e0.e eVar = (d.a.k0.x.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) eVar, view.getContext(), 4, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0549a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder<d.a.k0.x.e0.e> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.v(this.n);
        dVar.c(32768);
        int i2 = this.p;
        if (i2 > 0) {
            dVar.b(i2);
        }
        dVar.r(false);
        dVar.w(false);
        dVar.s(new b());
        bVar.o(dVar);
        bVar.l().d(l.g(this.f39564e, R.dimen.tbds25));
        d.a.i.b bVar2 = new d.a.i.b(this.n.getPageActivity());
        bVar2.l(new c());
        bVar.n(bVar2);
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.j0.r.q.e eVar = new d.a.j0.r.q.e();
        eVar.f49950b = 3;
        eVar.f49956h = 3;
        n0Var.v(eVar);
        n0Var.w(8);
        n0Var.A(6);
        n0Var.x(4);
        bVar.m(n0Var);
        l0 i3 = bVar.i();
        i3.r(4);
        ThreadCardViewHolder<d.a.k0.x.e0.e> threadCardViewHolder = new ThreadCardViewHolder<>(i3);
        threadCardViewHolder.j(this.m);
        threadCardViewHolder.q(this.q);
        Z(new d());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.e eVar, ThreadCardViewHolder<d.a.k0.x.e0.e> threadCardViewHolder) {
        if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        eVar.U(eVar.position + 1);
        threadCardViewHolder.b().setPage(this.o);
        if (!this.r) {
            threadCardViewHolder.r();
        }
        threadCardViewHolder.f(eVar);
        threadCardViewHolder.b().p(this.s);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        d.a.k0.i2.a.b(eVar);
        return threadCardViewHolder.a();
    }

    public void m0(boolean z) {
        this.r = z;
    }

    public void n0(int i2) {
        this.q = i2;
    }

    public void p0(int i2) {
    }

    public void q0(int i2) {
        this.p = i2;
    }

    public final void s0(View view, d.a.j0.r.q.a aVar) {
        if (view == null || aVar == null || view.getId() == -1) {
            return;
        }
        int id = view.getId();
        if (id != R.id.user_name && id != R.id.user_avatar) {
            if (id == R.id.cover_img || id == R.id.bottom_mask) {
                d.a.k0.i2.a.a(view, aVar, 3);
                return;
            }
            return;
        }
        d.a.k0.i2.a.a(view, aVar, 1);
    }
}
