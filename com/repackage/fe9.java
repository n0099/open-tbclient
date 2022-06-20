package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.repackage.ce9;
/* loaded from: classes6.dex */
public class fe9 implements ce9.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FunNativeAd a;
    public final /* synthetic */ NativeUnifiedADData b;

    public fe9(ce9 ce9Var, FunNativeAd funNativeAd, NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ce9Var, funNativeAd, nativeUnifiedADData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = funNativeAd;
        this.b = nativeUnifiedADData;
    }

    @Override // com.repackage.ce9.e
    public void onADStatusChanged() {
        ChannelNativeAds.GdtADStatusChangeListener gdtADStatusChangeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gdtADStatusChangeListener = this.a.getChannelNativeAds().getGdtADStatusChangeListener()) == null) {
            return;
        }
        gdtADStatusChangeListener.onADStatusChanged(this.b);
    }
}
