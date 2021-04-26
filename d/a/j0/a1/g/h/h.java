package d.a.j0.a1.g.h;

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
import d.a.i.k0;
import d.a.i.u0.a;
/* loaded from: classes4.dex */
public class h extends d.a.c.j.e.a<d.a.j0.x.e0.k, ThreadCardViewHolder<d.a.j0.x.e0.k>> implements d.a.j0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.j0.a1.g.k.e o;
    public String p;
    public d.a.c.j.e.s q;
    public d.a.j0.x.b0<d.a.j0.x.e0.k> r;

    /* loaded from: classes4.dex */
    public class a extends d.a.j0.x.b0<d.a.j0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.j0.x.e0.k kVar) {
            d.a.j0.x.t.b().d(true);
            d.a.j0.m.d.c().h("page_recommend", "show_");
            if (view == null || h.this.o == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().w1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.a.j0.a1.g.f.b(d.a.c.e.m.b.f(kVar.m().w1(), 0L))) {
                d.a.j0.a1.g.f.a(d.a.c.e.m.b.f(kVar.m().w1(), 0L));
                h.this.o.e(d.a.c.e.m.b.f(kVar.m().w1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.a.c.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.m().V());
            }
            h.this.m0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.j.e.w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.j0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.j0.x.e0.k kVar = (d.a.j0.x.e0.k) nVar;
                kVar.k = 1;
                if (h.this.r != null) {
                    h.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.n = tbPageContext;
        h0();
    }

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.p = str;
    }

    public final void h0() {
        d.a.j0.x.e0.k.U = "c10705";
        d.a.j0.x.e0.k.V = "c10730";
        d.a.j0.x.e0.k.W = "c10731";
        d.a.j0.x.e0.k.X = "c10704";
        d.a.j0.x.e0.k.Y = "c10755";
        d.a.j0.x.e0.k.Z = "c10710";
        d.a.j0.x.e0.k.a0 = "c10736";
        d.a.j0.x.e0.k.b0 = "c10737";
        d.a.j0.x.e0.k.c0 = "c10711";
        d.a.j0.x.e0.k.d0 = "c10758";
        d.a.j0.x.e0.k.e0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.a.i.k kVar = new d.a.i.k(this.n.getPageActivity());
        kVar.t();
        bVar.h(kVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.m);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.x.e0.k kVar, ThreadCardViewHolder<d.a.j0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62455e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.b().setPage(this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        d.a.j0.x.t.b().a(kVar.L());
        d.a.j0.m.d.c().a(kVar.L());
        d.a.j0.a1.g.m.a.c(kVar.f62455e, this.m, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void m0(View view, d.a.j0.x.e0.k kVar) {
        StatisticItem K;
        int i2;
        int id = view.getId();
        if (kVar == null) {
            return;
        }
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.forum_name_text || id == R.id.forum_enter_button) {
                TiebaStatic.log(kVar.C());
                d.a.j0.m.d.c().i("page_recommend", "clk_", kVar.C());
                i2 = 9;
            } else {
                i2 = 0;
            }
        } else {
            if (kVar.Q()) {
                K = kVar.N();
            } else {
                K = kVar.K();
            }
            TiebaStatic.log(K);
            d.a.j0.m.d.c().i("page_recommend", "clk_", K);
            i2 = 1;
        }
        if (i2 != 0) {
            d.a.j0.a1.g.m.a.a(kVar.f62455e, this.m, kVar.E(), i2);
        }
    }

    public void n0(d.a.j0.a1.g.k.e eVar) {
        this.o = eVar;
    }

    public void p0(d.a.c.j.e.s sVar) {
        this.q = sVar;
    }
}
