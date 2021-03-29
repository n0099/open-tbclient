package d.b.i0.p0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.h0.r.q.a2;
import d.b.i.k0;
import d.b.i.m0;
/* loaded from: classes4.dex */
public class f extends d.b.i0.p0.k<a2, ThreadCardViewHolder<a2>> implements d.b.i0.x.z, d.b.i0.p0.j2.d, d.b.i0.m.f, d.b.i0.x.a0 {
    public int A;
    public boolean B;
    public d.b.i0.p0.j2.b C;
    public d.b.i0.x.b0<a2> D;
    public TbPageContext<?> w;
    public String x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends d.b.i0.x.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            BdToast.i(f.this.f42358e, f.this.f42358e.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.b.j.e.w {
        public b() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            BdToast.i(f.this.f42358e, f.this.f42358e.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.y = false;
        this.z = false;
        this.A = 3;
        this.C = new d.b.i0.p0.j2.b();
        this.D = new a();
        this.w = tbPageContext;
    }

    public void A0(boolean z) {
        this.B = z;
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
    }

    @Override // d.b.i0.p0.j2.d
    public d.b.i0.p0.j2.b b() {
        return this.C;
    }

    @Override // d.b.i0.x.a0
    public void d(boolean z) {
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.x = str;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
        this.A = i;
    }

    @Override // d.b.i0.p0.k
    public void setFromCDN(boolean z) {
        this.y = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: x0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.w.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.w.getPageActivity());
        dVar.b(4272);
        dVar.t(this.i);
        bVar.o(dVar);
        d.b.i.i iVar = new d.b.i.i(this.w.getPageActivity());
        if (this.A == 502) {
            iVar.p(false);
        } else {
            iVar.p(true);
        }
        bVar.n(iVar);
        if (this.B) {
            bVar.h(new d.b.i.s(this.w.getPageActivity()));
        }
        bVar.h(new d.b.i.g0(this.w.getPageActivity()));
        bVar.h(new d.b.i.a0(this.w.getPageActivity()));
        bVar.h(new d.b.i.l(this.w.getPageActivity()));
        d.b.i.n nVar = new d.b.i.n(this.w.getPageActivity());
        nVar.x(this.y);
        nVar.w("frs");
        bVar.h(nVar);
        m0 m0Var = new m0(this.w.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f50763b = 2;
        eVar.f50764c = 2;
        eVar.f50769h = 2;
        m0Var.v(eVar);
        m0Var.w(2);
        m0Var.A(1);
        m0Var.x(this.A);
        m0Var.b(Opcodes.ARETURN);
        if (this.z) {
            m0Var.c(4);
        }
        bVar.m(m0Var);
        bVar.l().d(d.b.b.e.p.l.g(this.f42358e, R.dimen.tbds28));
        d.b.i.k0 i = bVar.i();
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i);
        threadCardViewHolder.k(this.i);
        i.p(this.D);
        i.r(this.A);
        c0(new b());
        threadCardViewHolder.n();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: y0 */
    public View X(int i, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder threadCardViewHolder) {
        if (threadCardViewHolder == null) {
            return null;
        }
        if (a2Var == null) {
            return threadCardViewHolder.a();
        }
        if (threadCardViewHolder.b() instanceof d.b.i0.m.e) {
            threadCardViewHolder.b().setPage(this.x);
        }
        super.X(i, view, viewGroup, a2Var, threadCardViewHolder);
        d.b.i0.p0.j.g(threadCardViewHolder.b().e(), this.n);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            a2Var.h4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        if (!a2Var.S1()) {
            threadCardViewHolder.s();
        }
        threadCardViewHolder.f(a2Var);
        threadCardViewHolder.b().onChangeSkinType(this.w, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.D);
        a2Var.x4();
        return threadCardViewHolder.a();
    }

    public void z0(boolean z) {
        this.z = z;
    }
}
