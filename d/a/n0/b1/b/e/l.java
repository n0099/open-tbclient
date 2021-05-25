package d.a.n0.b1.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.n0.z.b0;
/* loaded from: classes4.dex */
public class l extends d.a.c.j.e.a<d.a.n0.z.e0.k, ThreadCardViewHolder<d.a.n0.z.e0.k>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.c.j.e.s p;
    public NEGFeedBackView.b q;
    public b0<d.a.n0.z.e0.k> r;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.n0.z.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.z.e0.k kVar) {
            d.a.n0.z.t.b().d(true);
            if (view == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().y1())) {
                return;
            }
            l.this.j0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.j.e.w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.n0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.n0.z.e0.k kVar = (d.a.n0.z.e0.k) nVar;
                kVar.k = 1;
                if (l.this.r != null) {
                    l.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) kVar, view.getContext(), 2, false, d.a.i.e.a((d.a.c.j.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0544a(1));
            }
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.n = tbPageContext;
        g0();
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.o = str;
    }

    public final void g0() {
        d.a.n0.z.e0.k.V = "c10705";
        d.a.n0.z.e0.k.W = "c10730";
        d.a.n0.z.e0.k.X = "c10731";
        d.a.n0.z.e0.k.Y = "c10704";
        d.a.n0.z.e0.k.Z = "c10755";
        d.a.n0.z.e0.k.a0 = "c10710";
        d.a.n0.z.e0.k.b0 = "c10736";
        d.a.n0.z.e0.k.c0 = "c10737";
        d.a.n0.z.e0.k.d0 = "c10711";
        d.a.n0.z.e0.k.e0 = "c10758";
        d.a.n0.z.e0.k.f0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity());
        bVar.o(new d.a.i.m(this.n.getPageActivity()));
        l0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.m);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.k kVar, ThreadCardViewHolder<d.a.n0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63459e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.b().setPage(this.o);
        threadCardViewHolder.p(false, Align.ALIGN_RIGHT_TOP, this.q);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        d.a.n0.z.t.b().a(kVar.L());
        d.a.n0.o.d.c().a(kVar.L());
        d.a.n0.b1.g.m.a.c(kVar.f63459e, this.m, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void j0(View view, d.a.n0.z.e0.k kVar) {
        int i2;
        StatisticItem K;
        int id = view.getId();
        if (kVar == null) {
            return;
        }
        if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
            if (kVar.Q()) {
                K = kVar.N();
            } else {
                K = kVar.K();
            }
            TiebaStatic.log(K);
            d.a.n0.o.d.c().i("page_concern", "clk_", K);
            i2 = 1;
        } else {
            TiebaStatic.log(kVar.C());
            d.a.n0.o.d.c().i("page_concern", "clk_", kVar.C());
            i2 = 9;
        }
        if (i2 != 0) {
            d.a.n0.b1.g.m.a.a(kVar.f63459e, this.m, kVar.E(), i2);
        }
    }

    public void m0(d.a.c.j.e.s sVar) {
        this.p = sVar;
    }
}
