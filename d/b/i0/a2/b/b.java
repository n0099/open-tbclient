package d.b.i0.a2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51913a;

    /* renamed from: b  reason: collision with root package name */
    public View f51914b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f51915c;

    /* renamed from: d  reason: collision with root package name */
    public View f51916d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51917e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f51918f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51919g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f51920h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public TextView l;
    public TextView m;

    public b(TbPageContext tbPageContext, View view) {
        this.f51913a = tbPageContext;
        this.f51914b = view;
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.f51915c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f51916d = addSystemImageButton;
        addSystemImageButton.setId(R.id.btn_close);
        TextView addTextButton = this.f51915c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getString(R.string.skip));
        this.f51917e = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        this.l = (TextView) view.findViewById(R.id.top_tip);
        this.m = (TextView) view.findViewById(R.id.top_sub_tip);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_logo);
        this.f51918f = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = l.i(tbPageContext.getPageActivity()) / 4;
        this.f51918f.setLayoutParams(layoutParams);
        TextView textView = (TextView) view.findViewById(R.id.login_btn);
        this.f51919g = textView;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (l.i(tbPageContext.getPageActivity()) / 2) + l.g(tbPageContext.getPageActivity(), R.dimen.tbds239);
        this.f51919g.setLayoutParams(layoutParams2);
        this.f51920h = (ImageView) view.findViewById(R.id.qq_login_btn);
        this.i = (ImageView) view.findViewById(R.id.wechat_login_btn);
        this.j = (ImageView) view.findViewById(R.id.weibo_login_btn);
        this.k = (ImageView) view.findViewById(R.id.more_login_btn);
    }

    public void a(int i) {
        this.f51915c.onChangeSkinType(this.f51913a, i);
        SkinManager.setBackgroundColor(this.f51915c, R.color.CAM_X0201, i);
        SkinManager.setBackgroundColor(this.f51914b, R.color.CAM_X0201, i);
        SkinManager.setViewTextColor(this.f51917e, R.color.CAM_X0107);
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.l);
        a2.n(R.color.CAM_X0105);
        a2.r(R.dimen.T_X03);
        a2.s(R.string.F_X02);
        d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(this.m);
        a3.n(R.color.CAM_X0107);
        a3.r(R.dimen.T_X08);
        a3.s(R.string.F_X01);
        if (i == 0) {
            WebPManager.setMaskDrawable(this.f51918f, R.drawable.icon_mask_signin_logo_day, null);
        } else {
            WebPManager.setMaskDrawable(this.f51918f, R.drawable.icon_mask_signin_logo_night, null);
        }
        d.b.h0.r.u.c a4 = d.b.h0.r.u.c.a(this.f51919g);
        a4.n(R.color.CAM_X0101);
        a4.r(R.dimen.T_X05);
        a4.s(R.string.F_X01);
        a4.h(R.string.J_X01);
        a4.c(R.color.CAM_X0302);
        WebPManager.setMaskDrawable(this.f51920h, R.drawable.icon_share_qq, null);
        WebPManager.setMaskDrawable(this.i, R.drawable.icon_share_wechat, null);
        WebPManager.setMaskDrawable(this.j, R.drawable.icon_share_weibo, null);
        WebPManager.setMaskDrawable(this.k, R.drawable.icon_share_more, null);
    }

    public void b(boolean z) {
        this.f51916d.setVisibility(z ? 0 : 4);
    }

    public abstract void c(c cVar);

    public void d(View.OnClickListener onClickListener) {
        this.f51917e.setOnClickListener(onClickListener);
        this.f51919g.setOnClickListener(onClickListener);
        this.f51920h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.l.setVisibility(z ? 0 : 4);
        this.m.setVisibility(z ? 0 : 4);
    }
}
