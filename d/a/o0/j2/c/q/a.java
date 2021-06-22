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
import d.a.i.d;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.o0.z.b0;
import d.a.o0.z.e0.k;
/* loaded from: classes5.dex */
public class a extends d.a.c.k.e.a<d.a.o0.z.e0.e, ThreadCardViewHolder<d.a.o0.z.e0.e>> implements d.a.o0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<d.a.o0.z.e0.e> s;

    /* renamed from: d.a.o0.j2.c.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1451a extends b0<d.a.o0.z.e0.e> {
        public C1451a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.o0.z.e0.e eVar) {
            if (view == null || eVar == null || eVar.i() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.bottom_mask) {
                if (id == R.id.forum_name_text) {
                    d.a.o0.j2.a.a(view, eVar, 7);
                    return;
                }
                return;
            }
            d.a.o0.j2.a.a(view, eVar, 2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b {
        public b() {
        }

        @Override // d.a.i.d.b
        public void a(d.a.n0.r.q.a aVar, View view) {
            a.this.s0(view, aVar);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends b0<d.a.n0.r.q.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.r.q.a aVar) {
            a.this.s0(view, aVar);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements w {
        public d() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            a.this.i0(view, nVar);
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = 0;
        this.q = 0;
        this.s = new C1451a(this);
        this.n = tbPageContext;
        h0();
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.o = str;
    }

    public final void h0() {
        k.q0 = "c13542";
    }

    public final void i0(View view, n nVar) {
        if ((nVar instanceof d.a.o0.z.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.a.o0.z.e0.e eVar = (d.a.o0.z.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) eVar, view.getContext(), 4, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0602a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder<d.a.o0.z.e0.e> Q(ViewGroup viewGroup) {
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
        bVar.l().d(l.g(this.f43012e, R.dimen.tbds25));
        d.a.i.b bVar2 = new d.a.i.b(this.n.getPageActivity());
        bVar2.l(new c());
        bVar.n(bVar2);
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
        ThreadCardViewHolder<d.a.o0.z.e0.e> threadCardViewHolder = new ThreadCardViewHolder<>(i3);
        threadCardViewHolder.k(this.m);
        threadCardViewHolder.r(this.q);
        a0(new d());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.z.e0.e eVar, ThreadCardViewHolder<d.a.o0.z.e0.e> threadCardViewHolder) {
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
        d.a.o0.j2.a.b(eVar);
        return threadCardViewHolder.a();
    }

    public void l0(boolean z) {
        this.r = z;
    }

    public void m0(int i2) {
        this.q = i2;
    }

    public void p0(int i2) {
    }

    public void q0(int i2) {
        this.p = i2;
    }

    public final void s0(View view, d.a.n0.r.q.a aVar) {
        if (view == null || aVar == null || view.getId() == -1) {
            return;
        }
        int id = view.getId();
        if (id != R.id.user_name && id != R.id.user_avatar) {
            if (id == R.id.cover_img || id == R.id.bottom_mask) {
                d.a.o0.j2.a.a(view, aVar, 3);
                return;
            }
            return;
        }
        d.a.o0.j2.a.a(view, aVar, 1);
    }
}
