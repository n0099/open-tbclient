package d.a.o0.b1.c.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.o0.z.b0;
/* loaded from: classes4.dex */
public class h extends d.a.c.k.e.a<d.a.o0.z.e0.k, ThreadCardViewHolder<d.a.o0.z.e0.k>> implements d.a.o0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public d.a.c.k.e.s q;
    public b0<d.a.o0.z.e0.k> r;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.o0.z.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.o0.z.e0.k kVar) {
            if (view == null || kVar == null || kVar.i() == null || StringUtils.isNull(kVar.i().z1())) {
                return;
            }
            h.this.j0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.k.e.w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.o0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.o0.z.e0.k kVar = (d.a.o0.z.e0.k) nVar;
                kVar.k = 1;
                if (h.this.r != null) {
                    h.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.r = new a();
        this.n = tbPageContext;
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.y yVar = new d.a.i.y(this.n.getPageActivity());
        yVar.q(ImageViewerConfig.FROM_CONCERN);
        yVar.r(this.p);
        bVar.n(yVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        k.r(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.z.e0.k kVar, ThreadCardViewHolder<d.a.o0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67302e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        d.a.o0.z.t.b().a(kVar.A("c12351"));
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.a.o0.o.e) {
            threadCardViewHolder.b().setPage(this.o);
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        d.a.i.y yVar = (d.a.i.y) threadCardViewHolder.b().f();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.j.f4483h.getLayoutParams();
        layoutParams.width = kVar.o;
        layoutParams.height = kVar.p;
        if (yVar.j.f4483h.getVisibility() != 8) {
            yVar.j.f4483h.setLayoutParams(layoutParams);
        }
        return threadCardViewHolder.a();
    }

    public final void j0(View view, d.a.o0.z.e0.k kVar) {
        if (view.getId() == R.id.thread_card_root) {
            d.a.o0.b1.c.c.b(view, kVar, 2);
        } else if (view instanceof TbImageView) {
            d.a.o0.b1.c.c.b(view, kVar, 3);
        } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
            d.a.o0.b1.c.c.b(view, kVar, 2);
        }
    }

    public void k0(d.a.c.k.e.s sVar) {
        this.q = sVar;
    }
}
