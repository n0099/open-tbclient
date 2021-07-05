package com.fun.ad.sdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.win.opensdk.PBNative;
/* loaded from: classes6.dex */
public class ChannelNativeAds_6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TTNativeAd csjNative;
    public final NativeUnifiedADData gdtNative;
    public final PBNative jyNative;
    public final KsNativeAd ksNative;
    public GdtADStatusChangeListener mListener;

    /* loaded from: classes6.dex */
    public interface GdtADStatusChangeListener {
        void onADStatusChanged(NativeUnifiedADData nativeUnifiedADData);
    }

    public ChannelNativeAds_6(TTNativeAd tTNativeAd, NativeUnifiedADData nativeUnifiedADData, PBNative pBNative, KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tTNativeAd, nativeUnifiedADData, pBNative, ksNativeAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.csjNative = tTNativeAd;
        this.gdtNative = nativeUnifiedADData;
        this.jyNative = pBNative;
        this.ksNative = ksNativeAd;
    }

    public static ChannelNativeAds_6 create(TTNativeAd tTNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tTNativeAd)) == null) ? new ChannelNativeAds_6(tTNativeAd, null, null, null) : (ChannelNativeAds_6) invokeL.objValue;
    }

    public static ChannelNativeAds_6 create(KsNativeAd ksNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ksNativeAd)) == null) ? new ChannelNativeAds_6(null, null, null, ksNativeAd) : (ChannelNativeAds_6) invokeL.objValue;
    }

    public static ChannelNativeAds_6 create(NativeUnifiedADData nativeUnifiedADData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, nativeUnifiedADData)) == null) ? new ChannelNativeAds_6(null, nativeUnifiedADData, null, null) : (ChannelNativeAds_6) invokeL.objValue;
    }

    public static ChannelNativeAds_6 create(PBNative pBNative) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, pBNative)) == null) ? new ChannelNativeAds_6(null, null, pBNative, null) : (ChannelNativeAds_6) invokeL.objValue;
    }

    public GdtADStatusChangeListener getGdtADStatusChangeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mListener : (GdtADStatusChangeListener) invokeV.objValue;
    }

    public void setGdtADStatusChangeListener(GdtADStatusChangeListener gdtADStatusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gdtADStatusChangeListener) == null) {
            this.mListener = gdtADStatusChangeListener;
        }
    }
}
