package d.a.n0.b1.f.a.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import d.a.n0.z.b0;
/* loaded from: classes4.dex */
public class k extends d.a.n0.b1.f.a.d.a<z1, ThreadCardViewHolder<a2>> {
    public b0<z1> q;

    /* loaded from: classes4.dex */
    public class a extends b0<z1> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, z1 z1Var) {
            if (z1Var == null) {
                return;
            }
            k.this.e0(view, z1Var.w);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                z1 z1Var = (z1) nVar;
                a2 a2Var = z1Var.w;
                a2Var.objType = 1;
                if (k.this.q != null) {
                    k.this.q.a(threadCardViewHolder.a(), z1Var);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) a2Var, view.getContext(), 0, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0600a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f55249a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f55250b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55251c;

        public c(k kVar, ViewGroup viewGroup, View view, int i2) {
            this.f55249a = viewGroup;
            this.f55250b = view;
            this.f55251c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.i.e.a((s) this.f55249a, this.f55250b, this.f55251c));
            }
        }
    }

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext, a2.Y2);
        this.q = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.m0.r.q.e eVar = new d.a.m0.r.q.e();
        eVar.f53670b = 1;
        eVar.f53676h = 1;
        n0Var.v(eVar);
        n0Var.w(1);
        n0Var.B("personalize_page");
        n0Var.A(1);
        n0Var.x(2);
        n0Var.b(32);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.o);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.f42913i);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.b1.f.a.d.a, d.a.c.k.e.a
    /* renamed from: m0 */
    public View X(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.O1 = F(i2) + 1;
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b().e() instanceof n0) {
            ((n0) threadCardViewHolder.b().e()).z(new c(this, viewGroup, view, i2));
        }
        threadCardViewHolder.f(z1Var);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }
}
