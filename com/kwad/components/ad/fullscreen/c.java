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
import com.kwad.components.core.j.kwai.a;
import com.kwad.components.core.l.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ksScene, fullScreenVideoAdListener) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.reward.monitor.a.a(false, elapsedRealtime);
            boolean a = m.a().a(ksScene, "loadFullScreenVideoAd");
            ksScene.setAdStyle(3);
            KsAdLoadManager.a();
            KsAdLoadManager.a(new a.C0512a().a(new com.kwad.components.core.j.kwai.b(ksScene)).b(a).a(new com.kwad.components.core.j.c(fullScreenVideoAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.components.ad.fullscreen.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLoadManager.FullScreenVideoAdListener a;
                public final /* synthetic */ KsScene b;
                public final /* synthetic */ long c;

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
                    this.a = fullScreenVideoAdListener;
                    this.b = ksScene;
                    this.c = elapsedRealtime;
                }

                @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.g
                public final void a(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                        com.kwad.components.ad.reward.monitor.a.a(false, i, str);
                        az.a(new Runnable(this, i, str) { // from class: com.kwad.components.ad.fullscreen.c.1.1
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
                                    com.kwad.sdk.core.d.b.a("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.b));
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
                        List<AdTemplate> b = c.b(this.b, adResultData.getAdTemplateList());
                        if (b.isEmpty()) {
                            f fVar = f.f;
                            a(fVar.p, fVar.q);
                            return;
                        }
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                        for (AdTemplate adTemplate : b) {
                            arrayList.add(new d(adTemplate));
                            adTemplate.mLoadDataTime = elapsedRealtime2;
                            adTemplate.mLoadFromCache = z;
                        }
                        com.kwad.components.ad.reward.monitor.a.a(false, (AdTemplate) b.get(0), b.size(), this.c);
                        az.a(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.fullscreen.c.1.2
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
                                        this.b.a.onFullScreenVideoResult(this.a);
                                    } catch (Throwable unused) {
                                    }
                                    try {
                                        q.a((Object) this.b.a, "onRequestResult", Integer.valueOf(this.a.size()));
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        });
                        ArrayList arrayList2 = new ArrayList();
                        for (KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                            if (com.kwad.components.ad.b.a.a(((d) ksFullScreenVideoAd).a(), false)) {
                                arrayList2.add(ksFullScreenVideoAd);
                            }
                        }
                        if (arrayList2.isEmpty()) {
                            f fVar2 = f.g;
                            a(fVar2.p, fVar2.q);
                            return;
                        }
                        com.kwad.components.ad.reward.monitor.a.b(false, (AdTemplate) b.get(0), b.size(), this.c);
                        az.a(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.fullscreen.c.1.3
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
                                    this.b.a.onFullScreenVideoAdLoad(this.a);
                                }
                            }
                        });
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
                    if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.i(adTemplate)))) {
                        arrayList.add(adTemplate);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
