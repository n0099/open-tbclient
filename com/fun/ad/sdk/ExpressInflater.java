package com.fun.ad.sdk;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
/* loaded from: classes4.dex */
public abstract class ExpressInflater implements NativeInflater {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseNativeAd2<?, ? extends View> a;

    public ExpressInflater(FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funNativeAd2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (!(funNativeAd2 instanceof BaseNativeAd2) || !funNativeAd2.getNativeType().supportExpress()) {
            throw new IllegalArgumentException("ExpressInflater only support for NativeType.EXPRESS");
        }
        this.a = (BaseNativeAd2) funNativeAd2;
    }

    public final View getExpressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getExpressView() : (View) invokeV.objValue;
    }
}
