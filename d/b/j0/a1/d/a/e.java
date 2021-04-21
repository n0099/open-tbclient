package d.b.j0.a1.d.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import d.b.c.j.e.w;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import d.b.j0.x.b0;
import d.b.j0.x.e0.k;
/* loaded from: classes4.dex */
public class e extends d.b.c.j.e.a<k, ThreadCardViewHolder<k>> {
    public TbPageContext m;
    public BdUniqueId n;
    public s o;
    public NEGFeedBackView.b p;
    public int q;
    public b0<k> r;

    /* loaded from: classes4.dex */
    public class a extends b0<k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            int id = view.getId();
            if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                d.b.j0.a1.d.e.a.e(kVar, e.this.q);
            }
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
                if (e.this.r != null) {
                    e.this.r.a(threadCardViewHolder.a(), kVar);
                }
                d.b.j0.a1.d.e.a.b(kVar, view.getContext(), 18, false, d.b.i.e.a((s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1072a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f52890a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f52891b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f52892c;

        public c(e eVar, ViewGroup viewGroup, View view, int i) {
            this.f52890a = viewGroup;
            this.f52891b = view;
            this.f52892c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.b.i.e.a((s) this.f52890a, this.f52891b, this.f52892c));
            }
        }
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder<k> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.m.getPageActivity(), false);
        m0 m0Var = new m0(this.m.getPageActivity());
        d.b.i0.r.q.e eVar = new d.b.i0.r.q.e();
        eVar.f51506b = 15;
        eVar.f51512h = 11;
        m0Var.v(eVar);
        m0Var.w(12);
        m0Var.A(9);
        m0Var.y(this.q);
        m0Var.x(18);
        m0Var.b(32);
        bVar.m(m0Var);
        k0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.o);
        k.r(18);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.n);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f64193e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i);
        if (threadCardViewHolder.b().e() instanceof m0) {
            ((m0) threadCardViewHolder.b().e()).z(new c(this, viewGroup, view, i));
        }
        threadCardViewHolder.p(false).u(this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        return threadCardViewHolder.a();
    }

    public void m0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    public void n0(int i) {
        this.q = i;
    }

    public void o0(BdUniqueId bdUniqueId) {
        this.n = bdUniqueId;
    }

    public void p0(s sVar) {
        this.o = sVar;
    }
}
