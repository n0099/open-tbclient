package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class p implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b Lk;
    public final Handler Ll;
    public final AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    @KsJson
    /* loaded from: classes7.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String LY;
        public int LZ;
        public String Ma;
        public String Mb;
        public String Mc;
        @Deprecated
        public boolean Md;
        public boolean Me;
        public boolean Mf;
        public String appId;
        public String appName;
        public String icon;
        public String np;
        public int type;
        public String url;
        public String version;
        public int versionCode;

        public a() {
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
    }

    public p(com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Ll = new Handler(Looper.getMainLooper());
        this.Lk = bVar;
        this.mAdTemplate = new AdTemplate();
        try {
            AdTemplate adTemplate = this.Lk.getAdTemplate();
            if (adTemplate != null) {
                if (adTemplate.mOriginJString != null) {
                    this.mAdTemplate.parseJson(new JSONObject(adTemplate.mOriginJString));
                } else {
                    this.mAdTemplate.parseJson(adTemplate.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, adInfo, aVar) == null) {
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            adConversionInfo.deeplinkUrl = aVar.Mb;
            adConversionInfo.marketUrl = aVar.Mc;
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            adBaseInfo.adOperationType = aVar.type;
            adBaseInfo.appPackageName = aVar.LY;
            adBaseInfo.appName = aVar.appName;
            adBaseInfo.appVersion = aVar.version;
            adBaseInfo.packageSize = aVar.LZ;
            adBaseInfo.appIconUrl = aVar.icon;
            adBaseInfo.appDescription = aVar.np;
            if (!com.kwad.sdk.core.response.a.a.am(adInfo)) {
                adInfo.adConversionInfo.h5Url = aVar.url;
                return;
            }
            AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
            String str = aVar.url;
            adConversionInfo2.appDownloadUrl = str;
            adInfo.downloadId = com.kwad.sdk.utils.ab.dI(str);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.c.a.c cVar2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
                if (this.mApkDownloadHelper == null) {
                    this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
                }
                cVar2 = this.mApkDownloadHelper;
                i = 2;
            } else {
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
                a aVar = new a();
                try {
                    aVar.parseJson(new JSONObject(str));
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                }
                a(bQ, aVar);
                if (this.mApkDownloadHelper == null) {
                    this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
                }
                cVar2 = this.mApkDownloadHelper;
                i = 1;
            }
            cVar2.ah(i);
            this.Ll.post(new Runnable(this) { // from class: com.kwad.components.core.webview.jshandler.p.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ p LW;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.LW = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.components.core.c.a.a.a(new a.C0569a(this.LW.Lk.Gl.getContext()).L(this.LW.mAdTemplate).b(this.LW.mApkDownloadHelper).a(new a.b(this) { // from class: com.kwad.components.core.webview.jshandler.p.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 LX;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.LX = this;
                            }

                            @Override // com.kwad.components.core.c.a.a.b
                            public final void onAdClicked() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                }
                            }
                        }));
                    }
                }
            });
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "handleAdUrl" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.Ll.removeCallbacksAndMessages(null);
        }
    }
}
