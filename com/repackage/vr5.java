package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vr5 extends ur5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup f;
    public TbImageView g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vr5(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
    }

    @Override // com.repackage.ur5
    public void b(ir5 ir5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ir5Var) == null) {
            super.b(ir5Var);
        }
    }

    @Override // com.repackage.ur5
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.repackage.ur5
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = new FrameLayout(this.c.getPageActivity());
            this.g = new TbImageView(this.c.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.a, this.b);
            this.g.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080ed1);
            this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.g.setLayoutParams(layoutParams);
            this.f.addView(this.g);
            this.e.setVisibility(8);
            this.f.addView(this.e);
            this.g.setClickable(false);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.repackage.ur5
    public boolean f(ir5 ir5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ir5Var)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ur5
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // com.repackage.ur5
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            TbImageView tbImageView = this.g;
            if (tbImageView != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
                layoutParams.width = this.a;
                layoutParams.height = this.b;
                this.g.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.repackage.ur5
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (1 == i) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
        }
    }

    @Override // com.repackage.ur5
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g = null;
        }
    }

    @Override // com.repackage.ur5
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.repackage.ur5
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }
}
