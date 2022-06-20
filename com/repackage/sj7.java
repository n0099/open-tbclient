package com.repackage;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public BaseActivity<?> b;
    public NavigationBar c;
    public View d;
    public NoNetworkView e;
    public TextView f;
    public TextView g;

    public sj7(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = baseActivity;
        this.d = baseActivity.findViewById(R.id.obfuscated_res_0x7f091ec6);
        this.a = (BdListView) baseActivity.findViewById(R.id.obfuscated_res_0x7f091ec2);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.obfuscated_res_0x7f091ec3);
        this.c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f137c));
        this.f = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.b.getString(R.string.obfuscated_res_0x7f0f0366), onClickListener);
        TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0514), onClickListener);
        this.g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.leftMargin = pi.f(this.b, R.dimen.obfuscated_res_0x7f0701be);
        this.f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams2.rightMargin = pi.f(this.b, R.dimen.obfuscated_res_0x7f0701be);
        this.g.setLayoutParams(layoutParams2);
        int f = pi.f(this.b, R.dimen.tbds27);
        this.g.setPadding(f, 0, f, 0);
        this.e = (NoNetworkView) baseActivity.findViewById(R.id.obfuscated_res_0x7f091ecf);
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070266)));
        View view3 = new View(baseActivity.getPageContext().getPageActivity());
        view3.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f9)));
        this.a.addFooterView(view2);
        this.a.addHeaderView(view3);
    }

    public TextView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (TextView) invokeV.objValue;
    }

    public TextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : (TextView) invokeV.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b.getLayoutMode().k(i == 1);
            this.b.getLayoutMode().j(this.d);
            this.e.d(this.b.getPageContext(), i);
            this.c.onChangeSkinType(this.b.getPageContext(), i);
            SkinManager.setViewTextColor(this.g, (int) R.color.navbar_btn_color);
            SkinManager.setViewTextColor(this.f, (int) R.color.navi_back_text_color);
            SkinManager.setBackgroundResource(this.g, R.drawable.s_navbar_button_bg);
        }
    }

    public void d(oj7 oj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, oj7Var) == null) {
            this.a.setAdapter((ListAdapter) oj7Var);
        }
    }

    public void e(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                this.g.setText(this.b.getPageContext().getString(R.string.obfuscated_res_0x7f0f04e6));
                return;
            }
            this.g.setText(this.b.getPageContext().getString(R.string.obfuscated_res_0x7f0f0514));
            this.g.setEnabled(!z2);
        }
    }
}
