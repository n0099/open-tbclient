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
import com.kwad.components.core.k.kwai.a;
import com.kwad.components.core.m.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ksScene, interstitialAdListener) == null) {
            boolean a = m.oF().a(ksScene, "loadInterstitialAd");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ksScene.setAdStyle(13);
            com.kwad.components.ad.interstitial.monitor.b.cr().cs();
            KsAdLoadManager.ab();
            KsAdLoadManager.a(new a.C0598a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(a).a(new com.kwad.components.core.k.c(interstitialAdListener, elapsedRealtime, ksScene) { // from class: com.kwad.components.ad.interstitial.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsScene cU;
                public final /* synthetic */ KsLoadManager.InterstitialAdListener fG;
                public final /* synthetic */ long fu;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {interstitialAdListener, Long.valueOf(elapsedRealtime), ksScene};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.fG = interstitialAdListener;
                    this.fu = elapsedRealtime;
                    this.cU = ksScene;
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.b
                public final void a(@NonNull AdResultData adResultData, boolean z) {
                    b bVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, adResultData, z) == null) {
                        List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                        if (adTemplateList.isEmpty()) {
                            f fVar = f.Yd;
                            onError(fVar.errorCode, fVar.Qd);
                            return;
                        }
                        bd.runOnUiThread(new Runnable(this, adTemplateList) { // from class: com.kwad.components.ad.interstitial.e.1.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 fH;
                            public final /* synthetic */ List fI;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, adTemplateList};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.fH = this;
                                this.fI = adTemplateList;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.fH.fG.onRequestResult(this.fI.size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                                    }
                                }
                            }
                        });
                        com.kwad.components.ad.interstitial.monitor.b.cr().a(adTemplateList.get(0), this.fu, z);
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        ArrayList arrayList = new ArrayList();
                        for (AdTemplate adTemplate : adTemplateList) {
                            if (adTemplate != null) {
                                if (adTemplate.mAdScene == null) {
                                    KsScene ksScene2 = this.cU;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)))) {
                                    bVar = new b(this.cU, adTemplate);
                                } else if (com.kwad.components.ad.interstitial.monitor.a.g(adTemplate)) {
                                    bVar = new b(this.cU, adTemplate);
                                }
                                arrayList.add(bVar);
                            }
                        }
                        if (arrayList.size() == 0) {
                            f fVar2 = f.Yd;
                            onError(fVar2.errorCode, fVar2.Qd);
                            return;
                        }
                        com.kwad.components.ad.interstitial.monitor.b.cr().b(adTemplateList.get(0), elapsedRealtime2, z);
                        bd.runOnUiThread(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.components.ad.interstitial.e.1.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ List aZ;
                            public final /* synthetic */ AnonymousClass1 fH;
                            public final /* synthetic */ AdResultData fx;

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
                                this.fH = this;
                                this.aZ = arrayList;
                                this.fx = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    KsAdLoadManager.ab().b(this.aZ);
                                    this.fH.fG.onInterstitialAdLoad(this.aZ);
                                    KsAdLoadManager.ab();
                                    KsAdLoadManager.a(this.fx, this.fH.fu);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
                public final void onError(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                        com.kwad.components.ad.interstitial.monitor.b.cr().d(i, str);
                        bd.runOnUiThread(new Runnable(this, i, str) { // from class: com.kwad.components.ad.interstitial.e.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int aW;
                            public final /* synthetic */ String aX;
                            public final /* synthetic */ AnonymousClass1 fH;

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
                                this.fH = this;
                                this.aW = i;
                                this.aX = str;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.e.b.e("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.aW), this.aX));
                                    this.fH.fG.onError(this.aW, this.aX);
                                }
                            }
                        });
                    }
                }
            }).oo());
        }
    }
}
