package d.a.k0.a1.b.e;

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
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.k0.x.b0;
/* loaded from: classes4.dex */
public class d extends d.a.c.j.e.a<d.a.k0.x.e0.e, ThreadCardViewHolder<d.a.k0.x.e0.e>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.c.j.e.s p;
    public b0<d.a.k0.x.e0.e> q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.k0.x.e0.e> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.k0.x.e0.e eVar) {
            d.a.k0.x.t.b().d(true);
            d.a.k0.m.d.c().h("page_recommend", "show_");
            if (view == null || eVar == null || eVar.m() == null || StringUtils.isNull(eVar.m().x1())) {
                return;
            }
            d.this.j0(view, eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.j.e.w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            d.this.g0(view, nVar);
        }
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.n = tbPageContext;
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.o = str;
    }

    public final void g0(View view, d.a.c.j.e.n nVar) {
        if ((nVar instanceof d.a.k0.x.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.a.k0.x.e0.e eVar = (d.a.k0.x.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) eVar, view.getContext(), 1, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0549a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<d.a.k0.x.e0.e> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.v(this.n);
        bVar.o(dVar);
        bVar.n(new d.a.i.b(this.n.getPageActivity()));
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.j0.r.q.e eVar = new d.a.j0.r.q.e();
        eVar.f49950b = 1;
        eVar.f49956h = 1;
        n0Var.v(eVar);
        n0Var.w(9);
        n0Var.A(4);
        n0Var.x(1);
        bVar.m(n0Var);
        bVar.l().d(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder<d.a.k0.x.e0.e> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.m);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.e eVar, ThreadCardViewHolder<d.a.k0.x.e0.e> threadCardViewHolder) {
        if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        eVar.U(eVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.b().setPage(this.o);
        threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.k();
        threadCardViewHolder.f(eVar);
        d.a.k0.x.t.b().a(eVar.A("c12351"));
        threadCardViewHolder.b().p(this.q);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    public final void j0(View view, d.a.k0.x.e0.e eVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            d.a.k0.a1.b.c.b(view, eVar, 2);
        } else if (id != R.id.user_avatar && id != R.id.user_name) {
            if (id == R.id.cover_img || id == R.id.bottom_mask) {
                d.a.k0.a1.b.c.b(view, eVar, 3);
            }
        } else {
            d.a.k0.a1.b.c.b(view, eVar, 1);
        }
    }

    public void m0(d.a.c.j.e.s sVar) {
        this.p = sVar;
    }
}
