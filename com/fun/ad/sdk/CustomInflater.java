package com.fun.ad.sdk;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class CustomInflater implements NativeInflater {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FunNativeAd2 a;

    public CustomInflater(FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funNativeAd2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = funNativeAd2;
    }

    public abstract List<View> getClickViews();

    public abstract List<View> getCreativeViews();

    public abstract NativeAdContainer getGdtNativeAdContainer();

    public final FunNativeInfo getNativeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getNativeInfo() : (FunNativeInfo) invokeV.objValue;
    }
}
