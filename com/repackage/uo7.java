package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public View c;
    public View d;
    public LinearLayout e;

    public uo7(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0261, (ViewGroup) null, false);
        this.d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090898);
        this.e = linearLayout;
        linearLayout.setVisibility(8);
        this.a = this.d.findViewById(R.id.obfuscated_res_0x7f09089b);
        this.b = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0908a1);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f090895);
        this.c = findViewById;
        findViewById.setVisibility(8);
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            View view2 = this.a;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0204, i);
            }
            LinearLayout linearLayout = this.e;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0204, i);
            }
            TextView textView = this.b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i);
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204, i);
            }
            View view3 = this.c;
            if (view3 != null) {
                SkinManager.setViewTextColor(view3, R.color.CAM_X0107, i);
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0204, i);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (mo7.b().a()) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void update(Integer num) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, num) == null) || num == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.e.setVisibility(8);
        } else {
            this.b.setText(String.format(gj.a(R.string.obfuscated_res_0x7f0f054d), num));
            this.e.setVisibility(0);
        }
        if (mo7.b().a()) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
    }
}
