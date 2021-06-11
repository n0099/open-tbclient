package d.a.n0.v.i.d;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f65705a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f65706b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f65707c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f65708d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f65709e = new C1723a(this);

    /* renamed from: d.a.n0.v.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1723a implements NEGFeedBackView.b {
        public C1723a(a aVar) {
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
        this.f65706b = tbPageContext;
        this.f65707c = viewGroup;
    }

    public View a() {
        return this.f65705a;
    }

    public void b(a2 a2Var, String str) {
        if (a2Var == null || a2Var.s1() == null || this.f65706b == null || this.f65707c == null) {
            return;
        }
        int i2 = 0;
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (TbadkCoreApplication.isLogin() && a2Var.s1().dislikeInfo != null && !z && a2Var.s1().dislikeInfo.size() > 0) {
            if (this.f65705a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f65706b);
                this.f65705a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f65708d);
                this.f65705a.setId(R.id.negative_feedback_view);
                this.f65705a.setDefaultReasonArray(new String[]{this.f65706b.getString(R.string.bad_quality), "", ""});
                this.f65705a.setEventCallback(this.f65709e);
                this.f65705a.n(this.f65707c, l.g(this.f65706b.getPageActivity(), R.dimen.tbds120), l.g(this.f65706b.getPageActivity(), R.dimen.tbds20));
                this.f65705a.q();
            }
            if (this.f65705a.getVisibility() != 0) {
                this.f65705a.setVisibility(0);
            }
            v0 v0Var = new v0();
            v0Var.n(a2Var.z1());
            v0Var.k(a2Var.c0());
            v0Var.m(a2Var.M0());
            v0Var.q(str);
            v0Var.j(a2Var.s1().dislikeInfo);
            this.f65705a.setData(v0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f65705a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f65705a.setVisibility(8);
            }
            i2 = l.g(this.f65706b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f65707c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65707c.getLayoutParams();
            layoutParams.rightMargin = i2;
            this.f65707c.setLayoutParams(layoutParams);
        }
        if (this.f65707c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f65707c.getLayoutParams();
            layoutParams2.rightMargin = i2;
            this.f65707c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f65705a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView = this.f65705a;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.q();
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f65708d = bdUniqueId;
    }
}
