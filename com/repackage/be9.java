package com.repackage;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
import com.repackage.ae9;
/* loaded from: classes5.dex */
public class be9 extends ae9.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ke9 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be9(ae9 ae9Var, ef9 ef9Var, String str, ke9 ke9Var) {
        super(ae9Var, ef9Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ae9Var, ef9Var, str, ke9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ae9) objArr2[0], (ef9) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = ke9Var;
    }

    @Override // com.repackage.ae9.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            super.onAdClicked(view2, i);
            ke9 ke9Var = this.f;
            String str = this.b;
            FunSplashAdInteractionListener funSplashAdInteractionListener = ke9Var.j;
            if (funSplashAdInteractionListener != null) {
                funSplashAdInteractionListener.onAdClicked(str);
            }
        }
    }

    @Override // com.repackage.ae9.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            super.onAdShow(view2, i);
            ke9 ke9Var = this.f;
            ke9Var.g = ke9Var.b.getWidth();
            ke9Var.h = ke9Var.b.getHeight();
        }
    }
}
