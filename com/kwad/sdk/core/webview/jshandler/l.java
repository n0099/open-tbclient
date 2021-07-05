package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f36881a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36882b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f36883c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f36884d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36885e;

    /* loaded from: classes7.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public double f36887a;

        /* renamed from: b  reason: collision with root package name */
        public int f36888b;

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

    /* loaded from: classes7.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f36889a;

        /* renamed from: b  reason: collision with root package name */
        public String f36890b;

        /* renamed from: c  reason: collision with root package name */
        public String f36891c;

        /* renamed from: d  reason: collision with root package name */
        public int f36892d;

        /* renamed from: e  reason: collision with root package name */
        public long f36893e;

        /* renamed from: f  reason: collision with root package name */
        public String f36894f;

        /* renamed from: g  reason: collision with root package name */
        public String f36895g;

        /* renamed from: h  reason: collision with root package name */
        public String f36896h;

        /* renamed from: i  reason: collision with root package name */
        public String f36897i;

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

    public l(com.kwad.sdk.core.webview.a aVar) {
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
        this.f36881a = aVar;
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.f36885e = adTemplate;
            adTemplate.parseJson(new JSONObject(this.f36881a.f36790b.mOriginJString));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.f36883c == null) {
            return;
        }
        a aVar = new a();
        aVar.f36887a = f2;
        aVar.f36888b = i2;
        this.f36883c.a(aVar);
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, adInfo, bVar) == null) {
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            adBaseInfo.adOperationType = 1;
            adBaseInfo.appPackageName = bVar.f36890b;
            adBaseInfo.appName = bVar.f36889a;
            adBaseInfo.appVersion = bVar.f36891c;
            adBaseInfo.packageSize = bVar.f36893e;
            adBaseInfo.appIconUrl = bVar.f36896h;
            adBaseInfo.appDescription = bVar.f36897i;
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            String str = bVar.f36895g;
            adConversionInfo.appDownloadUrl = str;
            adInfo.downloadId = t.a(str);
        }
    }

    private KsAppDownloadListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) ? new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.core.webview.jshandler.l.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l f36886a;

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
                this.f36886a = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    this.f36886a.a(3, (i2 * 1.0f) / 100.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f36886a.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f36886a.a(5, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f36886a.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f36886a.a(6, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                    this.f36886a.a(2, (i2 * 1.0f) / 100.0f);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            if (this.f36881a.f36790b == null) {
                cVar.a(-1, "native photo is null");
                return;
            }
            if (this.f36882b == null) {
                AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f36885e);
                b bVar = new b();
                try {
                    bVar.parseJson(new JSONObject(str));
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                a(j, bVar);
                com.kwad.sdk.core.download.b.b bVar2 = new com.kwad.sdk.core.download.b.b(this.f36885e);
                this.f36882b = bVar2;
                bVar2.a(1);
            }
            this.f36883c = cVar;
            KsAppDownloadListener ksAppDownloadListener = this.f36884d;
            if (ksAppDownloadListener != null) {
                this.f36882b.c(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener c2 = c();
            this.f36884d = c2;
            this.f36882b.a(c2);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f36883c = null;
            com.kwad.sdk.core.download.b.b bVar = this.f36882b;
            if (bVar == null || (ksAppDownloadListener = this.f36884d) == null) {
                return;
            }
            bVar.b(ksAppDownloadListener);
            this.f36884d = null;
        }
    }
}
