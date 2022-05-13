package com.repackage;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
import com.repackage.jf9;
/* loaded from: classes6.dex */
public class kf9 extends jf9.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ tf9 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kf9(jf9 jf9Var, TTSplashAd tTSplashAd, String str, tf9 tf9Var) {
        super(jf9Var, tTSplashAd, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jf9Var, tTSplashAd, str, tf9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((jf9) objArr2[0], (TTSplashAd) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = tf9Var;
    }

    @Override // com.repackage.jf9.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdClicked(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            super.onAdClicked(view2, i);
            tf9 tf9Var = this.f;
            String str = this.b;
            FunSplashAdInteractionListener funSplashAdInteractionListener = tf9Var.j;
            if (funSplashAdInteractionListener != null) {
                funSplashAdInteractionListener.onAdClicked(str);
            }
        }
    }

    @Override // com.repackage.jf9.b, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
    public void onAdShow(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            super.onAdShow(view2, i);
            tf9 tf9Var = this.f;
            tf9Var.g = tf9Var.b.getWidth();
            tf9Var.h = tf9Var.b.getHeight();
        }
    }
}
