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
    public NEGFeedBackView f61990a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f61991b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f61992c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f61993d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f61994e = new C1666a(this);

    /* renamed from: d.a.n0.v.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1666a implements NEGFeedBackView.b {
        public C1666a(a aVar) {
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
        this.f61991b = tbPageContext;
        this.f61992c = viewGroup;
    }

    public View a() {
        return this.f61990a;
    }

    public void b(a2 a2Var, String str) {
        if (a2Var == null || a2Var.r1() == null || this.f61991b == null || this.f61992c == null) {
            return;
        }
        int i2 = 0;
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (TbadkCoreApplication.isLogin() && a2Var.r1().dislikeInfo != null && !z && a2Var.r1().dislikeInfo.size() > 0) {
            if (this.f61990a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f61991b);
                this.f61990a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f61993d);
                this.f61990a.setId(R.id.negative_feedback_view);
                this.f61990a.setDefaultReasonArray(new String[]{this.f61991b.getString(R.string.bad_quality), "", ""});
                this.f61990a.setEventCallback(this.f61994e);
                this.f61990a.n(this.f61992c, l.g(this.f61991b.getPageActivity(), R.dimen.tbds120), l.g(this.f61991b.getPageActivity(), R.dimen.tbds20));
                this.f61990a.q();
            }
            if (this.f61990a.getVisibility() != 0) {
                this.f61990a.setVisibility(0);
            }
            v0 v0Var = new v0();
            v0Var.n(a2Var.y1());
            v0Var.k(a2Var.c0());
            v0Var.m(a2Var.M0());
            v0Var.q(str);
            v0Var.j(a2Var.r1().dislikeInfo);
            this.f61990a.setData(v0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f61990a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f61990a.setVisibility(8);
            }
            i2 = l.g(this.f61991b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f61992c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61992c.getLayoutParams();
            layoutParams.rightMargin = i2;
            this.f61992c.setLayoutParams(layoutParams);
        }
        if (this.f61992c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f61992c.getLayoutParams();
            layoutParams2.rightMargin = i2;
            this.f61992c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f61990a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView = this.f61990a;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.q();
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f61993d = bdUniqueId;
    }
}
