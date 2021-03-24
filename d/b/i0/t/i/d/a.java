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
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f60794a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f60795b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f60796c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f60797d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f60798e = new C1564a(this);

    /* renamed from: d.b.i0.t.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1564a implements NEGFeedBackView.b {
        public C1564a(a aVar) {
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
        this.f60795b = tbPageContext;
        this.f60796c = viewGroup;
    }

    public View a() {
        return this.f60794a;
    }

    public void b(a2 a2Var, String str) {
        if (a2Var == null || a2Var.q1() == null || this.f60795b == null || this.f60796c == null) {
            return;
        }
        int i = 0;
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (TbadkCoreApplication.isLogin() && a2Var.q1().dislikeInfo != null && !z && a2Var.q1().dislikeInfo.size() > 0) {
            if (this.f60794a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f60795b);
                this.f60794a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f60797d);
                this.f60794a.setId(R.id.negative_feedback_view);
                this.f60794a.setDefaultReasonArray(new String[]{this.f60795b.getString(R.string.bad_quality), "", ""});
                this.f60794a.setEventCallback(this.f60798e);
                this.f60794a.n(this.f60796c, l.g(this.f60795b.getPageActivity(), R.dimen.tbds120), l.g(this.f60795b.getPageActivity(), R.dimen.tbds20));
                this.f60794a.q();
            }
            if (this.f60794a.getVisibility() != 0) {
                this.f60794a.setVisibility(0);
            }
            v0 v0Var = new v0();
            v0Var.n(a2Var.w1());
            v0Var.k(a2Var.c0());
            v0Var.m(a2Var.L0());
            v0Var.q(str);
            v0Var.j(a2Var.q1().dislikeInfo);
            this.f60794a.setData(v0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f60794a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f60794a.setVisibility(8);
            }
            i = l.g(this.f60795b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f60796c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60796c.getLayoutParams();
            layoutParams.rightMargin = i;
            this.f60796c.setLayoutParams(layoutParams);
        }
        if (this.f60796c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f60796c.getLayoutParams();
            layoutParams2.rightMargin = i;
            this.f60796c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f60794a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView = this.f60794a;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.q();
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f60797d = bdUniqueId;
    }
}
