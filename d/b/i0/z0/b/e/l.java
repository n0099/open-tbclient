package d.b.i0.z0.b.e;

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
import d.b.i.k0;
import d.b.i.u0.a;
import d.b.i0.x.b0;
/* loaded from: classes3.dex */
public class l extends d.b.b.j.e.a<d.b.i0.x.e0.k, ThreadCardViewHolder<d.b.i0.x.e0.k>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.b.b.j.e.s p;
    public NEGFeedBackView.b q;
    public b0<d.b.i0.x.e0.k> r;

    /* loaded from: classes3.dex */
    public class a extends b0<d.b.i0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.k kVar) {
            d.b.i0.x.t.b().d(true);
            if (view == null || kVar == null || kVar.n() == null || StringUtils.isNull(kVar.n().w1())) {
                return;
            }
            l.this.n0(view, kVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.b.j.e.w {
        public b() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.i0.x.e0.k kVar = (d.b.i0.x.e0.k) nVar;
                kVar.k = 1;
                if (l.this.r != null) {
                    l.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) kVar, view.getContext(), 2, false, d.b.i.e.a((d.b.b.j.e.s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1118a(1));
            }
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.n = tbPageContext;
        j0();
    }

    public final void j0() {
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
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity());
        bVar.o(new d.b.i.m(this.n.getPageActivity()));
        k0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.k kVar, ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62197e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.b().setPage(this.o);
        threadCardViewHolder.q(false, Align.ALIGN_RIGHT_TOP, this.q);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        d.b.i0.x.t.b().a(kVar.L());
        d.b.i0.m.d.c().a(kVar.L());
        d.b.i0.z0.g.m.a.c(kVar.f62197e, this.m, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void n0(View view, d.b.i0.x.e0.k kVar) {
        int i;
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
            d.b.i0.m.d.c().i("page_concern", "clk_", K);
            i = 1;
        } else {
            TiebaStatic.log(kVar.C());
            d.b.i0.m.d.c().i("page_concern", "clk_", kVar.C());
            i = 9;
        }
        if (i != 0) {
            d.b.i0.z0.g.m.a.a(kVar.f62197e, this.m, kVar.E(), i);
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
