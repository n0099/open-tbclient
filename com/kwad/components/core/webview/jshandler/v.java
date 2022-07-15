package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class v implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b a;
    public com.kwad.components.core.c.a.b b;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c c;
    @Nullable
    public KsAppDownloadListener d;
    public AdTemplate e;

    @KsJson
    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;
        public int b;

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

    @KsJson
    /* loaded from: classes5.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public int d;
        public long e;
        public String f;
        public String g;
        public String h;
        public String i;

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

    public v(com.kwad.sdk.core.webview.b bVar) {
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
        this.a = bVar;
        try {
            this.e = new AdTemplate();
            AdTemplate a2 = this.a.a();
            if (a2 != null) {
                if (a2.mOriginJString != null) {
                    this.e.parseJson(new JSONObject(a2.mOriginJString));
                } else {
                    this.e.parseJson(a2.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) || this.c == null) {
            return;
        }
        a aVar = new a();
        aVar.a = f;
        aVar.b = i;
        this.c.a(aVar);
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, adInfo, bVar) == null) {
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            adBaseInfo.adOperationType = 1;
            adBaseInfo.appPackageName = bVar.b;
            adBaseInfo.appName = bVar.a;
            adBaseInfo.appVersion = bVar.c;
            adBaseInfo.packageSize = bVar.e;
            adBaseInfo.appIconUrl = bVar.h;
            adBaseInfo.appDescription = bVar.i;
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            String str = bVar.g;
            adConversionInfo.appDownloadUrl = str;
            adInfo.downloadId = com.kwad.sdk.utils.z.a(str);
        }
    }

    private KsAppDownloadListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.core.webview.jshandler.v.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ v a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void a(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                    this.a.a(3, (i * 1.0f) / 100.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.a(5, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.a.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.a.a(6, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                    this.a.a(2, (i * 1.0f) / 100.0f);
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "registerApkStatusListener" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.c.a.b bVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            AdTemplate adTemplate = this.e;
            if (adTemplate == null) {
                cVar.a(-1, "native photo is null");
                return;
            }
            if (com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.i(adTemplate))) {
                if (this.b == null) {
                    this.b = new com.kwad.components.core.c.a.b(this.e);
                }
                bVar = this.b;
                i = 2;
            } else {
                AdInfo i2 = com.kwad.sdk.core.response.a.d.i(this.e);
                b bVar2 = new b();
                try {
                    bVar2.parseJson(new JSONObject(str));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.a(e);
                }
                a(i2, bVar2);
                if (this.b == null) {
                    this.b = new com.kwad.components.core.c.a.b(this.e);
                }
                bVar = this.b;
                i = 1;
            }
            bVar.a(i);
            this.c = cVar;
            KsAppDownloadListener ksAppDownloadListener = this.d;
            if (ksAppDownloadListener != null) {
                this.b.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener c = c();
            this.d = c;
            this.b.a(c);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = null;
            com.kwad.components.core.c.a.b bVar = this.b;
            if (bVar == null || (ksAppDownloadListener = this.d) == null) {
                return;
            }
            bVar.b(ksAppDownloadListener);
            this.d = null;
        }
    }
}
