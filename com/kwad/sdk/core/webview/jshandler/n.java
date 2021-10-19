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
import com.kwad.sdk.utils.w;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class n implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f72926a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f72927b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f72928c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f72929d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f72930e;

    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public double f72932a;

        /* renamed from: b  reason: collision with root package name */
        public int f72933b;

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

    /* loaded from: classes10.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f72934a;

        /* renamed from: b  reason: collision with root package name */
        public String f72935b;

        /* renamed from: c  reason: collision with root package name */
        public String f72936c;

        /* renamed from: d  reason: collision with root package name */
        public int f72937d;

        /* renamed from: e  reason: collision with root package name */
        public long f72938e;

        /* renamed from: f  reason: collision with root package name */
        public String f72939f;

        /* renamed from: g  reason: collision with root package name */
        public String f72940g;

        /* renamed from: h  reason: collision with root package name */
        public String f72941h;

        /* renamed from: i  reason: collision with root package name */
        public String f72942i;

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

    public n(com.kwad.sdk.core.webview.a aVar) {
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
        this.f72926a = aVar;
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.f72930e = adTemplate;
            adTemplate.parseJson(this.f72926a.f72777b.mOriginJString != null ? new JSONObject(this.f72926a.f72777b.mOriginJString) : this.f72926a.f72777b.toJson());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.f72928c == null) {
            return;
        }
        a aVar = new a();
        aVar.f72932a = f2;
        aVar.f72933b = i2;
        this.f72928c.a(aVar);
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, adInfo, bVar) == null) {
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            adBaseInfo.adOperationType = 1;
            adBaseInfo.appPackageName = bVar.f72935b;
            adBaseInfo.appName = bVar.f72934a;
            adBaseInfo.appVersion = bVar.f72936c;
            adBaseInfo.packageSize = bVar.f72938e;
            adBaseInfo.appIconUrl = bVar.f72941h;
            adBaseInfo.appDescription = bVar.f72942i;
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            String str = bVar.f72940g;
            adConversionInfo.appDownloadUrl = str;
            adInfo.downloadId = w.a(str);
        }
    }

    private KsAppDownloadListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.core.webview.jshandler.n.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ n f72931b;

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
                this.f72931b = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    this.f72931b.a(3, (i2 * 1.0f) / 100.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f72931b.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f72931b.a(5, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f72931b.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f72931b.a(6, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                    this.f72931b.a(2, (i2 * 1.0f) / 100.0f);
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "registerApkStatusListener" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        com.kwad.sdk.core.download.b.b bVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            AdTemplate adTemplate = this.f72930e;
            if (adTemplate == null) {
                cVar.a(-1, "native photo is null");
                return;
            }
            if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.i(adTemplate))) {
                if (this.f72927b == null) {
                    this.f72927b = new com.kwad.sdk.core.download.b.b(this.f72930e);
                }
                bVar = this.f72927b;
                i2 = 2;
            } else {
                AdInfo i3 = com.kwad.sdk.core.response.b.c.i(this.f72930e);
                b bVar2 = new b();
                try {
                    bVar2.parseJson(new JSONObject(str));
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                a(i3, bVar2);
                if (this.f72927b == null) {
                    this.f72927b = new com.kwad.sdk.core.download.b.b(this.f72930e);
                }
                bVar = this.f72927b;
                i2 = 1;
            }
            bVar.a(i2);
            this.f72928c = cVar;
            KsAppDownloadListener ksAppDownloadListener = this.f72929d;
            if (ksAppDownloadListener != null) {
                this.f72927b.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener c2 = c();
            this.f72929d = c2;
            this.f72927b.a(c2);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f72928c = null;
            com.kwad.sdk.core.download.b.b bVar = this.f72927b;
            if (bVar == null || (ksAppDownloadListener = this.f72929d) == null) {
                return;
            }
            bVar.b(ksAppDownloadListener);
            this.f72929d = null;
        }
    }
}
