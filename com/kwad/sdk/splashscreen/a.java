package com.kwad.sdk.splashscreen;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
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
/* loaded from: classes7.dex */
public class a extends AbstrackKsSplashScreenAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdResultData f39210a;

    /* renamed from: b  reason: collision with root package name */
    public KsScene f39211b;

    public a(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
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
        this.f39210a = adResultData;
        this.f39211b = ksScene;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, splashScreenAdInteractionListener)) == null) {
            KsSplashScreenFragment a2 = KsSplashScreenFragment.a(this.f39211b, this.f39210a);
            a2.a(splashScreenAdInteractionListener);
            return a2;
        }
        return (KsFragment) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, splashScreenAdInteractionListener)) == null) {
            b a2 = b.a(context, this.f39211b, this.f39210a);
            a2.setSplashScreenAdListener(splashScreenAdInteractionListener);
            return a2;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? SplashPreloadManager.b().a(this.f39210a) || SplashPreloadManager.b().b(this.f39210a) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.b.a.J(com.kwad.sdk.core.response.b.c.j(this.f39210a.adTemplateList.get(0))) : invokeV.booleanValue;
    }
}
