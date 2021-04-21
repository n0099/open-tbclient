package d.b.j0.a1.k.b;

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
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import d.b.c.j.e.w;
import d.b.i.k0;
import d.b.i.u0.a;
import d.b.j0.x.b0;
import d.b.j0.x.e0.k;
import d.b.j0.x.t;
/* loaded from: classes4.dex */
public class c extends d.b.c.j.e.a<k, ThreadCardViewHolder<k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.b.j0.a1.g.k.e o;
    public s p;
    public b0<k> q;

    /* loaded from: classes4.dex */
    public class a extends b0<k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            t.b().d(true);
            if (view == null || c.this.o == null || kVar == null || kVar.n() == null || StringUtils.isNull(kVar.n().w1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.b.j0.a1.g.f.b(d.b.c.e.m.b.f(kVar.n().w1(), 0L))) {
                d.b.j0.a1.g.f.a(d.b.c.e.m.b.f(kVar.n().w1(), 0L));
                c.this.o.e(d.b.c.e.m.b.f(kVar.n().w1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.b.c.e.m.b.d((String) view.getTag(), 1), "video_tab", kVar.n().V());
            }
            c.this.n0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (c.this.q != null) {
                    c.this.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) kVar, view.getContext(), 19, false);
                threadCardViewHolder.b().o(new a.C1072a(1));
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.i.k kVar = new d.b.i.k(this.n.getPageActivity());
        kVar.t();
        bVar.h(kVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.p);
        k.r(19);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f64193e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        t.b().a(kVar.L());
        d.b.j0.m.d.c().a(kVar.L());
        d.b.j0.a1.g.m.a.c(kVar.f64193e, this.m, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void n0(View view, k kVar) {
        StatisticItem K;
        int i;
        int id = view.getId();
        if (kVar == null) {
            return;
        }
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.forum_name_text || id == R.id.forum_enter_button) {
                TiebaStatic.log(kVar.C());
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
            i = 1;
        }
        if (i != 0) {
            d.b.j0.a1.g.m.a.a(kVar.f64193e, this.m, kVar.E(), i);
        }
    }

    public void o0(BdUniqueId bdUniqueId) {
        this.m = bdUniqueId;
    }

    public void p0(d.b.j0.a1.g.k.e eVar) {
        this.o = eVar;
    }

    public void q0(s sVar) {
        this.p = sVar;
    }
}
