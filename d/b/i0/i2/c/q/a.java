package d.b.i0.i2.c.q;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.i.d;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import d.b.i0.x.b0;
import d.b.i0.x.e0.k;
/* loaded from: classes3.dex */
public class a extends d.b.c.j.e.a<d.b.i0.x.e0.e, ThreadCardViewHolder<d.b.i0.x.e0.e>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<d.b.i0.x.e0.e> s;

    /* renamed from: d.b.i0.i2.c.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1339a extends b0<d.b.i0.x.e0.e> {
        public C1339a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.e eVar) {
            if (view == null || eVar == null || eVar.n() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.bottom_mask) {
                if (id == R.id.forum_name_text) {
                    d.b.i0.i2.a.a(view, eVar, 7);
                    return;
                }
                return;
            }
            d.b.i0.i2.a.a(view, eVar, 2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b {
        public b() {
        }

        @Override // d.b.i.d.b
        public void a(d.b.h0.r.q.a aVar, View view) {
            a.this.s0(view, aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends b0<d.b.h0.r.q.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.h0.r.q.a aVar) {
            a.this.s0(view, aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements w {
        public d() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            a.this.l0(view, nVar);
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = 0;
        this.q = 0;
        this.s = new C1339a(this);
        this.n = tbPageContext;
        j0();
    }

    public final void j0() {
        k.k0 = "c13542";
    }

    public final void l0(View view, n nVar) {
        if ((nVar instanceof d.b.i0.x.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.b.i0.x.e0.e eVar = (d.b.i0.x.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) eVar, view.getContext(), 4, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C1131a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public ThreadCardViewHolder<d.b.i0.x.e0.e> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.v(this.n);
        dVar.c(32768);
        int i = this.p;
        if (i > 0) {
            dVar.b(i);
        }
        dVar.r(false);
        dVar.w(false);
        dVar.s(new b());
        bVar.o(dVar);
        bVar.l().d(l.g(this.f42855e, R.dimen.tbds25));
        d.b.i.b bVar2 = new d.b.i.b(this.n.getPageActivity());
        bVar2.l(new c());
        bVar.n(bVar2);
        bVar.h(new d.b.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f51170b = 3;
        eVar.f51176h = 3;
        m0Var.v(eVar);
        m0Var.w(8);
        m0Var.A(6);
        m0Var.x(4);
        bVar.m(m0Var);
        k0 i2 = bVar.i();
        i2.r(4);
        ThreadCardViewHolder<d.b.i0.x.e0.e> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
        threadCardViewHolder.k(this.m);
        threadCardViewHolder.r(this.q);
        c0(new d());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: n0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.e eVar, ThreadCardViewHolder<d.b.i0.x.e0.e> threadCardViewHolder) {
        if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        eVar.U(eVar.position + 1);
        threadCardViewHolder.b().setPage(this.o);
        if (!this.r) {
            threadCardViewHolder.s();
        }
        threadCardViewHolder.f(eVar);
        threadCardViewHolder.b().p(this.s);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        d.b.i0.i2.a.b(eVar);
        return threadCardViewHolder.a();
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.o = str;
    }

    public void o0(boolean z) {
        this.r = z;
    }

    public void p0(int i) {
        this.q = i;
    }

    public void q0(int i) {
    }

    public void r0(int i) {
        this.p = i;
    }

    public final void s0(View view, d.b.h0.r.q.a aVar) {
        if (view == null || aVar == null || view.getId() == -1) {
            return;
        }
        int id = view.getId();
        if (id != R.id.user_name && id != R.id.user_avatar) {
            if (id == R.id.cover_img || id == R.id.bottom_mask) {
                d.b.i0.i2.a.a(view, aVar, 3);
                return;
            }
            return;
        }
        d.b.i0.i2.a.a(view, aVar, 1);
    }
}
