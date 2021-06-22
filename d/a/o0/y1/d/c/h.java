package d.a.o0.y1.d.c;

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
import d.a.n0.r.q.a2;
import d.a.n0.r.q.z1;
import d.a.o0.z.b0;
import d.a.o0.z.t;
/* loaded from: classes5.dex */
public class h extends d.a.o0.y1.d.c.a<z1, ThreadCardViewHolder<a2>> {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public s p;
    public b0<z1> q;

    /* loaded from: classes5.dex */
    public class a extends b0<z1> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, z1 z1Var) {
            if (z1Var == null) {
                return;
            }
            t.b().d(true);
            h.this.l0(view, z1Var.w);
        }
    }

    /* loaded from: classes5.dex */
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
                if (h.this.q != null) {
                    h.this.q.a(threadCardViewHolder.a(), z1Var);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) a2Var, view.getContext(), 17, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f67216a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f67217b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f67218c;

        public c(h hVar, ViewGroup viewGroup, View view, int i2) {
            this.f67216a = viewGroup;
            this.f67217b = view;
            this.f67218c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.i.e.a((s) this.f67216a, this.f67217b, this.f67218c));
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity(), false);
        n0 n0Var = new n0(this.o.getPageActivity());
        d.a.n0.r.q.e eVar = new d.a.n0.r.q.e();
        eVar.f53777b = 22;
        eVar.f53783h = 19;
        n0Var.v(eVar);
        n0Var.w(18);
        n0Var.B("personalize_page");
        n0Var.A(18);
        n0Var.x(17);
        n0Var.b(32);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.p);
        k.r(17);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.n);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
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
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        d.a.o0.y1.c.c(this, z1Var);
        return threadCardViewHolder.a();
    }

    public final void l0(View view, a2 a2Var) {
        d.a.o0.y1.c.b(this, a2Var);
    }

    public void m0(s sVar) {
        this.p = sVar;
    }
}
