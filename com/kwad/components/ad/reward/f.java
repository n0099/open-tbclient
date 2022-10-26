package com.kwad.components.ad.reward;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.k.kwai.a;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List a(KsScene ksScene, List list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ksScene, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list.isEmpty()) {
                return arrayList;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdTemplate adTemplate = (AdTemplate) it.next();
                if (adTemplate != null) {
                    if (adTemplate.mAdScene == null && (ksScene instanceof SceneImpl)) {
                        adTemplate.mAdScene = (SceneImpl) ksScene;
                    }
                    AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
                    if (com.kwad.sdk.core.response.a.a.bk(bQ) || !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.A(bQ))) {
                        arrayList.add(adTemplate);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void loadRewardVideoAd(KsScene ksScene, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ksScene, rewardVideoAdListener) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.reward.monitor.a.a(true, elapsedRealtime);
            boolean a = com.kwad.components.core.m.m.oF().a(ksScene, "loadRewardVideoAd");
            ksScene.setAdStyle(2);
            KsAdLoadManager.ab();
            KsAdLoadManager.a(new a.C0571a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(a).a(new com.kwad.components.core.k.c(rewardVideoAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.components.ad.reward.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsScene cU;
                public final /* synthetic */ long ef;
                public final /* synthetic */ KsLoadManager.RewardVideoAdListener lX;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {rewardVideoAdListener, ksScene, Long.valueOf(elapsedRealtime)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.lX = rewardVideoAdListener;
                    this.cU = ksScene;
                    this.ef = elapsedRealtime;
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.b
                public final void a(AdResultData adResultData, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, adResultData, z) == null) {
                        List<AdTemplate> a2 = f.a(this.cU, adResultData.getProceedTemplateList());
                        if (a2.isEmpty()) {
                            com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.Yd;
                            onError(fVar.errorCode, fVar.Qd);
                            return;
                        }
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        ArrayList<KsRewardVideoAd> arrayList = new ArrayList();
                        for (AdTemplate adTemplate : a2) {
                            arrayList.add(new g(adTemplate));
                            adTemplate.mLoadDataTime = elapsedRealtime2;
                            adTemplate.mLoadFromCache = z;
                        }
                        com.kwad.components.ad.reward.monitor.a.a(true, (AdTemplate) a2.get(0), a2.size(), this.ef);
                        bd.runOnUiThread(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.reward.f.1.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ List aZ;
                            public final /* synthetic */ AnonymousClass1 lY;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, arrayList};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.lY = this;
                                this.aZ = arrayList;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        KsAdLoadManager.ab().b(this.aZ);
                                        this.lY.lX.onRewardVideoResult(this.aZ);
                                    } catch (Throwable unused) {
                                    }
                                    try {
                                        com.kwad.sdk.utils.q.a((Object) this.lY.lX, "onRequestResult", Integer.valueOf(this.aZ.size()));
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        });
                        ArrayList arrayList2 = new ArrayList();
                        boolean z2 = false;
                        for (KsRewardVideoAd ksRewardVideoAd : arrayList) {
                            AdTemplate adTemplate2 = ((g) ksRewardVideoAd).getAdTemplate();
                            if (com.kwad.sdk.core.response.a.a.bk(com.kwad.sdk.core.response.a.d.bQ(adTemplate2))) {
                                arrayList2.add(ksRewardVideoAd);
                                z2 = true;
                            } else if (com.kwad.components.ad.b.a.a(adTemplate2, true)) {
                                arrayList2.add(ksRewardVideoAd);
                            }
                        }
                        if (z2 || !arrayList2.isEmpty()) {
                            com.kwad.components.ad.reward.monitor.a.b(true, (AdTemplate) a2.get(0), a2.size(), this.ef);
                            bd.runOnUiThread(new Runnable(this, arrayList2) { // from class: com.kwad.components.ad.reward.f.1.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 lY;
                                public final /* synthetic */ List lZ;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, arrayList2};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.lY = this;
                                    this.lZ = arrayList2;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.lY.lX.onRewardVideoAdLoad(this.lZ);
                                    }
                                }
                            });
                            return;
                        }
                        com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.Ye;
                        onError(fVar2.errorCode, fVar2.Qd);
                    }
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
                public final void onError(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                        com.kwad.components.ad.reward.monitor.a.a(true, i, str);
                        bd.runOnUiThread(new Runnable(this, i, str) { // from class: com.kwad.components.ad.reward.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int aW;
                            public final /* synthetic */ String aX;
                            public final /* synthetic */ AnonymousClass1 lY;

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
                                this.lY = this;
                                this.aW = i;
                                this.aX = str;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.e.b.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.aW), this.aX));
                                    this.lY.lX.onError(this.aW, this.aX);
                                }
                            }
                        });
                    }
                }
            }).oo());
        }
    }
}
