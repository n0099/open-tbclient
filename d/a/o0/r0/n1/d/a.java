package d.a.o0.r0.n1.d;

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
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends d.a.o0.r0.k<a2, ThreadCardViewHolder<a2>> implements d.a.o0.z.z, d.a.o0.r0.j2.d, d.a.o0.o.f {
    public int w;
    public String x;
    public d.a.o0.z.b0<a2> y;
    public NEGFeedBackView.b z;

    /* renamed from: d.a.o0.r0.n1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1575a extends d.a.o0.z.b0<a2> {
        public C1575a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            d.a.o0.z.t.b().d(true);
            d.a.o0.o.d.c().h("page_recommend", "show_");
            if (view == null || a2Var == null || StringUtils.isNull(a2Var.z1())) {
                return;
            }
            if (view.getId() == R.id.thread_card_root) {
                d.a.o0.r0.j2.c.j().g(d.a.o0.r0.j2.d.h0, a2Var, 13);
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof ThreadGodReplyLayout) {
                    d.a.o0.r0.j2.a.c(a2Var, 15, a.this.f43016i, d.a.o0.r0.j2.d.h0, a.this.g0());
                    return;
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.o0.r0.j2.a.c(a2Var, 5, a.this.f43016i, d.a.o0.r0.j2.d.h0, a.this.g0());
                    return;
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.o0.r0.j2.a.c(a2Var, 14, a.this.f43016i, d.a.o0.r0.j2.d.h0, a.this.g0());
                    return;
                } else if (view.getId() == R.id.img_agree) {
                    d.a.o0.r0.j2.a.c(a2Var, 12, a.this.f43016i, d.a.o0.r0.j2.d.h0, a.this.g0());
                    return;
                } else if (view.getId() == R.id.img_disagree) {
                    d.a.o0.r0.j2.a.c(a2Var, 13, a.this.f43016i, d.a.o0.r0.j2.d.h0, a.this.g0());
                    return;
                } else {
                    d.a.o0.r0.j2.a.c(a2Var, 1, a.this.f43016i, d.a.o0.r0.j2.d.h0, a.this.g0());
                    return;
                }
            }
            d.a.o0.r0.j2.a.c(a2Var, 2, a.this.f43016i, d.a.o0.r0.j2.d.h0, a.this.g0());
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
    public class c implements d.a.c.k.e.w {
        public c() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            a.this.B0(view, nVar);
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.w = 3;
        this.y = new C1575a();
        this.z = new b(this);
        this.o = tbPageContext;
    }

    public final void B0(View view, d.a.c.k.e.n nVar) {
        if ((nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
            a2 a2Var = (a2) nVar;
            a2Var.objType = 1;
            ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) a2Var, view.getContext(), 3, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0602a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: C0 */
    public ThreadCardViewHolder<a2> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.t(this.f43016i);
        dVar.v(this.o);
        bVar.o(dVar);
        bVar.n(new d.a.i.b(this.o.getPageActivity()));
        n0 n0Var = new n0(this.o.getPageActivity());
        d.a.n0.r.q.e eVar = new d.a.n0.r.q.e();
        eVar.f53777b = 2;
        eVar.f53783h = 2;
        n0Var.v(eVar);
        n0Var.w(2);
        n0Var.A(1);
        n0Var.x(3);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
        k.r(3);
        ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.f43016i);
        a0(new c());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    /* renamed from: D0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        super.X(i2, view, viewGroup, a2Var, threadCardViewHolder);
        if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
            return null;
        }
        d.a.o0.r0.j2.c.j().c(d.a.o0.r0.j2.d.h0, a2Var);
        threadCardViewHolder.b().setPage(this.x);
        threadCardViewHolder.b().q(i2);
        if (this.w == 1) {
            threadCardViewHolder.p(true).u(this.z);
        }
        threadCardViewHolder.t(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.f(a2Var);
        threadCardViewHolder.b().p(this.y);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.a();
    }

    @Override // d.a.o0.z.z
    public void a(String str) {
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.x = str;
    }

    @Override // d.a.o0.r0.j2.d
    public d.a.o0.r0.j2.b j() {
        return d.a.o0.r0.j2.d.h0;
    }

    @Override // d.a.o0.z.z
    public void r(int i2) {
        this.w = i2;
    }

    @Override // d.a.o0.r0.k
    public void setFromCDN(boolean z) {
    }
}
