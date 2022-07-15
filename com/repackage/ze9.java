package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes7.dex */
public class ze9 implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public final /* synthetic */ xe9 c;
    public final /* synthetic */ we9 d;

    public ze9(we9 we9Var, xe9 xe9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {we9Var, xe9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = we9Var;
        this.c = xe9Var;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            this.d.onAdClose(this.c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            this.d.onAdShow(this.c, this.a, new String[0]);
            this.a = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.d();
            this.d.onAdClicked(this.c, this.b, new String[0]);
            this.b = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LogPrinter.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LogPrinter.d();
        }
    }
}
