package com.kwad.components.ad.fullscreen;

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
import com.kwad.components.core.k.kwai.a;
import com.kwad.components.core.m.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static List<AdTemplate> a(KsScene ksScene, List<AdTemplate> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ksScene, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list.isEmpty()) {
                return arrayList;
            }
            for (AdTemplate adTemplate : list) {
                if (adTemplate != null) {
                    if (adTemplate.mAdScene == null && (ksScene instanceof SceneImpl)) {
                        adTemplate.mAdScene = (SceneImpl) ksScene;
                    }
                    if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)))) {
                        arrayList.add(adTemplate);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ksScene, fullScreenVideoAdListener) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.reward.monitor.a.a(false, elapsedRealtime);
            boolean a = m.oF().a(ksScene, "loadFullScreenVideoAd");
            ksScene.setAdStyle(3);
            KsAdLoadManager.ab();
            KsAdLoadManager.a(new a.C0574a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(a).a(new com.kwad.components.core.k.c(fullScreenVideoAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.components.ad.fullscreen.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsScene cU;
                public final /* synthetic */ KsLoadManager.FullScreenVideoAdListener ee;
                public final /* synthetic */ long ef;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fullScreenVideoAdListener, ksScene, Long.valueOf(elapsedRealtime)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ee = fullScreenVideoAdListener;
                    this.cU = ksScene;
                    this.ef = elapsedRealtime;
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.b
                public final void a(@NonNull AdResultData adResultData, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, adResultData, z) == null) {
                        List<AdTemplate> a2 = c.a(this.cU, adResultData.getAdTemplateList());
                        if (a2.isEmpty()) {
                            f fVar = f.Yd;
                            onError(fVar.errorCode, fVar.Qd);
                            return;
                        }
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                        for (AdTemplate adTemplate : a2) {
                            arrayList.add(new d(adTemplate));
                            adTemplate.mLoadDataTime = elapsedRealtime2;
                            adTemplate.mLoadFromCache = z;
                        }
                        com.kwad.components.ad.reward.monitor.a.a(false, (AdTemplate) a2.get(0), a2.size(), this.ef);
                        bd.runOnUiThread(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.fullscreen.c.1.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ List aZ;
                            public final /* synthetic */ AnonymousClass1 eg;

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
                                this.eg = this;
                                this.aZ = arrayList;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.eg.ee.onFullScreenVideoResult(this.aZ);
                                    } catch (Throwable unused) {
                                    }
                                    try {
                                        q.a((Object) this.eg.ee, "onRequestResult", Integer.valueOf(this.aZ.size()));
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        });
                        ArrayList arrayList2 = new ArrayList();
                        for (KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                            if (com.kwad.components.ad.b.a.a(((d) ksFullScreenVideoAd).getAdTemplate(), false)) {
                                arrayList2.add(ksFullScreenVideoAd);
                            }
                        }
                        if (arrayList2.isEmpty()) {
                            f fVar2 = f.Ye;
                            onError(fVar2.errorCode, fVar2.Qd);
                            return;
                        }
                        com.kwad.components.ad.reward.monitor.a.b(false, (AdTemplate) a2.get(0), a2.size(), this.ef);
                        bd.runOnUiThread(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.fullscreen.c.1.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ List aZ;
                            public final /* synthetic */ AnonymousClass1 eg;

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
                                this.eg = this;
                                this.aZ = arrayList;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    KsAdLoadManager.ab().b(this.aZ);
                                    this.eg.ee.onFullScreenVideoAdLoad(this.aZ);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
                public final void onError(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                        com.kwad.components.ad.reward.monitor.a.a(false, i, str);
                        bd.runOnUiThread(new Runnable(this, i, str) { // from class: com.kwad.components.ad.fullscreen.c.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int aW;
                            public final /* synthetic */ String aX;
                            public final /* synthetic */ AnonymousClass1 eg;

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
                                this.eg = this;
                                this.aW = i;
                                this.aX = str;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.e.b.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.aW), this.aX));
                                    this.eg.ee.onError(this.aW, this.aX);
                                }
                            }
                        });
                    }
                }
            }).oo());
        }
    }
}
