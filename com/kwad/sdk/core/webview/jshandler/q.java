package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes2.dex */
public class q implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58057b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f58058c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f58059d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f58060e;

    /* loaded from: classes2.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;

        /* renamed from: b  reason: collision with root package name */
        public int f58062b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58063b;

        /* renamed from: c  reason: collision with root package name */
        public String f58064c;

        /* renamed from: d  reason: collision with root package name */
        public int f58065d;

        /* renamed from: e  reason: collision with root package name */
        public long f58066e;

        /* renamed from: f  reason: collision with root package name */
        public String f58067f;

        /* renamed from: g  reason: collision with root package name */
        public String f58068g;

        /* renamed from: h  reason: collision with root package name */
        public String f58069h;

        /* renamed from: i  reason: collision with root package name */
        public String f58070i;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public q(com.kwad.sdk.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        try {
            this.f58060e = new AdTemplate();
            AdTemplate a2 = this.a.a();
            if (a2 != null) {
                if (a2.mOriginJString != null) {
                    this.f58060e.parseJson(new JSONObject(a2.mOriginJString));
                } else {
                    this.f58060e.parseJson(a2.toJson());
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.f58058c == null) {
            return;
        }
        a aVar = new a();
        aVar.a = f2;
        aVar.f58062b = i2;
        this.f58058c.a(aVar);
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, adInfo, bVar) == null) {
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            adBaseInfo.adOperationType = 1;
            adBaseInfo.appPackageName = bVar.f58063b;
            adBaseInfo.appName = bVar.a;
            adBaseInfo.appVersion = bVar.f58064c;
            adBaseInfo.packageSize = bVar.f58066e;
            adBaseInfo.appIconUrl = bVar.f58069h;
            adBaseInfo.appDescription = bVar.f58070i;
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            String str = bVar.f58068g;
            adConversionInfo.appDownloadUrl = str;
            adInfo.downloadId = com.kwad.sdk.utils.aa.a(str);
        }
    }

    private KsAppDownloadListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new com.kwad.sdk.core.download.a.c(this) { // from class: com.kwad.sdk.core.webview.jshandler.q.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ q f58061b;

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
                this.f58061b = this;
            }

            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    this.f58061b.a(3, (i2 * 1.0f) / 100.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f58061b.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f58061b.a(5, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f58061b.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f58061b.a(6, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                    this.f58061b.a(2, (i2 * 1.0f) / 100.0f);
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "registerApkStatusListener" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.sdk.core.download.a.b bVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            AdTemplate adTemplate = this.f58060e;
            if (adTemplate == null) {
                cVar.a(-1, "native photo is null");
                return;
            }
            if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
                if (this.f58057b == null) {
                    this.f58057b = new com.kwad.sdk.core.download.a.b(this.f58060e);
                }
                bVar = this.f58057b;
                i2 = 2;
            } else {
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f58060e);
                b bVar2 = new b();
                try {
                    bVar2.parseJson(new JSONObject(str));
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                a(j2, bVar2);
                if (this.f58057b == null) {
                    this.f58057b = new com.kwad.sdk.core.download.a.b(this.f58060e);
                }
                bVar = this.f58057b;
                i2 = 1;
            }
            bVar.a(i2);
            this.f58058c = cVar;
            KsAppDownloadListener ksAppDownloadListener = this.f58059d;
            if (ksAppDownloadListener != null) {
                this.f58057b.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener c2 = c();
            this.f58059d = c2;
            this.f58057b.a(c2);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f58058c = null;
            com.kwad.sdk.core.download.a.b bVar = this.f58057b;
            if (bVar == null || (ksAppDownloadListener = this.f58059d) == null) {
                return;
            }
            bVar.b(ksAppDownloadListener);
            this.f58059d = null;
        }
    }
}
