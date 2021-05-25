package d.a.n0.c2.b;

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
    public TbPageContext f52361a;

    /* renamed from: b  reason: collision with root package name */
    public View f52362b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f52363c;

    /* renamed from: d  reason: collision with root package name */
    public View f52364d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52365e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f52366f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52367g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f52368h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f52369i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public TextView m;
    public TextView n;

    public b(TbPageContext tbPageContext, View view) {
        this.f52361a = tbPageContext;
        this.f52362b = view;
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.f52363c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f52364d = addSystemImageButton;
        addSystemImageButton.setId(R.id.btn_close);
        TextView addTextButton = this.f52363c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getString(R.string.skip));
        this.f52365e = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        this.m = (TextView) view.findViewById(R.id.top_tip);
        this.n = (TextView) view.findViewById(R.id.top_sub_tip);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_logo);
        this.f52366f = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = l.i(tbPageContext.getPageActivity()) / 4;
        this.f52366f.setLayoutParams(layoutParams);
        TextView textView = (TextView) view.findViewById(R.id.login_btn);
        this.f52367g = textView;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (l.i(tbPageContext.getPageActivity()) / 2) + l.g(tbPageContext.getPageActivity(), R.dimen.tbds239);
        this.f52367g.setLayoutParams(layoutParams2);
        this.f52368h = (ImageView) view.findViewById(R.id.qq_login_btn);
        this.f52369i = (ImageView) view.findViewById(R.id.wechat_login_btn);
        this.j = (ImageView) view.findViewById(R.id.weibo_login_btn);
        this.k = (ImageView) view.findViewById(R.id.yy_login_btn);
        this.l = (ImageView) view.findViewById(R.id.more_login_btn);
    }

    public void a(int i2) {
        this.f52363c.onChangeSkinType(this.f52361a, i2);
        SkinManager.setBackgroundColor(this.f52363c, R.color.CAM_X0201, i2);
        SkinManager.setBackgroundColor(this.f52362b, R.color.CAM_X0201, i2);
        SkinManager.setViewTextColor(this.f52365e, R.color.CAM_X0107);
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.m);
        d2.s(R.color.CAM_X0105);
        d2.w(R.dimen.T_X03);
        d2.x(R.string.F_X02);
        d.a.m0.r.u.c d3 = d.a.m0.r.u.c.d(this.n);
        d3.s(R.color.CAM_X0107);
        d3.w(R.dimen.T_X08);
        d3.x(R.string.F_X01);
        if (i2 == 0) {
            WebPManager.setMaskDrawable(this.f52366f, R.drawable.icon_mask_signin_logo_day, null);
        } else {
            WebPManager.setMaskDrawable(this.f52366f, R.drawable.icon_mask_signin_logo_night, null);
        }
        d.a.m0.r.u.c d4 = d.a.m0.r.u.c.d(this.f52367g);
        d4.s(R.color.CAM_X0101);
        d4.w(R.dimen.T_X05);
        d4.x(R.string.F_X01);
        d4.m(R.string.J_X01);
        d4.f(R.color.CAM_X0302);
        WebPManager.setMaskDrawable(this.f52368h, R.drawable.icon_share_qq, null);
        WebPManager.setMaskDrawable(this.f52369i, R.drawable.icon_share_wechat, null);
        WebPManager.setMaskDrawable(this.j, R.drawable.icon_share_weibo, null);
        WebPManager.setMaskDrawable(this.k, R.drawable.icon_share_yy, null);
        WebPManager.setMaskDrawable(this.l, R.drawable.icon_share_more, null);
    }

    public void b(boolean z) {
        this.f52364d.setVisibility(z ? 0 : 4);
    }

    public abstract void c(c cVar);

    public void d(View.OnClickListener onClickListener) {
        this.f52365e.setOnClickListener(onClickListener);
        this.f52367g.setOnClickListener(onClickListener);
        this.f52368h.setOnClickListener(onClickListener);
        this.f52369i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.m.setVisibility(z ? 0 : 4);
        this.n.setVisibility(z ? 0 : 4);
    }
}
