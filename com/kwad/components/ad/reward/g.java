package com.kwad.components.ad.reward;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.j.kwai.a;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ksScene, rewardVideoAdListener) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.reward.monitor.a.a(true, elapsedRealtime);
            boolean a = com.kwad.components.core.l.m.a().a(ksScene, "loadRewardVideoAd");
            ksScene.setAdStyle(2);
            KsAdLoadManager.a();
            KsAdLoadManager.a(new a.C0512a().a(new com.kwad.components.core.j.kwai.b(ksScene)).b(a).a(new com.kwad.components.core.j.c(rewardVideoAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.components.ad.reward.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLoadManager.RewardVideoAdListener a;
                public final /* synthetic */ KsScene b;
                public final /* synthetic */ long c;

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
                    this.a = rewardVideoAdListener;
                    this.b = ksScene;
                    this.c = elapsedRealtime;
                }

                @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.g
                public final void a(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                        com.kwad.components.ad.reward.monitor.a.a(true, i, str);
                        az.a(new Runnable(this, i, str) { // from class: com.kwad.components.ad.reward.g.1.1
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
                                    com.kwad.sdk.core.d.b.a("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.b));
                                    this.c.a.onError(this.a, this.b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.b
                public final void a(@NonNull AdResultData adResultData, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData, z) == null) {
                        List<AdTemplate> b = g.b(this.b, adResultData.getProceedTemplateList());
                        if (b.isEmpty()) {
                            com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f;
                            a(fVar.p, fVar.q);
                            return;
                        }
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        ArrayList<KsRewardVideoAd> arrayList = new ArrayList();
                        for (AdTemplate adTemplate : b) {
                            arrayList.add(new h(adTemplate));
                            adTemplate.mLoadDataTime = elapsedRealtime2;
                            adTemplate.mLoadFromCache = z;
                        }
                        com.kwad.components.ad.reward.monitor.a.a(true, (AdTemplate) b.get(0), b.size(), this.c);
                        az.a(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.reward.g.1.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ List a;
                            public final /* synthetic */ AnonymousClass1 b;

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
                                this.b = this;
                                this.a = arrayList;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.b.a.onRewardVideoResult(this.a);
                                    } catch (Throwable unused) {
                                    }
                                    try {
                                        com.kwad.sdk.utils.q.a((Object) this.b.a, "onRequestResult", Integer.valueOf(this.a.size()));
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        });
                        ArrayList arrayList2 = new ArrayList();
                        boolean z2 = false;
                        for (KsRewardVideoAd ksRewardVideoAd : arrayList) {
                            AdTemplate a2 = ((h) ksRewardVideoAd).a();
                            if (com.kwad.sdk.core.response.a.a.aB(com.kwad.sdk.core.response.a.d.i(a2))) {
                                arrayList2.add(ksRewardVideoAd);
                                z2 = true;
                            } else if (com.kwad.components.ad.b.a.a(a2, true)) {
                                arrayList2.add(ksRewardVideoAd);
                            }
                        }
                        if (z2 || !arrayList2.isEmpty()) {
                            com.kwad.components.ad.reward.monitor.a.b(true, (AdTemplate) b.get(0), b.size(), this.c);
                            az.a(new Runnable(this, arrayList2) { // from class: com.kwad.components.ad.reward.g.1.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ List a;
                                public final /* synthetic */ AnonymousClass1 b;

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
                                    this.b = this;
                                    this.a = arrayList2;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.b.a.onRewardVideoAdLoad(this.a);
                                    }
                                }
                            });
                            return;
                        }
                        com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.g;
                        a(fVar2.p, fVar2.q);
                    }
                }
            }).a());
        }
    }

    @NonNull
    public static List<AdTemplate> b(KsScene ksScene, List<AdTemplate> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ksScene, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list.isEmpty()) {
                return arrayList;
            }
            for (AdTemplate adTemplate : list) {
                if (adTemplate != null) {
                    if (adTemplate.mAdScene == null && (ksScene instanceof SceneImpl)) {
                        adTemplate.mAdScene = (SceneImpl) ksScene;
                    }
                    AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
                    if (com.kwad.sdk.core.response.a.a.aB(i) || !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.b(i))) {
                        arrayList.add(adTemplate);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
