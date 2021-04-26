package d.a.j0.d2.k.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.k0;
import d.a.i.u0.a;
import d.a.i.y;
import d.a.j0.x.b0;
import d.a.j0.x.e0.k;
/* loaded from: classes3.dex */
public class d extends d.a.c.j.e.a<k, ThreadCardViewHolder<k>> {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public boolean o;
    public s p;
    public b0<k> q;

    /* loaded from: classes3.dex */
    public class a extends b0<k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().w1())) {
                return;
            }
            d.this.i0(view, kVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (d.this.q != null) {
                    d.this.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) kVar, view.getContext(), 0, false);
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.o = true;
        this.q = new a();
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<k> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        y yVar = new y(this.n.getPageActivity());
        yVar.q("pb");
        yVar.r(this.o);
        bVar.n(yVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
        k.r(0);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.m);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62455e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        y yVar = (y) threadCardViewHolder.b().f();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.j.f4610h.getLayoutParams();
        layoutParams.width = kVar.o;
        layoutParams.height = kVar.p;
        if (yVar.j.f4610h.getVisibility() != 8) {
            yVar.j.f4610h.setLayoutParams(layoutParams);
        }
        return threadCardViewHolder.a();
    }

    public final void i0(View view, k kVar) {
        if (view.getId() == R.id.thread_card_root) {
            d.a.j0.d2.m.a.i(kVar, 1);
        } else if (view instanceof TbImageView) {
            d.a.j0.d2.m.a.i(kVar, 3);
        } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
            d.a.j0.d2.m.a.i(kVar, 1);
        }
    }

    public void j0(s sVar) {
        this.p = sVar;
    }
}
