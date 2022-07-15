package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.j.kwai.a;
import com.kwad.components.core.l.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.core.video.f;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ksScene, interstitialAdListener) == null) {
            boolean a = m.a().a(ksScene, "loadInterstitialAd");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ksScene.setAdStyle(13);
            KsAdLoadManager.a();
            KsAdLoadManager.a(new a.C0512a().a(new com.kwad.components.core.j.kwai.b(ksScene)).b(a).a(new com.kwad.components.core.j.c(interstitialAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.components.ad.interstitial.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLoadManager.InterstitialAdListener a;
                public final /* synthetic */ KsScene b;
                public final /* synthetic */ long c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {interstitialAdListener, ksScene, Long.valueOf(elapsedRealtime)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = interstitialAdListener;
                    this.b = ksScene;
                    this.c = elapsedRealtime;
                }

                @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.g
                public final void a(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                        az.a(new Runnable(this, i, str) { // from class: com.kwad.components.ad.interstitial.e.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int a;
                            public final /* synthetic */ String b;
                            public final /* synthetic */ AnonymousClass1 c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.c = this;
                                this.a = i;
                                this.b = str;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.b.e("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.b));
                                    this.c.a.onError(this.a, this.b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.g
                public final void a(@NonNull AdResultData adResultData) {
                    b bVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        az.a(new Runnable(this, adResultData) { // from class: com.kwad.components.ad.interstitial.e.1.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AdResultData a;
                            public final /* synthetic */ AnonymousClass1 b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, adResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.b = this;
                                this.a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.b.a.onRequestResult(this.a.getAdTemplateList().size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.b.b(th);
                                    }
                                }
                            }
                        });
                        ArrayList arrayList = new ArrayList();
                        int J = com.kwad.sdk.core.config.d.J();
                        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                            if (adTemplate != null) {
                                if (adTemplate.mAdScene == null) {
                                    KsScene ksScene2 = this.b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.i(adTemplate)))) {
                                    bVar = new b(this.b, adTemplate);
                                } else if (f.a(adTemplate, J)) {
                                    bVar = new b(this.b, adTemplate);
                                }
                                arrayList.add(bVar);
                            }
                        }
                        if (arrayList.size() != 0) {
                            az.a(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.components.ad.interstitial.e.1.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ List a;
                                public final /* synthetic */ AdResultData b;
                                public final /* synthetic */ AnonymousClass1 c;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, arrayList, adResultData};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.c = this;
                                    this.a = arrayList;
                                    this.b = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.c.a.onInterstitialAdLoad(this.a);
                                        KsAdLoadManager.a();
                                        KsAdLoadManager.a(this.b, this.c.c);
                                    }
                                }
                            });
                            return;
                        }
                        com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f;
                        a(fVar.p, fVar.q);
                    }
                }
            }).a());
        }
    }
}
