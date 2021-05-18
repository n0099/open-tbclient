package d.a.k0.q0.o2;

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
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f59138a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f59139b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f59140c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f59141d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f59142e = new a(this);

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

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.f59139b = tbPageContext;
        this.f59140c = viewGroup;
    }

    public void a(a2 a2Var) {
        if (a2Var == null || this.f59139b == null || this.f59140c == null) {
            return;
        }
        int i2 = 0;
        boolean z = (a2Var.T() == null || a2Var.T().getUserId() == null || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (a2Var.v2() && a2Var.b0() != null && !z) {
            if (this.f59138a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f59139b);
                this.f59138a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f59141d);
                this.f59138a.setId(R.id.negative_feedback_view);
                this.f59138a.setDefaultReasonArray(new String[]{this.f59139b.getString(R.string.bad_quality), "", ""});
                this.f59138a.setEventCallback(this.f59142e);
                this.f59138a.l(this.f59140c, d.a.c.e.p.l.g(this.f59139b.getPageActivity(), R.dimen.tbds120), 0);
                this.f59138a.q();
            }
            if (this.f59138a.getVisibility() != 0) {
                this.f59138a.setVisibility(0);
            }
            v0 v0Var = new v0();
            v0Var.n(a2Var.x1());
            v0Var.k(a2Var.c0());
            v0Var.m(a2Var.L0());
            v0Var.j(a2Var.b0());
            v0Var.f50103g = a2Var.e1;
            this.f59138a.setData(v0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f59138a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f59138a.setVisibility(8);
            }
            i2 = d.a.c.e.p.l.g(this.f59139b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f59140c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f59140c.getLayoutParams();
            layoutParams.rightMargin = i2;
            this.f59140c.setLayoutParams(layoutParams);
        }
        if (this.f59140c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f59140c.getLayoutParams();
            layoutParams2.rightMargin = i2;
            this.f59140c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f59138a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public boolean b() {
        NEGFeedBackView nEGFeedBackView = this.f59138a;
        return nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0;
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView = this.f59138a;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.q();
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        this.f59141d = bdUniqueId;
    }
}
