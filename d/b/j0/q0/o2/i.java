package d.b.j0.q0.o2;

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
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f60306a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f60307b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f60308c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f60309d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f60310e = new a(this);

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
        this.f60307b = tbPageContext;
        this.f60308c = viewGroup;
    }

    public void a(a2 a2Var) {
        if (a2Var == null || this.f60307b == null || this.f60308c == null) {
            return;
        }
        int i = 0;
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (a2Var.t2() && a2Var.b0() != null && !z) {
            if (this.f60306a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f60307b);
                this.f60306a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f60309d);
                this.f60306a.setId(R.id.negative_feedback_view);
                this.f60306a.setDefaultReasonArray(new String[]{this.f60307b.getString(R.string.bad_quality), "", ""});
                this.f60306a.setEventCallback(this.f60310e);
                this.f60306a.g(this.f60308c, d.b.c.e.p.l.g(this.f60307b.getPageActivity(), R.dimen.tbds120), 0);
                this.f60306a.q();
            }
            if (this.f60306a.getVisibility() != 0) {
                this.f60306a.setVisibility(0);
            }
            v0 v0Var = new v0();
            v0Var.n(a2Var.w1());
            v0Var.k(a2Var.c0());
            v0Var.m(a2Var.L0());
            v0Var.j(a2Var.b0());
            v0Var.f51650g = a2Var.e1;
            this.f60306a.setData(v0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f60306a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f60306a.setVisibility(8);
            }
            i = d.b.c.e.p.l.g(this.f60307b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f60308c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60308c.getLayoutParams();
            layoutParams.rightMargin = i;
            this.f60308c.setLayoutParams(layoutParams);
        }
        if (this.f60308c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f60308c.getLayoutParams();
            layoutParams2.rightMargin = i;
            this.f60308c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f60306a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public boolean b() {
        NEGFeedBackView nEGFeedBackView = this.f60306a;
        return nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0;
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView = this.f60306a;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.q();
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f60309d = bdUniqueId;
    }
}
