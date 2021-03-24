package d.b.i0.z0.k.b;

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
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import d.b.b.j.e.w;
import d.b.i.d;
import d.b.i.k0;
import d.b.i.u0.a;
import d.b.i0.x.b0;
import d.b.i0.x.e0.k;
/* loaded from: classes4.dex */
public class g extends d.b.b.j.e.a<k, ThreadCardViewHolder<k>> {
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
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.n() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.user_avatar) {
                    d.b.i0.z0.k.d.a.e(kVar);
                    return;
                } else if (id == R.id.user_name) {
                    d.b.i0.z0.k.d.a.e(kVar);
                    return;
                } else {
                    return;
                }
            }
            d.b.i0.z0.k.d.a.f(kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(g gVar) {
        }

        @Override // d.b.i.d.b
        public void a(d.b.h0.r.q.a aVar, View view) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (g.this.q != null) {
                    g.this.q.a(threadCardViewHolder.a(), kVar);
                }
                d.b.i0.z0.k.d.a.c(kVar, view.getContext(), 19, false, d.b.i.e.a((s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a(this);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder<k> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.m.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.m.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new b(this));
        dVar.v(this.m);
        bVar.o(dVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.o);
        k.r(19);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.n);
        c0(new c());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62196e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.m(kVar.f62196e.w(), null);
        threadCardViewHolder.q(true, Align.ALIGN_RIGHT_TOP, this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }

    public void l0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    public void m0(BdUniqueId bdUniqueId) {
        this.n = bdUniqueId;
    }

    public void n0(s sVar) {
        this.o = sVar;
    }
}
