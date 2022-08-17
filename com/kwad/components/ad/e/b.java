package com.kwad.components.ad.e;

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
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ksScene, nativeAdListener) == null) {
            boolean a = m.oF().a(ksScene, "loadNativeAd");
            ksScene.setAdStyle(10000);
            KsAdLoadManager.ab();
            KsAdLoadManager.a(new a.C0359a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(a).a(new com.kwad.components.core.k.c(nativeAdListener) { // from class: com.kwad.components.ad.e.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLoadManager.NativeAdListener jw;

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
                    this.jw = nativeAdListener;
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
                public final void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                            if (adTemplate != null) {
                                arrayList.add(new c(adTemplate));
                            }
                        }
                        bd.runOnUiThread(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.e.b.1.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ List aZ;
                            public final /* synthetic */ AnonymousClass1 jx;

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
                                this.jx = this;
                                this.aZ = arrayList;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    KsAdLoadManager.ab().b(this.aZ);
                                    this.jx.jw.onNativeAdLoad(this.aZ);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
                public final void onError(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                        bd.runOnUiThread(new Runnable(this, i, str) { // from class: com.kwad.components.ad.e.b.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int aW;
                            public final /* synthetic */ String aX;
                            public final /* synthetic */ AnonymousClass1 jx;

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
                                this.jx = this;
                                this.aW = i;
                                this.aX = str;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.e.b.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.aW), this.aX));
                                    this.jx.jw.onError(this.aW, this.aX);
                                }
                            }
                        });
                    }
                }
            }).oo());
        }
    }

    public static void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, nativeAdListener) == null) {
            if (m.oF().a((KsScene) null, "loadNativeAdByJson") && m.oF().oG() == 1) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                bd.runOnUiThread(new Runnable(nativeAdListener) { // from class: com.kwad.components.ad.e.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KsLoadManager.NativeAdListener jw;

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
                        this.jw = nativeAdListener;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.e.b.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                            KsLoadManager.NativeAdListener nativeAdListener2 = this.jw;
                            f fVar = f.Yd;
                            nativeAdListener2.onError(fVar.errorCode, fVar.Qd);
                        }
                    }
                });
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData();
                adResultData.parseJson(jSONObject);
                if (adResultData.result != 1) {
                    bd.runOnUiThread(new Runnable(adResultData, nativeAdListener) { // from class: com.kwad.components.ad.e.b.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AdResultData fx;
                        public final /* synthetic */ KsLoadManager.NativeAdListener jw;

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
                            this.fx = adResultData;
                            this.jw = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                com.kwad.sdk.core.e.b.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(this.fx.result), this.fx.errorMsg));
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.jw;
                                AdResultData adResultData2 = this.fx;
                                nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                            }
                        }
                    });
                } else if (adResultData.isAdResultDataEmpty()) {
                    bd.runOnUiThread(new Runnable(nativeAdListener) { // from class: com.kwad.components.ad.e.b.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ KsLoadManager.NativeAdListener jw;

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
                            this.jw = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.jw;
                                f fVar = f.Yd;
                                nativeAdListener2.onError(fVar.errorCode, fVar.Qd);
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
                    bd.runOnUiThread(new Runnable(nativeAdListener, arrayList) { // from class: com.kwad.components.ad.e.b.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ List aZ;
                        public final /* synthetic */ KsLoadManager.NativeAdListener jw;

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
                            this.jw = nativeAdListener;
                            this.aZ = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.jw.onNativeAdLoad(this.aZ);
                            }
                        }
                    });
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
                f fVar = f.Yc;
                nativeAdListener.onError(fVar.errorCode, fVar.Qd);
            }
        }
    }
}
