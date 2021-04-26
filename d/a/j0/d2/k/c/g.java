package d.a.j0.d2.k.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.k0;
import d.a.i.m0;
import d.a.i.u0.a;
import d.a.j0.x.b0;
import d.a.j0.x.e0.k;
/* loaded from: classes3.dex */
public class g extends d.a.c.j.e.a<k, ThreadCardViewHolder<k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;
    public b0<k> p;

    /* loaded from: classes3.dex */
    public class a extends b0<k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().w1())) {
                return;
            }
            g.this.i0(view, kVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (g.this.p != null) {
                    g.this.p.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) kVar, view.getContext(), 0, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f52123a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f52124b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f52125c;

        public c(g gVar, ViewGroup viewGroup, View view, int i2) {
            this.f52123a = viewGroup;
            this.f52124b = view;
            this.f52125c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.i.e.a((s) this.f52123a, this.f52124b, this.f52125c));
            }
        }
    }

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = new a();
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<k> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        m0 m0Var = new m0(this.n.getPageActivity());
        d.a.i0.r.q.e eVar = new d.a.i0.r.q.e();
        eVar.f49131b = 5;
        eVar.f49137h = 5;
        m0Var.v(eVar);
        m0Var.w(2);
        m0Var.A(2);
        m0Var.x(0);
        m0Var.b(32);
        bVar.m(m0Var);
        k0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.o);
        k.r(0);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.m);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62455e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b().e() instanceof m0) {
            ((m0) threadCardViewHolder.b().e()).z(new c(this, viewGroup, view, i2));
        }
        threadCardViewHolder.s(false, Align.ALIGN_RIGHT_BOTTOM);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.p);
        return threadCardViewHolder.a();
    }

    public final void i0(View view, k kVar) {
        if (view.getId() != R.id.thread_card_root) {
            view.getId();
        }
    }

    public void j0(s sVar) {
        this.o = sVar;
    }
}
