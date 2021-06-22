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
import d.a.i.d;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.o0.z.b0;
import d.a.o0.z.e0.k;
/* loaded from: classes4.dex */
public class g extends d.a.c.k.e.a<k, ThreadCardViewHolder<k>> {
    public TbPageContext m;
    public BdUniqueId n;
    public s o;
    public NEGFeedBackView.b p;
    public b0<k> q;

    /* loaded from: classes4.dex */
    public class a extends b0<k> {
        public a(g gVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.i() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.user_avatar) {
                    d.a.o0.b1.l.d.a.e(kVar);
                    return;
                } else if (id == R.id.user_name) {
                    d.a.o0.b1.l.d.a.e(kVar);
                    return;
                } else {
                    return;
                }
            }
            d.a.o0.b1.l.d.a.f(kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(g gVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.n0.r.q.a aVar, View view) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (g.this.q != null) {
                    g.this.q.a(threadCardViewHolder.a(), kVar);
                }
                d.a.o0.b1.l.d.a.c(kVar, view.getContext(), 19, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a(this);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<k> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.m.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.m.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new b(this));
        dVar.v(this.m);
        bVar.o(dVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.o);
        k.r(19);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.n);
        a0(new c());
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
        threadCardViewHolder.m(kVar.f67302e.w(), null);
        threadCardViewHolder.q(true, Align.ALIGN_RIGHT_TOP, this.p);
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
