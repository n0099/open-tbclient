package com.kwad.sdk.splashscreen;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.AbstrackKsSplashScreenAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes2.dex */
public class c extends AbstrackKsSplashScreenAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdResultData a;

    /* renamed from: b  reason: collision with root package name */
    public KsScene f59552b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final AdTemplate f59553c;

    public c(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene, adResultData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adResultData;
        this.f59552b = ksScene;
        this.f59553c = adResultData.adTemplateList.get(0);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.j(this.f59553c)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, splashScreenAdInteractionListener)) == null) {
            KsSplashScreenFragment a = KsSplashScreenFragment.a(this.f59552b, this.a);
            a.a(splashScreenAdInteractionListener);
            return a;
        }
        return (KsFragment) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.j(this.f59553c)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.a.a.R(com.kwad.sdk.core.response.a.d.j(this.f59553c)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, splashScreenAdInteractionListener)) == null) {
            d a = d.a(context, this.f59552b, this.a);
            a.setSplashScreenAdListener(splashScreenAdInteractionListener);
            return a;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? SplashPreloadManager.b().a(this.a) || SplashPreloadManager.b().b(this.a) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.j(this.a.adTemplateList.get(0))) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, adExposureFailedReason) == null) {
            com.kwad.sdk.core.report.a.a(this.f59553c, i2, adExposureFailedReason);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            AdTemplate adTemplate = this.f59553c;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.a.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean showSplashMiniWindowIfNeeded(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener, Rect rect) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, context, splashScreenAdInteractionListener, rect)) == null) {
            String a = com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(this.f59553c));
            if (a == null || StringUtil.NULL_STRING.equals(a) || a.equals("")) {
                return false;
            }
            return new b(context, String.valueOf(a.hashCode()), true, splashScreenAdInteractionListener).a(rect);
        }
        return invokeLLL.booleanValue;
    }
}
