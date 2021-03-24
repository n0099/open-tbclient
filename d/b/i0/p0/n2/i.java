package d.b.i0.p0.n2;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f58188a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f58189b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f58190c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f58191d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f58192e = new a(this);

    /* loaded from: classes4.dex */
    public class a implements NEGFeedBackView.b {
        public a(i iVar) {
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

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.f58189b = tbPageContext;
        this.f58190c = viewGroup;
    }

    public void a(a2 a2Var) {
        if (a2Var == null || this.f58189b == null || this.f58190c == null) {
            return;
        }
        int i = 0;
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (a2Var.s2() && a2Var.b0() != null && !z) {
            if (this.f58188a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f58189b);
                this.f58188a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f58191d);
                this.f58188a.setId(R.id.negative_feedback_view);
                this.f58188a.setDefaultReasonArray(new String[]{this.f58189b.getString(R.string.bad_quality), "", ""});
                this.f58188a.setEventCallback(this.f58192e);
                this.f58188a.g(this.f58190c, d.b.b.e.p.l.g(this.f58189b.getPageActivity(), R.dimen.tbds120), 0);
                this.f58188a.q();
            }
            if (this.f58188a.getVisibility() != 0) {
                this.f58188a.setVisibility(0);
            }
            v0 v0Var = new v0();
            v0Var.n(a2Var.w1());
            v0Var.k(a2Var.c0());
            v0Var.m(a2Var.L0());
            v0Var.j(a2Var.b0());
            v0Var.f50906g = a2Var.e1;
            this.f58188a.setData(v0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f58188a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f58188a.setVisibility(8);
            }
            i = d.b.b.e.p.l.g(this.f58189b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f58190c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f58190c.getLayoutParams();
            layoutParams.rightMargin = i;
            this.f58190c.setLayoutParams(layoutParams);
        }
        if (this.f58190c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f58190c.getLayoutParams();
            layoutParams2.rightMargin = i;
            this.f58190c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f58188a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public boolean b() {
        NEGFeedBackView nEGFeedBackView = this.f58188a;
        return nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0;
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView = this.f58188a;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.q();
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f58191d = bdUniqueId;
    }
}
