package com.kwad.components.ad.e;

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
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ksScene, nativeAdListener) == null) {
            boolean a = m.a().a(ksScene, "loadNativeAd");
            ksScene.setAdStyle(10000);
            KsAdLoadManager.a();
            KsAdLoadManager.a(new a.C0512a().a(new com.kwad.components.core.j.kwai.b(ksScene)).b(a).a(new com.kwad.components.core.j.c(nativeAdListener) { // from class: com.kwad.components.ad.e.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLoadManager.NativeAdListener a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nativeAdListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = nativeAdListener;
                }

                @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.g
                public final void a(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                        az.a(new Runnable(this, i, str) { // from class: com.kwad.components.ad.e.b.1.1
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
                                    com.kwad.sdk.core.d.b.a("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.b));
                                    this.c.a.onError(this.a, this.b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.g
                public final void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                            if (adTemplate != null) {
                                arrayList.add(new c(adTemplate));
                            }
                        }
                        az.a(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.e.b.1.2
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
                                    this.b.a.onNativeAdLoad(this.a);
                                }
                            }
                        });
                    }
                }
            }).a());
        }
    }

    public static void a(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, nativeAdListener) == null) {
            if (m.a().a((KsScene) null, "loadNativeAdByJson") && m.a().b() == 1) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                az.a(new Runnable(nativeAdListener) { // from class: com.kwad.components.ad.e.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KsLoadManager.NativeAdListener a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {nativeAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = nativeAdListener;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.b.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                            KsLoadManager.NativeAdListener nativeAdListener2 = this.a;
                            f fVar = f.f;
                            nativeAdListener2.onError(fVar.p, fVar.q);
                        }
                    }
                });
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData();
                adResultData.parseJson(jSONObject);
                if (adResultData.result != 1) {
                    az.a(new Runnable(adResultData, nativeAdListener) { // from class: com.kwad.components.ad.e.b.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AdResultData a;
                        public final /* synthetic */ KsLoadManager.NativeAdListener b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {adResultData, nativeAdListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = adResultData;
                            this.b = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                com.kwad.sdk.core.d.b.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(this.a.result), this.a.errorMsg));
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.b;
                                AdResultData adResultData2 = this.a;
                                nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                            }
                        }
                    });
                } else if (adResultData.isAdResultDataEmpty()) {
                    az.a(new Runnable(nativeAdListener) { // from class: com.kwad.components.ad.e.b.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ KsLoadManager.NativeAdListener a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {nativeAdListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.a;
                                f fVar = f.f;
                                nativeAdListener2.onError(fVar.p, fVar.q);
                            }
                        }
                    });
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                        if (adTemplate != null) {
                            arrayList.add(new c(adTemplate));
                        }
                    }
                    az.a(new Runnable(nativeAdListener, arrayList) { // from class: com.kwad.components.ad.e.b.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ KsLoadManager.NativeAdListener a;
                        public final /* synthetic */ List b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {nativeAdListener, arrayList};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = nativeAdListener;
                            this.b = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.a.onNativeAdLoad(this.b);
                            }
                        }
                    });
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.a(e);
                f fVar = f.e;
                nativeAdListener.onError(fVar.p, fVar.q);
            }
        }
    }
}
