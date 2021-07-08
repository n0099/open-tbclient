package d.a.p0.f2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes8.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56233a;

    /* renamed from: b  reason: collision with root package name */
    public View f56234b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56235c;

    /* renamed from: d  reason: collision with root package name */
    public View f56236d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56237e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56238f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56239g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f56240h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f56241i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public TextView m;
    public TextView n;

    public b(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56233a = tbPageContext;
        this.f56234b = view;
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.f56235c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56236d = addSystemImageButton;
        addSystemImageButton.setId(R.id.btn_close);
        TextView addTextButton = this.f56235c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getString(R.string.skip));
        this.f56237e = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        this.m = (TextView) view.findViewById(R.id.top_tip);
        this.n = (TextView) view.findViewById(R.id.top_sub_tip);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_logo);
        this.f56238f = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = l.i(tbPageContext.getPageActivity()) / 4;
        this.f56238f.setLayoutParams(layoutParams);
        TextView textView = (TextView) view.findViewById(R.id.login_btn);
        this.f56239g = textView;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (l.i(tbPageContext.getPageActivity()) / 2) + l.g(tbPageContext.getPageActivity(), R.dimen.tbds239);
        this.f56239g.setLayoutParams(layoutParams2);
        this.f56240h = (ImageView) view.findViewById(R.id.qq_login_btn);
        this.f56241i = (ImageView) view.findViewById(R.id.wechat_login_btn);
        this.j = (ImageView) view.findViewById(R.id.weibo_login_btn);
        this.k = (ImageView) view.findViewById(R.id.yy_login_btn);
        this.l = (ImageView) view.findViewById(R.id.more_login_btn);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f56235c.onChangeSkinType(this.f56233a, i2);
            SkinManager.setBackgroundColor(this.f56235c, R.color.CAM_X0201, i2);
            SkinManager.setBackgroundColor(this.f56234b, R.color.CAM_X0201, i2);
            SkinManager.setViewTextColor(this.f56237e, R.color.CAM_X0107);
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.m);
            d2.t(R.color.CAM_X0105);
            d2.x(R.dimen.T_X03);
            d2.y(R.string.F_X02);
            d.a.o0.r.u.c d3 = d.a.o0.r.u.c.d(this.n);
            d3.t(R.color.CAM_X0107);
            d3.x(R.dimen.T_X08);
            d3.y(R.string.F_X01);
            if (i2 == 0) {
                WebPManager.setMaskDrawable(this.f56238f, R.drawable.icon_mask_signin_logo_day, null);
            } else {
                WebPManager.setMaskDrawable(this.f56238f, R.drawable.icon_mask_signin_logo_night, null);
            }
            d.a.o0.r.u.c d4 = d.a.o0.r.u.c.d(this.f56239g);
            d4.t(R.color.CAM_X0101);
            d4.x(R.dimen.T_X05);
            d4.y(R.string.F_X01);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0302);
            WebPManager.setMaskDrawable(this.f56240h, R.drawable.icon_share_qq, null);
            WebPManager.setMaskDrawable(this.f56241i, R.drawable.icon_share_wechat, null);
            WebPManager.setMaskDrawable(this.j, R.drawable.icon_share_weibo, null);
            WebPManager.setMaskDrawable(this.k, R.drawable.icon_share_yy, null);
            WebPManager.setMaskDrawable(this.l, R.drawable.icon_share_more, null);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f56236d.setVisibility(z ? 0 : 4);
        }
    }

    public abstract void c(c cVar);

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f56237e.setOnClickListener(onClickListener);
            this.f56239g.setOnClickListener(onClickListener);
            this.f56240h.setOnClickListener(onClickListener);
            this.f56241i.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.m.setVisibility(z ? 0 : 4);
            this.n.setVisibility(z ? 0 : 4);
        }
    }
}
