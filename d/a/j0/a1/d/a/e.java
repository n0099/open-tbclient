package d.a.j0.a1.d.a;

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
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.k0;
import d.a.i.m0;
import d.a.i.u0.a;
import d.a.j0.x.b0;
import d.a.j0.x.e0.k;
/* loaded from: classes4.dex */
public class e extends d.a.c.j.e.a<k, ThreadCardViewHolder<k>> {
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
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            int id = view.getId();
            if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                d.a.j0.a1.d.e.a.e(kVar, e.this.q);
            }
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
                if (e.this.r != null) {
                    e.this.r.a(threadCardViewHolder.a(), kVar);
                }
                d.a.j0.a1.d.e.a.b(kVar, view.getContext(), 18, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f50588a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f50589b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f50590c;

        public c(e eVar, ViewGroup viewGroup, View view, int i2) {
            this.f50588a = viewGroup;
            this.f50589b = view;
            this.f50590c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.i.e.a((s) this.f50588a, this.f50589b, this.f50590c));
            }
        }
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<k> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.m.getPageActivity(), false);
        m0 m0Var = new m0(this.m.getPageActivity());
        d.a.i0.r.q.e eVar = new d.a.i0.r.q.e();
        eVar.f49131b = 15;
        eVar.f49137h = 11;
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
        threadCardViewHolder.j(this.n);
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
        threadCardViewHolder.o(false).u(this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        return threadCardViewHolder.a();
    }

    public void i0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    public void j0(int i2) {
        this.q = i2;
    }

    public void m0(BdUniqueId bdUniqueId) {
        this.n = bdUniqueId;
    }

    public void n0(s sVar) {
        this.o = sVar;
    }
}
