package d.b.i0.t.i.d;

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
import d.b.c.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f62359a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f62360b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f62361c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f62362d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f62363e = new C1618a(this);

    /* renamed from: d.b.i0.t.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1618a implements NEGFeedBackView.b {
        public C1618a(a aVar) {
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
        this.f62360b = tbPageContext;
        this.f62361c = viewGroup;
    }

    public View a() {
        return this.f62359a;
    }

    public void b(a2 a2Var, String str) {
        if (a2Var == null || a2Var.q1() == null || this.f62360b == null || this.f62361c == null) {
            return;
        }
        int i = 0;
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (TbadkCoreApplication.isLogin() && a2Var.q1().dislikeInfo != null && !z && a2Var.q1().dislikeInfo.size() > 0) {
            if (this.f62359a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f62360b);
                this.f62359a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f62362d);
                this.f62359a.setId(R.id.negative_feedback_view);
                this.f62359a.setDefaultReasonArray(new String[]{this.f62360b.getString(R.string.bad_quality), "", ""});
                this.f62359a.setEventCallback(this.f62363e);
                this.f62359a.n(this.f62361c, l.g(this.f62360b.getPageActivity(), R.dimen.tbds120), l.g(this.f62360b.getPageActivity(), R.dimen.tbds20));
                this.f62359a.q();
            }
            if (this.f62359a.getVisibility() != 0) {
                this.f62359a.setVisibility(0);
            }
            v0 v0Var = new v0();
            v0Var.n(a2Var.w1());
            v0Var.k(a2Var.c0());
            v0Var.m(a2Var.L0());
            v0Var.q(str);
            v0Var.j(a2Var.q1().dislikeInfo);
            this.f62359a.setData(v0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f62359a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f62359a.setVisibility(8);
            }
            i = l.g(this.f62360b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f62361c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62361c.getLayoutParams();
            layoutParams.rightMargin = i;
            this.f62361c.setLayoutParams(layoutParams);
        }
        if (this.f62361c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f62361c.getLayoutParams();
            layoutParams2.rightMargin = i;
            this.f62361c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f62359a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView = this.f62359a;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.q();
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f62362d = bdUniqueId;
    }
}
