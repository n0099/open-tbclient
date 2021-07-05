package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f36843a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f36844b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36845c;

    /* renamed from: d  reason: collision with root package name */
    public a f36846d;

    /* loaded from: classes7.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f36848a;

        /* renamed from: b  reason: collision with root package name */
        public String f36849b;

        /* renamed from: c  reason: collision with root package name */
        public String f36850c;

        /* renamed from: d  reason: collision with root package name */
        public String f36851d;

        /* renamed from: e  reason: collision with root package name */
        public int f36852e;

        /* renamed from: f  reason: collision with root package name */
        public int f36853f;

        /* renamed from: g  reason: collision with root package name */
        public String f36854g;

        /* renamed from: h  reason: collision with root package name */
        public String f36855h;

        /* renamed from: i  reason: collision with root package name */
        public String f36856i;
        public String j;
        public String k;
        public String l;
        public String m;
        @Deprecated
        public boolean n;
        public boolean o;
        public boolean p;

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

    public g(com.kwad.sdk.core.webview.a aVar) {
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
        this.f36846d = new a();
        this.f36843a = aVar;
        AdTemplate adTemplate = new AdTemplate();
        this.f36844b = adTemplate;
        try {
            adTemplate.parseJson(new JSONObject(this.f36843a.f36790b.mOriginJString));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, adInfo, aVar) == null) {
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            adConversionInfo.deeplinkUrl = aVar.f36856i;
            adConversionInfo.marketUrl = aVar.m;
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            adBaseInfo.adOperationType = aVar.f36848a;
            adBaseInfo.appPackageName = aVar.f36850c;
            adBaseInfo.appName = aVar.f36849b;
            adBaseInfo.appVersion = aVar.f36851d;
            adBaseInfo.packageSize = aVar.f36853f;
            adBaseInfo.appIconUrl = aVar.j;
            adBaseInfo.appDescription = aVar.k;
            if (!com.kwad.sdk.core.response.b.a.y(adInfo)) {
                adInfo.adConversionInfo.h5Url = aVar.f36855h;
                return;
            }
            AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
            String str = aVar.f36855h;
            adConversionInfo2.appDownloadUrl = str;
            adInfo.downloadId = t.a(str);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "handleAdUrl" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            try {
                this.f36846d.parseJson(new JSONObject(str));
                a(com.kwad.sdk.core.response.b.c.j(this.f36844b), this.f36846d);
                if (this.f36845c == null) {
                    com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.f36844b);
                    this.f36845c = bVar;
                    bVar.a(1);
                }
                com.kwad.sdk.core.download.b.a.a(this.f36843a.f36793e.getContext(), this.f36844b, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.core.webview.jshandler.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ g f36847a;

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
                        this.f36847a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        }
                    }
                }, this.f36845c);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
