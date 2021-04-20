package d.b.i0.b2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53334a;

    /* renamed from: b  reason: collision with root package name */
    public View f53335b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f53336c;

    /* renamed from: d  reason: collision with root package name */
    public View f53337d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53338e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f53339f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53340g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f53341h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public TextView l;
    public TextView m;

    public b(TbPageContext tbPageContext, View view) {
        this.f53334a = tbPageContext;
        this.f53335b = view;
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.f53336c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53337d = addSystemImageButton;
        addSystemImageButton.setId(R.id.btn_close);
        TextView addTextButton = this.f53336c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getString(R.string.skip));
        this.f53338e = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        this.l = (TextView) view.findViewById(R.id.top_tip);
        this.m = (TextView) view.findViewById(R.id.top_sub_tip);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_logo);
        this.f53339f = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = l.i(tbPageContext.getPageActivity()) / 4;
        this.f53339f.setLayoutParams(layoutParams);
        TextView textView = (TextView) view.findViewById(R.id.login_btn);
        this.f53340g = textView;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (l.i(tbPageContext.getPageActivity()) / 2) + l.g(tbPageContext.getPageActivity(), R.dimen.tbds239);
        this.f53340g.setLayoutParams(layoutParams2);
        this.f53341h = (ImageView) view.findViewById(R.id.qq_login_btn);
        this.i = (ImageView) view.findViewById(R.id.wechat_login_btn);
        this.j = (ImageView) view.findViewById(R.id.weibo_login_btn);
        this.k = (ImageView) view.findViewById(R.id.more_login_btn);
    }

    public void a(int i) {
        this.f53336c.onChangeSkinType(this.f53334a, i);
        SkinManager.setBackgroundColor(this.f53336c, R.color.CAM_X0201, i);
        SkinManager.setBackgroundColor(this.f53335b, R.color.CAM_X0201, i);
        SkinManager.setViewTextColor(this.f53338e, R.color.CAM_X0107);
        d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.l);
        d2.q(R.color.CAM_X0105);
        d2.u(R.dimen.T_X03);
        d2.v(R.string.F_X02);
        d.b.h0.r.u.c d3 = d.b.h0.r.u.c.d(this.m);
        d3.q(R.color.CAM_X0107);
        d3.u(R.dimen.T_X08);
        d3.v(R.string.F_X01);
        if (i == 0) {
            WebPManager.setMaskDrawable(this.f53339f, R.drawable.icon_mask_signin_logo_day, null);
        } else {
            WebPManager.setMaskDrawable(this.f53339f, R.drawable.icon_mask_signin_logo_night, null);
        }
        d.b.h0.r.u.c d4 = d.b.h0.r.u.c.d(this.f53340g);
        d4.q(R.color.CAM_X0101);
        d4.u(R.dimen.T_X05);
        d4.v(R.string.F_X01);
        d4.k(R.string.J_X01);
        d4.f(R.color.CAM_X0302);
        WebPManager.setMaskDrawable(this.f53341h, R.drawable.icon_share_qq, null);
        WebPManager.setMaskDrawable(this.i, R.drawable.icon_share_wechat, null);
        WebPManager.setMaskDrawable(this.j, R.drawable.icon_share_weibo, null);
        WebPManager.setMaskDrawable(this.k, R.drawable.icon_share_more, null);
    }

    public void b(boolean z) {
        this.f53337d.setVisibility(z ? 0 : 4);
    }

    public abstract void c(c cVar);

    public void d(View.OnClickListener onClickListener) {
        this.f53338e.setOnClickListener(onClickListener);
        this.f53340g.setOnClickListener(onClickListener);
        this.f53341h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
    }

    public void e(boolean z) {
        this.l.setVisibility(z ? 0 : 4);
        this.m.setVisibility(z ? 0 : 4);
    }
}
