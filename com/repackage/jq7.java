package com.repackage;

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
/* loaded from: classes6.dex */
public abstract class jq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public NavigationBar c;
    public View d;
    public TextView e;
    public ImageView f;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public TextView m;
    public TextView n;

    public jq7(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = view2;
        NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f091534);
        this.c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = addSystemImageButton;
        addSystemImageButton.setId(R.id.obfuscated_res_0x7f090412);
        TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getString(R.string.obfuscated_res_0x7f0f11a0));
        this.e = addTextButton;
        addTextButton.setId(R.id.obfuscated_res_0x7f09043b);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09210e);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09210d);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ec6);
        this.f = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = mi.i(tbPageContext.getPageActivity()) / 4;
        this.f.setLayoutParams(layoutParams);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09133a);
        this.g = textView;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (mi.i(tbPageContext.getPageActivity()) / 2) + mi.f(tbPageContext.getPageActivity(), R.dimen.tbds239);
        this.g.setLayoutParams(layoutParams2);
        this.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919da);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09248a);
        this.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09248d);
        this.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0924ff);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09145b);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.c.onChangeSkinType(this.a, i);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201, i);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201, i);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0107);
            gs4 d = gs4.d(this.m);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X03);
            d.A(R.string.F_X02);
            gs4 d2 = gs4.d(this.n);
            d2.v(R.color.CAM_X0107);
            d2.z(R.dimen.T_X08);
            d2.A(R.string.F_X01);
            if (i == 0) {
                WebPManager.setMaskDrawable(this.f, R.drawable.obfuscated_res_0x7f08081a, null);
            } else {
                WebPManager.setMaskDrawable(this.f, R.drawable.obfuscated_res_0x7f08081b, null);
            }
            gs4 d3 = gs4.d(this.g);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X05);
            d3.A(R.string.F_X01);
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0302);
            WebPManager.setMaskDrawable(this.h, R.drawable.icon_share_qq, null);
            WebPManager.setMaskDrawable(this.i, R.drawable.icon_share_wechat, null);
            WebPManager.setMaskDrawable(this.j, R.drawable.icon_share_weibo, null);
            WebPManager.setMaskDrawable(this.k, R.drawable.icon_share_yy, null);
            WebPManager.setMaskDrawable(this.l, R.drawable.icon_share_more, null);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.d.setVisibility(z ? 0 : 4);
        }
    }

    public abstract void c(kq7 kq7Var);

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.e.setOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
            this.h.setOnClickListener(onClickListener);
            this.i.setOnClickListener(onClickListener);
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
