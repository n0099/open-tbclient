package com.repackage;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qu4 implements su4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TBLottieAnimationView a;

    public qu4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(context);
        this.a = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
    }

    @Override // com.repackage.su4
    public void a(ou4 ou4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ou4Var) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.a;
            int i = ou4Var.c;
            if (i < 0) {
                i = -2;
            }
            int i2 = ou4Var.c;
            tBLottieAnimationView.setLayoutParams(new LinearLayout.LayoutParams(i, i2 >= 0 ? i2 : -2));
            SkinManager.setLottieAnimation(this.a, ou4Var.b);
        }
    }

    @Override // com.repackage.su4
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // com.repackage.su4
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.cancelAnimation();
        }
    }

    @Override // com.repackage.su4
    public void onShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.playAnimation();
        }
    }
}
