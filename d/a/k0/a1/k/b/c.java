package d.a.k0.a1.k.b;

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
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.k0.x.b0;
import d.a.k0.x.e0.k;
import d.a.k0.x.t;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<k, ThreadCardViewHolder<k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.k0.a1.g.k.e o;
    public s p;
    public b0<k> q;

    /* loaded from: classes4.dex */
    public class a extends b0<k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            t.b().d(true);
            if (view == null || c.this.o == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().x1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.a.k0.a1.g.f.b(d.a.c.e.m.b.f(kVar.m().x1(), 0L))) {
                d.a.k0.a1.g.f.a(d.a.c.e.m.b.f(kVar.m().x1(), 0L));
                c.this.o.e(d.a.c.e.m.b.f(kVar.m().x1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.a.c.e.m.b.d((String) view.getTag(), 1), "video_tab", kVar.m().V());
            }
            c.this.j0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (c.this.q != null) {
                    c.this.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) kVar, view.getContext(), 19, false);
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.k kVar = new d.a.i.k(this.n.getPageActivity());
        kVar.t();
        bVar.h(kVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.p);
        k.r(19);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.m);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63179e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        t.b().a(kVar.L());
        d.a.k0.m.d.c().a(kVar.L());
        d.a.k0.a1.g.m.a.c(kVar.f63179e, this.m, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void j0(View view, k kVar) {
        StatisticItem K;
        int i2;
        int id = view.getId();
        if (kVar == null) {
            return;
        }
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.forum_name_text || id == R.id.forum_enter_button) {
                TiebaStatic.log(kVar.C());
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
            i2 = 1;
        }
        if (i2 != 0) {
            d.a.k0.a1.g.m.a.a(kVar.f63179e, this.m, kVar.E(), i2);
        }
    }

    public void m0(BdUniqueId bdUniqueId) {
        this.m = bdUniqueId;
    }

    public void n0(d.a.k0.a1.g.k.e eVar) {
        this.o = eVar;
    }

    public void p0(s sVar) {
        this.p = sVar;
    }
}
