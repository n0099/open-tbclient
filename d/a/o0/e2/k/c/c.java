package d.a.o0.e2.k.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.i.l0;
import d.a.i.v;
import d.a.i.v0.a;
import d.a.o0.z.b0;
import d.a.o0.z.e0.k;
/* loaded from: classes5.dex */
public class c extends d.a.c.k.e.a<k, ThreadCardViewHolder<k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public boolean o;
    public s p;
    public b0<k> q;

    /* loaded from: classes5.dex */
    public class a extends b0<k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.i() == null || StringUtils.isNull(kVar.i().z1())) {
                return;
            }
            c.this.j0(view, kVar);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (c.this.q != null) {
                    c.this.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) kVar, view.getContext(), 0, false);
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.o = true;
        this.q = new a();
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<k> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        v vVar = new v(this.n.getPageActivity());
        vVar.r("pb");
        vVar.s(this.o);
        bVar.n(vVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
        k.r(0);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67302e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }

    public final void j0(View view, k kVar) {
        if (view.getId() == R.id.thread_card_root) {
            d.a.o0.e2.m.a.i(kVar, 1);
        } else if (view instanceof TbImageView) {
            d.a.o0.e2.m.a.i(kVar, 3);
        } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
            d.a.o0.e2.m.a.i(kVar, 1);
        }
    }

    public void k0(s sVar) {
        this.p = sVar;
    }
}
