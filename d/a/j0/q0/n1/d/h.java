package d.a.j0.q0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.i.a;
import d.a.i.d;
import d.a.i.f0;
import d.a.i.k0;
import d.a.i.m0;
import d.a.i.r0;
import d.a.i.u0.a;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
import d.a.i0.r.q.z1;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class h extends d.a.j0.q0.k<z1, ThreadCardViewHolder<a2>> implements d.a.j0.x.z, d.a.j0.q0.j2.d, d.a.j0.m.f {
    public boolean A;
    public int B;
    public d.a.j0.q0.j2.b C;
    public d.a.j0.x.b0<a2> D;
    public NEGFeedBackView.b E;
    public TbPageContext<?> w;
    public HashSet<String> x;
    public String y;
    public String z;

    /* loaded from: classes4.dex */
    public class a extends d.a.j0.x.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            if ("c13010".equals(h.this.z)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", a2Var.c0()).param("tid", a2Var.w1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof ThreadGodReplyLayout) {
                    d.a.j0.q0.j2.a.c(a2Var, 15, h.this.f40323i, h.this.C, h.this.f0());
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.j0.q0.j2.a.c(a2Var, 5, h.this.f40323i, h.this.C, h.this.f0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.j0.q0.j2.a.c(a2Var, 14, h.this.f40323i, h.this.C, h.this.f0());
                } else if (view.getId() == R.id.img_agree) {
                    d.a.j0.q0.j2.a.c(a2Var, 12, h.this.f40323i, h.this.C, h.this.f0());
                } else if (view.getId() == R.id.img_disagree) {
                    d.a.j0.q0.j2.a.c(a2Var, 13, h.this.f40323i, h.this.C, h.this.f0());
                } else {
                    d.a.j0.q0.j2.a.c(a2Var, 1, h.this.f40323i, h.this.C, h.this.f0());
                }
            } else {
                d.a.j0.q0.j2.a.c(a2Var, 2, h.this.f40323i, h.this.C, h.this.f0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.a.j0.q0.j2.c.j().g(h.this.C, a2Var, 2);
            } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                d.a.j0.q0.j2.c.j().g(h.this.C, a2Var, 1);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof OriginalThreadCardView) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                    statisticItem.param("obj_type", "3");
                    statisticItem.param("tid", a2Var.w1());
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
            statisticItem2.param("obj_type", "1");
            statisticItem2.param("tid", a2Var.w1());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public b(h hVar) {
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
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(arrayList.get(i2) + ",");
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
        public c(h hVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.i0.r.q.a aVar, View view) {
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
    public class d implements a.InterfaceC1009a {
        public d() {
        }

        @Override // d.a.i.a.InterfaceC1009a
        public void a(d.a.i0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
                return;
            }
            d.a.i0.z0.t.e(3, h.this.f40319e, aVar.m(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, "frs", "");
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.InterfaceC1009a {
        public e() {
        }

        @Override // d.a.i.a.InterfaceC1009a
        public void a(d.a.i0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
                return;
            }
            d.a.i0.z0.t.e(3, h.this.f40319e, aVar.m(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, "frs", "");
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.i.v0.a {
        public f() {
        }

        @Override // d.a.i.v0.a
        public void a(d.a.i0.r.q.a aVar) {
            boolean z;
            if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
                return;
            }
            if (aVar.m().r1.r != null) {
                z = aVar.m().r1.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            d.a.i0.z0.t.d(3, z, h.this.f40319e, aVar.m(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, "frs", "");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.c.j.e.w {
        public g() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (h.this.D != null) {
                    h.this.D.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) a2Var, view.getContext(), h.this.B, false);
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.A = true;
        this.B = 3;
        this.C = new d.a.j0.q0.j2.b();
        this.D = new a();
        this.E = new b(this);
        this.w = tbPageContext;
        this.f40323i = bdUniqueId2;
    }

    public final void H0(a2 a2Var) {
        if (this.x == null) {
            this.x = new HashSet<>();
        }
        d.a.j0.q0.j2.c.j().d(a2Var, this.x);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: I0 */
    public ThreadCardViewHolder<a2> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.w.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.w.getPageActivity());
        dVar.b(4280);
        dVar.t(this.f40323i);
        dVar.s(new c(this));
        bVar.o(dVar);
        f0 f0Var = new f0(this.w);
        f0Var.n(Boolean.FALSE);
        f0Var.v("frs");
        if (this.B == 502) {
            f0Var.x(false);
        } else {
            f0Var.x(true);
        }
        bVar.l().d(d.a.c.e.p.l.g(this.f40319e, R.dimen.tbds38));
        bVar.n(f0Var);
        f0 f0Var2 = new f0(this.w);
        f0Var2.n(Boolean.TRUE);
        f0Var2.v("frs");
        if (this.B == 502) {
            f0Var2.x(false);
        } else {
            f0Var2.x(true);
        }
        f0Var2.y(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        bVar.h(f0Var2);
        f0Var2.w(new d());
        r0 r0Var = new r0(this.w.getPageActivity());
        r0Var.n(Boolean.TRUE);
        r0Var.v("frs");
        r0Var.w(new e());
        r0Var.x(new f());
        bVar.h(r0Var);
        d.a.i.n nVar = new d.a.i.n(this.w.getPageActivity());
        nVar.x(this.A);
        nVar.w("frs");
        bVar.h(nVar);
        m0 m0Var = new m0(this.w.getPageActivity());
        d.a.i0.r.q.e eVar = new d.a.i0.r.q.e();
        eVar.f49131b = 2;
        eVar.f49137h = 2;
        m0Var.v(eVar);
        m0Var.w(2);
        m0Var.A(3);
        m0Var.x(2);
        m0Var.b(16);
        bVar.m(m0Var);
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
        k.r(2);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.f40323i);
        Z(new g());
        threadCardViewHolder.m();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: J0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        if (threadCardViewHolder.b() instanceof d.a.j0.m.e) {
            threadCardViewHolder.b().setPage(this.y);
        }
        threadCardViewHolder.b().q(i2);
        super.W(i2, view, viewGroup, z1Var, threadCardViewHolder);
        d.a.j0.q0.j.g(threadCardViewHolder.b().e(), this.n);
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
            z1Var.w.i4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
        }
        boolean z = (z1Var.w.T() == null || z1Var.w.T().getUserId() == null || !z1Var.w.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (z1Var.w.t2() && z1Var.w.b0() != null && !z) {
            threadCardViewHolder.o(true).u(this.E);
        }
        threadCardViewHolder.r();
        if (threadCardViewHolder.b().e() != null) {
            threadCardViewHolder.b().e().b(32);
        }
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.w, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.D);
        if (this.C != null) {
            FrsViewData frsViewData2 = this.n;
            z1Var.w.M1 = (z1Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
        }
        d.a.j0.q0.j2.c.j().c(this.C, z1Var.w);
        H0(z1Var.w);
        z1Var.w.y4();
        d.a.j0.q0.j2.a.j(z1Var.w, this.f40323i, this.C, f0());
        a2 a2Var = z1Var.w;
        if (a2Var != null) {
            a2Var.y4();
        }
        return threadCardViewHolder.a();
    }

    public void K0(boolean z) {
    }

    @Override // d.a.j0.x.z
    public void a(String str) {
    }

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.y = str;
    }

    @Override // d.a.j0.q0.j2.d
    public d.a.j0.q0.j2.b i() {
        return this.C;
    }

    @Override // d.a.j0.x.z
    public void q(int i2) {
        this.B = i2;
    }

    @Override // d.a.j0.q0.k, d.a.j0.x.y
    public void setFrom(String str) {
        this.z = str;
    }

    @Override // d.a.j0.q0.k
    public void setFromCDN(boolean z) {
        this.A = z;
    }
}
