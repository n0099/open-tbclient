package d.a.k0.b2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52203a;

    /* renamed from: b  reason: collision with root package name */
    public View f52204b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f52205c;

    /* renamed from: d  reason: collision with root package name */
    public View f52206d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52207e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f52208f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52209g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f52210h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f52211i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public TextView m;
    public TextView n;

    public b(TbPageContext tbPageContext, View view) {
        this.f52203a = tbPageContext;
        this.f52204b = view;
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.f52205c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f52206d = addSystemImageButton;
        addSystemImageButton.setId(R.id.btn_close);
        TextView addTextButton = this.f52205c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getString(R.string.skip));
        this.f52207e = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        this.m = (TextView) view.findViewById(R.id.top_tip);
        this.n = (TextView) view.findViewById(R.id.top_sub_tip);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_logo);
        this.f52208f = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = l.i(tbPageContext.getPageActivity()) / 4;
        this.f52208f.setLayoutParams(layoutParams);
        TextView textView = (TextView) view.findViewById(R.id.login_btn);
        this.f52209g = textView;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (l.i(tbPageContext.getPageActivity()) / 2) + l.g(tbPageContext.getPageActivity(), R.dimen.tbds239);
        this.f52209g.setLayoutParams(layoutParams2);
        this.f52210h = (ImageView) view.findViewById(R.id.qq_login_btn);
        this.f52211i = (ImageView) view.findViewById(R.id.wechat_login_btn);
        this.j = (ImageView) view.findViewById(R.id.weibo_login_btn);
        this.k = (ImageView) view.findViewById(R.id.yy_login_btn);
        this.l = (ImageView) view.findViewById(R.id.more_login_btn);
    }

    public void a(int i2) {
        this.f52205c.onChangeSkinType(this.f52203a, i2);
        SkinManager.setBackgroundColor(this.f52205c, R.color.CAM_X0201, i2);
        SkinManager.setBackgroundColor(this.f52204b, R.color.CAM_X0201, i2);
        SkinManager.setViewTextColor(this.f52207e, R.color.CAM_X0107);
        d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(this.m);
        d2.q(R.color.CAM_X0105);
        d2.u(R.dimen.T_X03);
        d2.v(R.string.F_X02);
        d.a.j0.r.u.c d3 = d.a.j0.r.u.c.d(this.n);
        d3.q(R.color.CAM_X0107);
        d3.u(R.dimen.T_X08);
        d3.v(R.string.F_X01);
        if (i2 == 0) {
            WebPManager.setMaskDrawable(this.f52208f, R.drawable.icon_mask_signin_logo_day, null);
        } else {
            WebPManager.setMaskDrawable(this.f52208f, R.drawable.icon_mask_signin_logo_night, null);
        }
        d.a.j0.r.u.c d4 = d.a.j0.r.u.c.d(this.f52209g);
        d4.q(R.color.CAM_X0101);
        d4.u(R.dimen.T_X05);
        d4.v(R.string.F_X01);
        d4.k(R.string.J_X01);
        d4.f(R.color.CAM_X0302);
        WebPManager.setMaskDrawable(this.f52210h, R.drawable.icon_share_qq, null);
        WebPManager.setMaskDrawable(this.f52211i, R.drawable.icon_share_wechat, null);
        WebPManager.setMaskDrawable(this.j, R.drawable.icon_share_weibo, null);
        WebPManager.setMaskDrawable(this.k, R.drawable.icon_share_yy, null);
        WebPManager.setMaskDrawable(this.l, R.drawable.icon_share_more, null);
    }

    public void b(boolean z) {
        this.f52206d.setVisibility(z ? 0 : 4);
    }

    public abstract void c(c cVar);

    public void d(View.OnClickListener onClickListener) {
        this.f52207e.setOnClickListener(onClickListener);
        this.f52209g.setOnClickListener(onClickListener);
        this.f52210h.setOnClickListener(onClickListener);
        this.f52211i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.m.setVisibility(z ? 0 : 4);
        this.n.setVisibility(z ? 0 : 4);
    }
}
