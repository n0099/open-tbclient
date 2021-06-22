package d.a.o0.r0.n1.g;

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
import d.a.n0.r.q.a2;
/* loaded from: classes4.dex */
public class b extends d.a.o0.r0.n1.g.a {
    public EntelechyUserLikeButton A0;
    public d.a.n0.r.f0.q.c B0;
    public int C0;
    public a2 D0;
    public CommonUserLikeButton.a E0;
    public View.OnClickListener F0;
    public TbPageContext y0;
    public TextView z0;

    /* loaded from: classes4.dex */
    public class a implements CommonUserLikeButton.a {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
        public void a(int i2) {
            b.this.q0(i2);
        }
    }

    /* renamed from: d.a.o0.r0.n1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1581b implements View.OnClickListener {
        public View$OnClickListenerC1581b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.D0 == null || b.this.D0.T() == null || StringUtils.isNull(b.this.D0.T().getName_show()) || StringUtils.isNull(b.this.D0.T().getUserId()) || b.this.D0.i0() == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.y0.getPageActivity(), b.this.D0.T().getUserId(), b.this.D0.T().getName_show(), b.this.D0.i0(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.C0 = 3;
        this.E0 = new a();
        this.F0 = new View$OnClickListenerC1581b();
        this.y0 = tbPageContext;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        this.z0 = textView;
        textView.setIncludeFontPadding(false);
        this.z0.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.g(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.z0.setLayoutParams(layoutParams);
        this.z0.setOnClickListener(this.F0);
        this.u.addView(this.z0, 1);
        EntelechyUserLikeButton entelechyUserLikeButton = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.A0 = entelechyUserLikeButton;
        entelechyUserLikeButton.setFanNumCallBack(this.E0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.g(this.y0.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.g(this.y0.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.g(this.y0.getPageActivity(), R.dimen.ds24);
        this.A0.setLayoutParams(layoutParams2);
        ((ViewGroup) m()).addView(this.A0);
        d.a.n0.r.f0.q.c cVar = new d.a.n0.r.f0.q.c(tbPageContext, this.A0);
        this.B0 = cVar;
        cVar.m("1");
        this.B0.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.r0.n1.g.a, d.a.o0.z.b
    /* renamed from: Y */
    public void n(a2 a2Var) {
        super.n(a2Var);
        if (a2Var == null) {
            return;
        }
        this.D0 = a2Var;
        if (a2Var.T() != null) {
            this.B0.n(a2Var.T());
            q0(a2Var.T().getFansNum());
            if (!this.D0.d2()) {
                this.A0.setVisibility(8);
            } else if (this.D0.T().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.D0.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.A0.setVisibility(8);
                return;
            } else if (this.D0.T().getGodUserData() != null && this.D0.T().getGodUserData().getIsLike()) {
                if (this.D0.T().getGodUserData().getIsFromNetWork()) {
                    this.A0.setVisibility(8);
                } else {
                    this.A0.setVisibility(0);
                    this.A0.e(true, 1);
                }
            } else {
                this.A0.setVisibility(0);
            }
        }
        int i2 = ((RelativeLayout.LayoutParams) this.v.getLayoutParams()).height;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0.getLayoutParams();
        if (a2Var.k1() != null) {
            layoutParams.topMargin = l.g(this.y0.getPageActivity(), R.dimen.ds4) + i2;
        } else {
            layoutParams.topMargin = l.g(this.y0.getPageActivity(), R.dimen.ds24);
        }
    }

    @Override // d.a.o0.r0.n1.g.a
    public void a0(BdUniqueId bdUniqueId) {
        super.a0(bdUniqueId);
    }

    @Override // d.a.o0.r0.n1.g.a, d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        super.o(tbPageContext, i2);
        if (this.C0 != i2) {
            SkinManager.setViewTextColor(this.z0, R.color.CAM_X0109);
            this.A0.g(i2);
        }
        this.C0 = i2;
    }

    public final void q0(int i2) {
        if (this.z0 == null) {
            return;
        }
        String string = this.y0.getResources().getString(R.string.fans_default_name_god_user);
        a2 a2Var = this.D0;
        if (a2Var != null && !StringUtils.isNull(a2Var.i0()) && this.D0.i0().equals(this.n0)) {
            if (this.D0.d2()) {
                String format = String.format(string, StringHelper.numberUniformFormat(i2));
                this.z0.setVisibility(0);
                this.z0.setText(format);
                return;
            }
            this.z0.setVisibility(8);
            return;
        }
        this.z0.setText(this.y0.getResources().getString(R.string.default_personalized_name));
    }
}
