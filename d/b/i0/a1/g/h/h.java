package d.b.i0.a1.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.k0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class h extends d.b.c.j.e.a<d.b.i0.x.e0.k, ThreadCardViewHolder<d.b.i0.x.e0.k>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.b.i0.a1.g.k.e o;
    public String p;
    public d.b.c.j.e.s q;
    public d.b.i0.x.b0<d.b.i0.x.e0.k> r;

    /* loaded from: classes4.dex */
    public class a extends d.b.i0.x.b0<d.b.i0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.k kVar) {
            d.b.i0.x.t.b().d(true);
            d.b.i0.m.d.c().h("page_recommend", "show_");
            if (view == null || h.this.o == null || kVar == null || kVar.n() == null || StringUtils.isNull(kVar.n().w1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.b.i0.a1.g.f.b(d.b.c.e.m.b.f(kVar.n().w1(), 0L))) {
                d.b.i0.a1.g.f.a(d.b.c.e.m.b.f(kVar.n().w1(), 0L));
                h.this.o.e(d.b.c.e.m.b.f(kVar.n().w1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.b.c.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.n().V());
            }
            h.this.o0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.c.j.e.w {
        public b() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.i0.x.e0.k kVar = (d.b.i0.x.e0.k) nVar;
                kVar.k = 1;
                if (h.this.r != null) {
                    h.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C1131a(1));
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.n = tbPageContext;
        l0();
    }

    public final void l0() {
        d.b.i0.x.e0.k.U = "c10705";
        d.b.i0.x.e0.k.V = "c10730";
        d.b.i0.x.e0.k.W = "c10731";
        d.b.i0.x.e0.k.X = "c10704";
        d.b.i0.x.e0.k.Y = "c10755";
        d.b.i0.x.e0.k.Z = "c10710";
        d.b.i0.x.e0.k.a0 = "c10736";
        d.b.i0.x.e0.k.b0 = "c10737";
        d.b.i0.x.e0.k.c0 = "c10711";
        d.b.i0.x.e0.k.d0 = "c10758";
        d.b.i0.x.e0.k.e0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.i.k kVar = new d.b.i.k(this.n.getPageActivity());
        kVar.t();
        bVar.h(kVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: n0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.k kVar, ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63772e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.b().setPage(this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        d.b.i0.x.t.b().a(kVar.L());
        d.b.i0.m.d.c().a(kVar.L());
        d.b.i0.a1.g.m.a.c(kVar.f63772e, this.m, kVar.E());
        return threadCardViewHolder.a();
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.p = str;
    }

    public final void o0(View view, d.b.i0.x.e0.k kVar) {
        StatisticItem K;
        int i;
        int id = view.getId();
        if (kVar == null) {
            return;
        }
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.forum_name_text || id == R.id.forum_enter_button) {
                TiebaStatic.log(kVar.C());
                d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.C());
                i = 9;
            } else {
                i = 0;
            }
        } else {
            if (kVar.Q()) {
                K = kVar.N();
            } else {
                K = kVar.K();
            }
            TiebaStatic.log(K);
            d.b.i0.m.d.c().i("page_recommend", "clk_", K);
            i = 1;
        }
        if (i != 0) {
            d.b.i0.a1.g.m.a.a(kVar.f63772e, this.m, kVar.E(), i);
        }
    }

    public void p0(d.b.i0.a1.g.k.e eVar) {
        this.o = eVar;
    }

    public void q0(d.b.c.j.e.s sVar) {
        this.q = sVar;
    }
}
