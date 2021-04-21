package d.b.j0.q0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends d.b.j0.q0.k<a2, ThreadCardViewHolder<a2>> implements d.b.j0.x.z, d.b.j0.q0.j2.d, d.b.j0.m.f {
    public int w;
    public String x;
    public d.b.j0.x.b0<a2> y;
    public NEGFeedBackView.b z;

    /* renamed from: d.b.j0.q0.n1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1489a extends d.b.j0.x.b0<a2> {
        public C1489a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            d.b.j0.x.t.b().d(true);
            d.b.j0.m.d.c().h("page_recommend", "show_");
            if (view == null || a2Var == null || StringUtils.isNull(a2Var.w1())) {
                return;
            }
            if (view.getId() == R.id.thread_card_root) {
                d.b.j0.q0.j2.c.j().g(d.b.j0.q0.j2.d.J0, a2Var, 13);
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof ThreadGodReplyLayout) {
                    d.b.j0.q0.j2.a.b(a2Var, 15, a.this.i, d.b.j0.q0.j2.d.J0, a.this.i0());
                    return;
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    d.b.j0.q0.j2.a.b(a2Var, 5, a.this.i, d.b.j0.q0.j2.d.J0, a.this.i0());
                    return;
                } else if (view.getId() == R.id.share_num_container) {
                    d.b.j0.q0.j2.a.b(a2Var, 14, a.this.i, d.b.j0.q0.j2.d.J0, a.this.i0());
                    return;
                } else if (view.getId() == R.id.img_agree) {
                    d.b.j0.q0.j2.a.b(a2Var, 12, a.this.i, d.b.j0.q0.j2.d.J0, a.this.i0());
                    return;
                } else if (view.getId() == R.id.img_disagree) {
                    d.b.j0.q0.j2.a.b(a2Var, 13, a.this.i, d.b.j0.q0.j2.d.J0, a.this.i0());
                    return;
                } else {
                    d.b.j0.q0.j2.a.b(a2Var, 1, a.this.i, d.b.j0.q0.j2.d.J0, a.this.i0());
                    return;
                }
            }
            d.b.j0.q0.j2.a.b(a2Var, 2, a.this.i, d.b.j0.q0.j2.d.J0, a.this.i0());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public b(a aVar) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(v0 v0Var, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, v0 v0Var) {
            if (arrayList == null || v0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", v0Var.c()).param("tid", v0Var.e()).param("nid", v0Var.d()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", v0Var.k).param("weight", v0Var.j).param("ab_tag", v0Var.o).param("extra", v0Var.l).param("card_type", v0Var.n).param(TiebaStatic.Params.OBJ_FLOOR, v0Var.p));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            TiebaStatic.log(new StatisticItem("c11973").param("fid", v0Var.c()).param("tid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.c.j.e.w {
        public c() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            a.this.B0(view, nVar);
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.w = 3;
        this.y = new C1489a();
        this.z = new b(this);
        this.o = tbPageContext;
    }

    public final void B0(View view, d.b.c.j.e.n nVar) {
        if ((nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
            a2 a2Var = (a2) nVar;
            a2Var.objType = 1;
            ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) a2Var, view.getContext(), 3, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C1072a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: C0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.t(this.i);
        dVar.v(this.o);
        bVar.o(dVar);
        bVar.n(new d.b.i.b(this.o.getPageActivity()));
        m0 m0Var = new m0(this.o.getPageActivity());
        d.b.i0.r.q.e eVar = new d.b.i0.r.q.e();
        eVar.f51506b = 2;
        eVar.f51512h = 2;
        m0Var.v(eVar);
        m0Var.w(2);
        m0Var.A(1);
        m0Var.x(3);
        bVar.m(m0Var);
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.i);
        c0(new c());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.q0.k, d.b.c.j.e.a
    /* renamed from: D0 */
    public View X(int i, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.X(i, view, viewGroup, a2Var, threadCardViewHolder);
        if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        d.b.j0.q0.j2.c.j().c(d.b.j0.q0.j2.d.J0, a2Var);
        threadCardViewHolder.b().setPage(this.x);
        threadCardViewHolder.b().q(i);
        if (this.w == 1) {
            threadCardViewHolder.p(true).u(this.z);
        }
        threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.f(a2Var);
        threadCardViewHolder.b().p(this.y);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    @Override // d.b.j0.x.z
    public void a(String str) {
    }

    @Override // d.b.j0.q0.j2.d
    public d.b.j0.q0.j2.b b() {
        return d.b.j0.q0.j2.d.J0;
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.x = str;
    }

    @Override // d.b.j0.x.z
    public void p(int i) {
        this.w = i;
    }

    @Override // d.b.j0.q0.k
    public void setFromCDN(boolean z) {
    }
}
