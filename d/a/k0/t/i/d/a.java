package d.a.k0.t.i.d;

import android.view.View;
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
import d.a.c.e.p.l;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f61702a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f61703b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f61704c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f61705d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f61706e = new C1646a(this);

    /* renamed from: d.a.k0.t.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1646a implements NEGFeedBackView.b {
        public C1646a(a aVar) {
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
            if ("ala_frs_demo_hell_live_feed_back_type".equals(v0Var.h())) {
                TiebaStatic.log(new StatisticItem("c12803").param("tid", v0Var.e()));
            } else if ("ala_frs_stage_live_feed_back_type".equals(v0Var.h())) {
                TiebaStatic.log(new StatisticItem("c12807").param("tid", v0Var.e()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            if (v0Var == null) {
                return;
            }
            if ("ala_frs_demo_hell_live_feed_back_type".equals(v0Var.h())) {
                TiebaStatic.log(new StatisticItem("c12802").param("tid", v0Var.e()));
            } else if ("ala_frs_stage_live_feed_back_type".equals(v0Var.h())) {
                TiebaStatic.log(new StatisticItem("c12806").param("tid", v0Var.e()));
            }
        }
    }

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.f61703b = tbPageContext;
        this.f61704c = viewGroup;
    }

    public View a() {
        return this.f61702a;
    }

    public void b(a2 a2Var, String str) {
        if (a2Var == null || a2Var.q1() == null || this.f61703b == null || this.f61704c == null) {
            return;
        }
        int i2 = 0;
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (TbadkCoreApplication.isLogin() && a2Var.q1().dislikeInfo != null && !z && a2Var.q1().dislikeInfo.size() > 0) {
            if (this.f61702a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f61703b);
                this.f61702a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f61705d);
                this.f61702a.setId(R.id.negative_feedback_view);
                this.f61702a.setDefaultReasonArray(new String[]{this.f61703b.getString(R.string.bad_quality), "", ""});
                this.f61702a.setEventCallback(this.f61706e);
                this.f61702a.n(this.f61704c, l.g(this.f61703b.getPageActivity(), R.dimen.tbds120), l.g(this.f61703b.getPageActivity(), R.dimen.tbds20));
                this.f61702a.q();
            }
            if (this.f61702a.getVisibility() != 0) {
                this.f61702a.setVisibility(0);
            }
            v0 v0Var = new v0();
            v0Var.n(a2Var.x1());
            v0Var.k(a2Var.c0());
            v0Var.m(a2Var.L0());
            v0Var.q(str);
            v0Var.j(a2Var.q1().dislikeInfo);
            this.f61702a.setData(v0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f61702a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f61702a.setVisibility(8);
            }
            i2 = l.g(this.f61703b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f61704c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61704c.getLayoutParams();
            layoutParams.rightMargin = i2;
            this.f61704c.setLayoutParams(layoutParams);
        }
        if (this.f61704c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f61704c.getLayoutParams();
            layoutParams2.rightMargin = i2;
            this.f61704c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f61702a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView = this.f61702a;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.q();
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f61705d = bdUniqueId;
    }
}
