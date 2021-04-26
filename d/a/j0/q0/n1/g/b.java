package d.a.j0.q0.n1.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends d.a.j0.q0.n1.g.a {
    public View.OnClickListener A0;
    public TbPageContext t0;
    public TextView u0;
    public EntelechyUserLikeButton v0;
    public d.a.i0.r.f0.q.c w0;
    public int x0;
    public a2 y0;
    public CommonUserLikeButton.a z0;

    /* loaded from: classes4.dex */
    public class a implements CommonUserLikeButton.a {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
        public void a(int i2) {
            b.this.q0(i2);
        }
    }

    /* renamed from: d.a.j0.q0.n1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1434b implements View.OnClickListener {
        public View$OnClickListenerC1434b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.y0 == null || b.this.y0.T() == null || StringUtils.isNull(b.this.y0.T().getName_show()) || StringUtils.isNull(b.this.y0.T().getUserId()) || b.this.y0.i0() == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.t0.getPageActivity(), b.this.y0.T().getUserId(), b.this.y0.T().getName_show(), b.this.y0.i0(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.x0 = 3;
        this.z0 = new a();
        this.A0 = new View$OnClickListenerC1434b();
        this.t0 = tbPageContext;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        this.u0 = textView;
        textView.setIncludeFontPadding(false);
        this.u0.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.g(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.u0.setLayoutParams(layoutParams);
        this.u0.setOnClickListener(this.A0);
        this.u.addView(this.u0, 1);
        EntelechyUserLikeButton entelechyUserLikeButton = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.v0 = entelechyUserLikeButton;
        entelechyUserLikeButton.setFanNumCallBack(this.z0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.g(this.t0.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.g(this.t0.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.g(this.t0.getPageActivity(), R.dimen.ds24);
        this.v0.setLayoutParams(layoutParams2);
        ((ViewGroup) l()).addView(this.v0);
        d.a.i0.r.f0.q.c cVar = new d.a.i0.r.f0.q.c(tbPageContext, this.v0);
        this.w0 = cVar;
        cVar.m("1");
        this.w0.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.n1.g.a, d.a.j0.x.b
    /* renamed from: X */
    public void m(a2 a2Var) {
        super.m(a2Var);
        if (a2Var == null) {
            return;
        }
        this.y0 = a2Var;
        if (a2Var.T() != null) {
            this.w0.n(a2Var.T());
            q0(a2Var.T().getFansNum());
            if (!this.y0.a2()) {
                this.v0.setVisibility(8);
            } else if (this.y0.T().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.y0.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.v0.setVisibility(8);
                return;
            } else if (this.y0.T().getGodUserData() != null && this.y0.T().getGodUserData().getIsLike()) {
                if (this.y0.T().getGodUserData().getIsFromNetWork()) {
                    this.v0.setVisibility(8);
                } else {
                    this.v0.setVisibility(0);
                    this.v0.e(true, 1);
                }
            } else {
                this.v0.setVisibility(0);
            }
        }
        int i2 = ((RelativeLayout.LayoutParams) this.v.getLayoutParams()).height;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v0.getLayoutParams();
        if (a2Var.i1() != null) {
            layoutParams.topMargin = l.g(this.t0.getPageActivity(), R.dimen.ds4) + i2;
        } else {
            layoutParams.topMargin = l.g(this.t0.getPageActivity(), R.dimen.ds24);
        }
    }

    @Override // d.a.j0.q0.n1.g.a
    public void Z(BdUniqueId bdUniqueId) {
        super.Z(bdUniqueId);
    }

    @Override // d.a.j0.q0.n1.g.a, d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        super.n(tbPageContext, i2);
        if (this.x0 != i2) {
            SkinManager.setViewTextColor(this.u0, R.color.CAM_X0109);
            this.v0.g(i2);
        }
        this.x0 = i2;
    }

    public final void q0(int i2) {
        if (this.u0 == null) {
            return;
        }
        String string = this.t0.getResources().getString(R.string.fans_default_name_god_user);
        a2 a2Var = this.y0;
        if (a2Var != null && !StringUtils.isNull(a2Var.i0()) && this.y0.i0().equals(this.i0)) {
            if (this.y0.a2()) {
                String format = String.format(string, StringHelper.numberUniformFormat(i2));
                this.u0.setVisibility(0);
                this.u0.setText(format);
                return;
            }
            this.u0.setVisibility(8);
            return;
        }
        this.u0.setText(this.t0.getResources().getString(R.string.default_personalized_name));
    }
}
