package com.repackage;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wu4 extends TBSpecificationButtonConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean u;

    public wu4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = true;
        this.b = R.color.CAM_X0101;
        this.d = R.color.CAM_X0302;
        this.u = false;
        this.n = this.o;
        this.m = this.l;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) ? r(f) : (Drawable) invokeF.objValue;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void i(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, iconType) == null) {
            u(i, iconType);
        }
    }

    public void p(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b = i;
            this.d = R.color.CAM_X0904;
            this.u = false;
            TBSpecificationButtonConfig.a aVar = this.t;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void q(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b = R.color.CAM_X0101;
            this.d = i;
            this.u = false;
            TBSpecificationButtonConfig.a aVar = this.t;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public final Drawable r(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) {
            if (this.u) {
                return s(f);
            }
            return t(f);
        }
        return (Drawable) invokeF.objValue;
    }

    public final Drawable s(float f) {
        InterceptResult invokeF;
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
            int color = SkinManager.getColor(this.r, this.d);
            int[] iArr = {sg8.c(color), color};
            if (Build.VERSION.SDK_INT >= 16) {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setOrientation(this.s);
                gradientDrawable.setColors(iArr);
            } else {
                gradientDrawable = new GradientDrawable(this.s, iArr);
            }
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f);
            return gradientDrawable;
        }
        return (Drawable) invokeF.objValue;
    }

    public final Drawable t(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(SkinManager.getColor(this.r, this.d));
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f);
            return gradientDrawable;
        }
        return (Drawable) invokeF.objValue;
    }

    public void u(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, iconType) == null) {
            this.e[0] = i;
            this.f = iconType;
        }
    }
}
