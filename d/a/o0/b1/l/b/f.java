package d.a.o0.b1.l.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.o0.z.b0;
import d.a.o0.z.e0.k;
/* loaded from: classes4.dex */
public class f extends d.a.c.k.e.a<k, ThreadCardViewHolder<k>> {
    public TbPageContext m;
    public BdUniqueId n;
    public s o;
    public NEGFeedBackView.b p;
    public b0<k> q;

    /* loaded from: classes4.dex */
    public class a extends b0<k> {
        public a(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.i() == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                d.a.o0.b1.l.d.a.f(kVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (f.this.q != null) {
                    f.this.q.a(threadCardViewHolder.a(), kVar);
                }
                d.a.o0.b1.l.d.a.c(kVar, view.getContext(), 19, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a(this);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<k> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.m.getPageActivity(), false);
        n0 n0Var = new n0(this.m.getPageActivity());
        d.a.n0.r.q.e eVar = new d.a.n0.r.q.e();
        eVar.f53777b = 21;
        eVar.f53778c = 2;
        eVar.f53783h = 18;
        n0Var.v(eVar);
        n0Var.w(16);
        n0Var.A(10);
        n0Var.x(19);
        n0Var.b(32);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.o);
        k.r(19);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.n);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67302e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.p(false).u(this.p);
        threadCardViewHolder.q(false, Align.ALIGN_RIGHT_BOTTOM, this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }

    public void i0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    public void j0(BdUniqueId bdUniqueId) {
        this.n = bdUniqueId;
    }

    public void k0(s sVar) {
        this.o = sVar;
    }
}
