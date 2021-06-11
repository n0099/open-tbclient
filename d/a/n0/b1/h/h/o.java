package d.a.n0.b1.h.h;

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
import d.a.i.f0;
import d.a.i.l0;
import d.a.i.v0.a;
/* loaded from: classes4.dex */
public class o extends d.a.c.k.e.a<d.a.n0.z.e0.k, ThreadCardViewHolder<d.a.n0.z.e0.k>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.n0.b1.h.k.e o;
    public String p;
    public d.a.c.k.e.s q;
    public d.a.n0.z.b0<d.a.n0.z.e0.k> r;

    /* loaded from: classes4.dex */
    public class a extends d.a.n0.z.b0<d.a.n0.z.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.z.e0.k kVar) {
            d.a.n0.z.t.b().d(true);
            d.a.n0.o.d.c().h("page_recommend", "show_");
            if (view == null || o.this.o == null || kVar == null || kVar.i() == null || StringUtils.isNull(kVar.i().z1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.a.n0.b1.h.f.b(d.a.c.e.m.b.f(kVar.i().z1(), 0L))) {
                d.a.n0.b1.h.f.a(d.a.c.e.m.b.f(kVar.i().z1(), 0L));
                o.this.o.e(d.a.c.e.m.b.f(kVar.i().z1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.a.c.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.i().V());
            }
            o.this.k0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.k.e.w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.n0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.n0.z.e0.k kVar = (d.a.n0.z.e0.k) nVar;
                kVar.k = 1;
                if (o.this.r != null) {
                    o.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C0600a(1));
            }
        }
    }

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.n = tbPageContext;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        f0 f0Var = new f0(this.n.getPageActivity());
        f0Var.s();
        bVar.h(f0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.k kVar, ThreadCardViewHolder<d.a.n0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67177e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.b().setPage(this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        d.a.n0.z.t.b().a(kVar.L());
        d.a.n0.o.d.c().a(kVar.L());
        d.a.n0.b1.h.m.a.c(kVar.f67177e, this.m, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void k0(View view, d.a.n0.z.e0.k kVar) {
        StatisticItem K;
        int i2;
        int id = view.getId();
        if (kVar == null) {
            return;
        }
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.forum_name_text || id == R.id.forum_enter_button) {
                TiebaStatic.log(kVar.C());
                d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.C());
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
            d.a.n0.o.d.c().i("page_recommend", "clk_", K);
            i2 = 1;
        }
        if (i2 != 0) {
            d.a.n0.b1.h.m.a.a(kVar.f67177e, this.m, kVar.E(), i2);
        }
    }

    public void l0(d.a.n0.b1.h.k.e eVar) {
        this.o = eVar;
    }

    public void m0(d.a.c.k.e.s sVar) {
        this.q = sVar;
    }
}
