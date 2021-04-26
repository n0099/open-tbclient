package d.a.j0.q0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.i.k0;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
/* loaded from: classes4.dex */
public class l extends d.a.j0.q0.k<z1, ThreadCardViewHolder<a2>> implements d.a.j0.x.z, d.a.j0.q0.j2.d, d.a.j0.m.f, d.a.j0.x.a0 {
    public TbPageContext<?> w;
    public String x;
    public int y;
    public d.a.j0.q0.j2.b z;

    /* loaded from: classes4.dex */
    public class a implements d.a.c.j.e.w {
        public a() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            BdToast.i(l.this.f40319e, l.this.f40319e.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.y = 3;
        this.z = new d.a.j0.q0.j2.b();
        this.w = tbPageContext;
    }

    @Override // d.a.j0.x.z
    public void a(String str) {
    }

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.x = str;
    }

    @Override // d.a.j0.q0.j2.d
    public d.a.j0.q0.j2.b i() {
        return this.z;
    }

    @Override // d.a.j0.x.a0
    public void k(boolean z) {
    }

    @Override // d.a.j0.x.z
    public void q(int i2) {
        this.y = i2;
    }

    @Override // d.a.j0.q0.k, d.a.j0.x.y
    public void setFrom(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: v0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.w.getPageActivity(), false);
        d.a.i.i iVar = new d.a.i.i(this.w.getPageActivity());
        if (this.y == 502) {
            iVar.p(false);
        } else {
            iVar.p(true);
        }
        bVar.n(iVar);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q));
        threadCardViewHolder.j(this.f40323i);
        Z(new a());
        threadCardViewHolder.n(false);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: w0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        if (threadCardViewHolder == null) {
            return null;
        }
        if (z1Var == null) {
            return threadCardViewHolder.a();
        }
        if (threadCardViewHolder.b() instanceof d.a.j0.m.e) {
            threadCardViewHolder.b().setPage(this.x);
        }
        super.W(i2, view, viewGroup, z1Var, threadCardViewHolder);
        d.a.j0.q0.j.g(threadCardViewHolder.b().e(), this.n);
        threadCardViewHolder.b().q(i2);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.i4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.w, TbadkCoreApplication.getInst().getSkinType());
        z1Var.w.y4();
        return threadCardViewHolder.a();
    }
}
