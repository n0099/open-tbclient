package d.b.i0.z0.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class d extends d.b.b.j.e.a<d.b.i0.x.e0.e, ThreadCardViewHolder<d.b.i0.x.e0.e>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.b.b.j.e.s p;
    public b0<d.b.i0.x.e0.e> q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.b.i0.x.e0.e> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.e eVar) {
            d.b.i0.x.t.b().d(true);
            d.b.i0.m.d.c().h("page_recommend", "show_");
            if (view == null || eVar == null || eVar.n() == null || StringUtils.isNull(eVar.n().w1())) {
                return;
            }
            d.this.n0(view, eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.b.j.e.w {
        public b() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            d.this.j0(view, nVar);
        }
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.n = tbPageContext;
    }

    public final void j0(View view, d.b.b.j.e.n nVar) {
        if ((nVar instanceof d.b.i0.x.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.b.i0.x.e0.e eVar = (d.b.i0.x.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) eVar, view.getContext(), 1, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C1117a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder<d.b.i0.x.e0.e> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.v(this.n);
        bVar.o(dVar);
        bVar.n(new d.b.i.b(this.n.getPageActivity()));
        bVar.h(new d.b.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f50762b = 1;
        eVar.f50768h = 1;
        m0Var.v(eVar);
        m0Var.w(9);
        m0Var.A(4);
        m0Var.x(1);
        bVar.m(m0Var);
        bVar.l().d(d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder<d.b.i0.x.e0.e> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.e eVar, ThreadCardViewHolder<d.b.i0.x.e0.e> threadCardViewHolder) {
        if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        eVar.U(eVar.position + 1);
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.b().setPage(this.o);
        threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.l();
        threadCardViewHolder.f(eVar);
        d.b.i0.x.t.b().a(eVar.A("c12351"));
        threadCardViewHolder.b().p(this.q);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public final void n0(View view, d.b.i0.x.e0.e eVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            d.b.i0.z0.b.c.b(view, eVar, 2);
        } else if (id != R.id.user_avatar && id != R.id.user_name) {
            if (id == R.id.cover_img || id == R.id.bottom_mask) {
                d.b.i0.z0.b.c.b(view, eVar, 3);
            }
        } else {
            d.b.i0.z0.b.c.b(view, eVar, 1);
        }
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.o = str;
    }

    public void o0(d.b.b.j.e.s sVar) {
        this.p = sVar;
    }
}
