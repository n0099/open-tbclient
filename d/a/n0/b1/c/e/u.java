package d.a.n0.b1.c.e;

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
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.n0.z.b0;
/* loaded from: classes4.dex */
public class u extends d.a.c.k.e.a<d.a.n0.z.e0.k, ThreadCardViewHolder<d.a.n0.z.e0.k>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.c.k.e.s p;
    public b0<d.a.n0.z.e0.k> q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.n0.z.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.z.e0.k kVar) {
            if (view == null || kVar == null || kVar.i() == null || StringUtils.isNull(kVar.i().z1())) {
                return;
            }
            u.this.j0(view, kVar);
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
                if (u.this.q != null) {
                    u.this.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) kVar, view.getContext(), 1, false, d.a.i.e.a((d.a.c.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0600a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f55055a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f55056b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55057c;

        public c(u uVar, ViewGroup viewGroup, View view, int i2) {
            this.f55055a = viewGroup;
            this.f55056b = view;
            this.f55057c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.i.e.a((d.a.c.k.e.s) this.f55055a, this.f55056b, this.f55057c));
            }
        }
    }

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.n = tbPageContext;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.m0.r.q.e eVar = new d.a.m0.r.q.e();
        eVar.f53670b = 9;
        eVar.f53676h = 9;
        n0Var.v(eVar);
        n0Var.w(4);
        n0Var.B("personalize_page");
        n0Var.A(4);
        n0Var.x(1);
        n0Var.b(32);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67177e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b().e() instanceof n0) {
            ((n0) threadCardViewHolder.b().e()).z(new c(this, viewGroup, view, i2));
        }
        if (threadCardViewHolder.b() instanceof d.a.n0.o.e) {
            threadCardViewHolder.b().setPage(this.o);
        }
        threadCardViewHolder.t(false, Align.ALIGN_RIGHT_BOTTOM);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }

    public final void j0(View view, d.a.n0.z.e0.k kVar) {
        if (view.getId() == R.id.thread_card_root || view.getId() == R.id.thread_info_commont_container) {
            d.a.n0.b1.c.c.b(view, kVar, 2);
        }
    }

    public void k0(d.a.c.k.e.s sVar) {
        this.p = sVar;
    }
}
