package com.kwad.components.core.webview.jshandler;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class y implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAppDownloadListener KW;
    public com.kwad.sdk.core.webview.kwai.c Lb;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public final com.kwad.sdk.core.webview.b mJsBridgeContext;

    /* loaded from: classes7.dex */
    public final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double MD;
        public int status;

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

    /* loaded from: classes7.dex */
    public final class b extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String LY;
        public long MI;
        public String Ma;
        public String appName;
        public String icon;
        public String np;
        public String url;
        public String version;
        public int versionCode;

        public b() {
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

    public y(com.kwad.sdk.core.webview.b bVar) {
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
        this.mJsBridgeContext = bVar;
        try {
            this.mAdTemplate = new AdTemplate();
            AdTemplate adTemplate = this.mJsBridgeContext.getAdTemplate();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) || this.Lb == null) {
            return;
        }
        a aVar = new a();
        aVar.MD = f;
        aVar.status = i;
        this.Lb.a(aVar);
    }

    public static void a(AdInfo adInfo, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, adInfo, bVar) == null) {
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            adBaseInfo.adOperationType = 1;
            adBaseInfo.appPackageName = bVar.LY;
            adBaseInfo.appName = bVar.appName;
            adBaseInfo.appVersion = bVar.version;
            adBaseInfo.packageSize = bVar.MI;
            adBaseInfo.appIconUrl = bVar.icon;
            adBaseInfo.appDescription = bVar.np;
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            String str = bVar.url;
            adConversionInfo.appDownloadUrl = str;
            adInfo.downloadId = com.kwad.sdk.utils.ab.dI(str);
        }
    }

    private KsAppDownloadListener pu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.core.webview.jshandler.y.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y MH;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.MH = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.MH.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.MH.a(5, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.MH.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.MH.a(6, 1.0f);
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i) == null) {
                    this.MH.a(3, (i * 1.0f) / 100.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                    this.MH.a(2, (i * 1.0f) / 100.0f);
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.c.a.c cVar2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                cVar.onError(-1, "native photo is null");
                return;
            }
            if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
                if (this.mApkDownloadHelper == null) {
                    this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
                }
                cVar2 = this.mApkDownloadHelper;
                i = 2;
            } else {
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
                b bVar = new b();
                try {
                    bVar.parseJson(new JSONObject(str));
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                }
                a(bQ, bVar);
                if (this.mApkDownloadHelper == null) {
                    this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
                }
                cVar2 = this.mApkDownloadHelper;
                i = 1;
            }
            cVar2.ah(i);
            this.Lb = cVar;
            KsAppDownloadListener ksAppDownloadListener = this.KW;
            if (ksAppDownloadListener != null) {
                this.mApkDownloadHelper.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener pu = pu();
            this.KW = pu;
            this.mApkDownloadHelper.b(pu);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "registerApkStatusListener" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.Lb = null;
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar == null || (ksAppDownloadListener = this.KW) == null) {
                return;
            }
            cVar.c(ksAppDownloadListener);
            this.KW = null;
        }
    }
}
