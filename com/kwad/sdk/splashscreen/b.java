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
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes2.dex */
public class b extends AbstrackKsSplashScreenAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdResultData f67492a;

    /* renamed from: b  reason: collision with root package name */
    public KsScene f67493b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final AdTemplate f67494c;

    public b(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
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
        this.f67492a = adResultData;
        this.f67493b = ksScene;
        this.f67494c = adResultData.adTemplateList.get(0);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.response.b.a.x(com.kwad.sdk.core.response.b.c.i(this.f67494c)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, splashScreenAdInteractionListener)) == null) {
            KsSplashScreenFragment a2 = KsSplashScreenFragment.a(this.f67493b, this.f67492a);
            a2.a(splashScreenAdInteractionListener);
            return a2;
        }
        return (KsFragment) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.b.a.w(com.kwad.sdk.core.response.b.c.i(this.f67494c)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.b.a.H(com.kwad.sdk.core.response.b.c.i(this.f67494c)) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, splashScreenAdInteractionListener)) == null) {
            c a2 = c.a(context, this.f67493b, this.f67492a);
            a2.setSplashScreenAdListener(splashScreenAdInteractionListener);
            return a2;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? SplashPreloadManager.b().a(this.f67492a) || SplashPreloadManager.b().b(this.f67492a) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.sdk.core.response.b.a.F(com.kwad.sdk.core.response.b.c.i(this.f67492a.adTemplateList.get(0))) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            AdTemplate adTemplate = this.f67494c;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.a.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean showSplashMiniWindowIfNeeded(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener, Rect rect) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, splashScreenAdInteractionListener, rect)) == null) {
            String a2 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.i(this.f67494c));
            if (a2 == null || StringUtil.NULL_STRING.equals(a2) || a2.equals("")) {
                return false;
            }
            return new a(context, String.valueOf(a2.hashCode()), true, splashScreenAdInteractionListener).a(rect);
        }
        return invokeLLL.booleanValue;
    }
}
