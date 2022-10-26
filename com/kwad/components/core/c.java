package com.kwad.components.core;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.a.d;
import com.kwad.components.ad.a.e;
import com.kwad.components.ad.a.f;
import com.kwad.components.ad.a.g;
import com.kwad.components.ad.a.h;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
/* loaded from: classes7.dex */
public final class c implements KsLoadManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestToken(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ksScene)) == null) {
            com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.a.class);
            return aVar != null ? aVar.getBidRequestToken(ksScene) : "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestTokenV2(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksScene)) == null) {
            com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.a.class);
            return aVar != null ? aVar.getBidRequestTokenV2(ksScene) : "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadConfigFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.components.ad.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ksScene, feedAdListener) == null) || (cVar = (com.kwad.components.ad.a.c) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.c.class)) == null) {
            return;
        }
        cVar.loadConfigFeedAd(ksScene, feedAdListener);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadDrawAd(KsScene ksScene, KsLoadManager.DrawAdListener drawAdListener) {
        com.kwad.components.ad.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, ksScene, drawAdListener) == null) || (bVar = (com.kwad.components.ad.a.b) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.b.class)) == null) {
            return;
        }
        bVar.loadDrawAd(ksScene, drawAdListener);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.components.ad.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, ksScene, feedAdListener) == null) || (cVar = (com.kwad.components.ad.a.c) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.c.class)) == null) {
            return;
        }
        cVar.loadFeedAd(ksScene, feedAdListener);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFullScreenVideoAd(KsScene ksScene, KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, ksScene, fullScreenVideoAdListener) == null) || (dVar = (d) com.kwad.sdk.components.c.f(d.class)) == null) {
            return;
        }
        dVar.loadFullScreenVideoAd(ksScene, fullScreenVideoAdListener);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadInterstitialAd(KsScene ksScene, KsLoadManager.InterstitialAdListener interstitialAdListener) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, ksScene, interstitialAdListener) == null) || (eVar = (e) com.kwad.sdk.components.c.f(e.class)) == null) {
            return;
        }
        eVar.loadInterstitialAd(ksScene, interstitialAdListener);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(KsScene ksScene, KsLoadManager.NativeAdListener nativeAdListener) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, ksScene, nativeAdListener) == null) || (fVar = (f) com.kwad.sdk.components.c.f(f.class)) == null) {
            return;
        }
        fVar.loadNativeAd(ksScene, nativeAdListener);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(String str, KsLoadManager.NativeAdListener nativeAdListener) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, nativeAdListener) == null) || (fVar = (f) com.kwad.sdk.components.c.f(f.class)) == null) {
            return;
        }
        fVar.loadNativeAd(str, nativeAdListener);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadRewardVideoAd(KsScene ksScene, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, ksScene, rewardVideoAdListener) == null) || (gVar = (g) com.kwad.sdk.components.c.f(g.class)) == null) {
            return;
        }
        gVar.loadRewardVideoAd(ksScene, rewardVideoAdListener);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadSplashScreenAd(KsScene ksScene, KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, ksScene, splashScreenAdListener) == null) || (hVar = (h) com.kwad.sdk.components.c.f(h.class)) == null) {
            return;
        }
        hVar.loadSplashScreenAd(ksScene, splashScreenAdListener);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, activity, ksExitInstallListener)) == null) {
            com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.a.class);
            if (aVar != null) {
                return aVar.showInstallDialog(activity, ksExitInstallListener);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
