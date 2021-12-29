package com.fun.ad.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes3.dex */
public class ChannelNativeAds {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GdtADStatusChangeListener a;
    public final Object baiduNative;
    public final Object baiduNative2;
    public final Object csjNative;
    public final Object gdtNative;
    public final Object jyNative;
    public final Object kdsNative;
    public final Object ksNative;

    /* loaded from: classes3.dex */
    public interface GdtADStatusChangeListener {
        void onADStatusChanged(NativeUnifiedADData nativeUnifiedADData);
    }

    public ChannelNativeAds(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, obj2, obj3, obj4, obj5, obj6, obj7};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.baiduNative = obj;
        this.baiduNative2 = obj2;
        this.csjNative = obj3;
        this.gdtNative = obj4;
        this.jyNative = obj5;
        this.ksNative = obj6;
        this.kdsNative = obj7;
    }

    public static ChannelNativeAds createBdFeed(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) ? new ChannelNativeAds(null, obj, null, null, null, null, null) : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createBdNaive(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) ? new ChannelNativeAds(obj, null, null, null, null, null, null) : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createCsj(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) ? new ChannelNativeAds(null, null, obj, null, null, null, null) : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createGdt(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) ? new ChannelNativeAds(null, null, null, obj, null, null, null) : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createJy(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? new ChannelNativeAds(null, null, null, null, obj, null, null) : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createKds(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) ? new ChannelNativeAds(null, null, null, null, null, null, obj) : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createKs(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) ? new ChannelNativeAds(null, null, null, null, null, obj, null) : (ChannelNativeAds) invokeL.objValue;
    }

    public GdtADStatusChangeListener getGdtADStatusChangeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (GdtADStatusChangeListener) invokeV.objValue;
    }

    public void setGdtADStatusChangeListener(GdtADStatusChangeListener gdtADStatusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gdtADStatusChangeListener) == null) {
            this.a = gdtADStatusChangeListener;
        }
    }
}
