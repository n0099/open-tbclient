package d.a.n0.b1.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.i.d;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.n0.z.b0;
import d.a.n0.z.e0.k;
/* loaded from: classes4.dex */
public class f extends d.a.c.k.e.a<k, ThreadCardViewHolder<k>> {
    public TbPageContext m;
    public BdUniqueId n;
    public s o;
    public int p;
    public b0<k> q;

    /* loaded from: classes4.dex */
    public class a extends b0<k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            int id = view.getId();
            if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                d.a.n0.b1.e.e.a.e(kVar, f.this.p);
            } else if (id == R.id.user_avatar) {
                d.a.n0.b1.e.e.a.f(kVar, f.this.p);
            } else if (id == R.id.user_name) {
                d.a.n0.b1.e.e.a.f(kVar, f.this.p);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(f fVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.m0.r.q.a aVar, View view) {
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
                if (f.this.q != null) {
                    f.this.q.a(threadCardViewHolder.a(), kVar);
                }
                d.a.n0.b1.e.e.a.b(kVar, view.getContext(), 18, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0600a(1));
            }
        }
    }

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<k> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.m.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.m.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new b(this));
        bVar.o(dVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.o);
        k.r(18);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.n);
        a0(new c());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67177e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }

    public void j0(int i2) {
        this.p = i2;
    }

    public void k0(BdUniqueId bdUniqueId) {
        this.n = bdUniqueId;
    }

    public void l0(s sVar) {
        this.o = sVar;
    }
}
