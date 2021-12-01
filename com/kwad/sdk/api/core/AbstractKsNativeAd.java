package com.kwad.sdk.api.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.loader.Wrapper;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes2.dex */
public abstract class AbstractKsNativeAd implements KsNativeAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbstractKsNativeAd() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public abstract Bitmap getSdkLogo();

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getVideoView(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ksAdVideoPlayConfig)) == null) ? getVideoView2(Wrapper.wrapContextIfNeed(context), ksAdVideoPlayConfig) : (View) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getVideoView(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, context, z)) == null) ? getVideoView2(Wrapper.wrapContextIfNeed(context), z) : (View) invokeLZ.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public abstract View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkDynamicApi
    @Keep
    public abstract View getVideoView2(Context context, boolean z);
}
