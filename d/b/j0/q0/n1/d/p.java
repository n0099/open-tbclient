package d.b.j0.q0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.i.d;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import d.b.i0.r.q.z1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class p extends d.b.j0.q0.k<z1, ThreadCardViewHolder<a2>> implements d.b.j0.x.z, d.b.j0.q0.j2.d, d.b.j0.m.f {
    public d.b.j0.q0.j2.b A;
    public d.b.j0.x.b0<a2> B;
    public NEGFeedBackView.b C;
    public TbPageContext<?> w;
    public String x;
    public boolean y;
    public int z;

    /* loaded from: classes4.dex */
    public class a extends d.b.j0.x.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.b.j0.q0.j2.a.b(a2Var, 5, p.this.i, p.this.A, p.this.i0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.b.j0.q0.j2.a.b(a2Var, 14, p.this.i, p.this.A, p.this.i0());
                } else if (view.getId() == R.id.img_agree) {
                    d.b.j0.q0.j2.a.b(a2Var, 12, p.this.i, p.this.A, p.this.i0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.b.j0.q0.j2.a.b(a2Var, 13, p.this.i, p.this.A, p.this.i0());
                } else if (view instanceof TbImageView) {
                    if (p.this.B.f64180a instanceof Boolean) {
                        if (((Boolean) p.this.B.f64180a).booleanValue()) {
                            d.b.j0.q0.j2.a.b(a2Var, 1, p.this.i, p.this.A, p.this.i0());
                        } else {
                            d.b.j0.q0.j2.a.b(a2Var, 3, p.this.i, p.this.A, p.this.i0());
                        }
                    }
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.b.j0.q0.j2.a.b(a2Var, 15, p.this.i, p.this.A, p.this.i0());
                } else {
                    d.b.j0.q0.j2.a.b(a2Var, 1, p.this.i, p.this.A, p.this.i0());
                }
            } else {
                d.b.j0.q0.j2.a.b(a2Var, 2, p.this.i, p.this.A, p.this.i0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.b.j0.q0.j2.c.j().g(p.this.A, a2Var, 2);
            } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                d.b.j0.q0.j2.c.j().g(p.this.A, a2Var, 7);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public b(p pVar) {
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
    public class c implements d.b {
        public c(p pVar) {
        }

        @Override // d.b.i.d.b
        public void a(d.b.i0.r.q.a aVar, View view) {
            if (aVar != null) {
                if (view.getId() == R.id.user_name) {
                    aVar.objType = 3;
                } else if (view.getId() == R.id.user_avatar) {
                    aVar.objType = 4;
                } else {
                    aVar.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b.c.j.e.w {
        public d() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (p.this.B != null) {
                    p.this.B.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) a2Var, view.getContext(), p.this.z, false);
                threadCardViewHolder.b().o(new a.C1072a(1));
            }
        }
    }

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.y = true;
        this.z = 3;
        this.A = new d.b.j0.q0.j2.b();
        this.B = new a();
        this.C = new b(this);
        this.w = tbPageContext;
        this.i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: F0 */
    public ThreadCardViewHolder<a2> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.w.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.w.getPageActivity());
        dVar.t(this.i);
        dVar.b(4272);
        dVar.s(new c(this));
        bVar.o(dVar);
        bVar.n(new d.b.i.t(this.w.getPageActivity()));
        d.b.i.n nVar = new d.b.i.n(this.w.getPageActivity());
        nVar.x(this.y);
        nVar.w("frs");
        bVar.h(nVar);
        m0 m0Var = new m0(this.w.getPageActivity());
        d.b.i0.r.q.e eVar = new d.b.i0.r.q.e();
        eVar.f51506b = 2;
        eVar.f51512h = 2;
        m0Var.v(eVar);
        m0Var.w(2);
        m0Var.A(this.z);
        m0Var.x(this.z);
        m0Var.b(48);
        bVar.m(m0Var);
        k0 j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
        j.r(this.z);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(j);
        threadCardViewHolder.k(this.i);
        c0(new d());
        threadCardViewHolder.n();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.q0.k, d.b.c.j.e.a
    /* renamed from: G0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
            return null;
        }
        super.X(i, view, viewGroup, z1Var, threadCardViewHolder);
        if (threadCardViewHolder.b() instanceof d.b.j0.m.e) {
            threadCardViewHolder.b().setPage(this.x);
        }
        d.b.j0.q0.j.g(threadCardViewHolder.b().e(), this.n);
        boolean z = (z1Var.w.T() == null || z1Var.w.T().getUserId() == null || !z1Var.w.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (z1Var.w.t2() && z1Var.w.b0() != null && !z) {
            d.b.i.b0 p = threadCardViewHolder.p(true);
            p.u(this.C);
            p.a(z1Var.w.g());
        }
        threadCardViewHolder.s();
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.j(this.B);
        threadCardViewHolder.b().onChangeSkinType(this.w, TbadkCoreApplication.getInst().getSkinType());
        if (this.A != null) {
            FrsViewData frsViewData = this.n;
            z1Var.w.M1 = (z1Var.position + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
        }
        d.b.j0.q0.j2.c.j().c(this.A, z1Var.w);
        d.b.j0.q0.j2.a.i(z1Var.w, this.i, this.A, i0());
        if (z1Var != null) {
            z1Var.w.y4();
        }
        return threadCardViewHolder.a();
    }

    @Override // d.b.j0.x.z
    public void a(String str) {
    }

    @Override // d.b.j0.q0.j2.d
    public d.b.j0.q0.j2.b b() {
        return this.A;
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.x = str;
    }

    @Override // d.b.j0.x.z
    public void p(int i) {
        this.z = i;
    }

    @Override // d.b.j0.q0.k
    public void setFromCDN(boolean z) {
        this.y = z;
    }
}
