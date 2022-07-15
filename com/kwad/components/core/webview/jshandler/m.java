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
/* loaded from: classes5.dex */
public final class m implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b a;
    public final AdTemplate b;
    public com.kwad.components.core.c.a.b c;
    public final Handler d;

    @KsJson
    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public String c;
        public String d;
        public int e;
        public int f;
        public String g;
        public String h;
        public String i;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public m(com.kwad.sdk.core.webview.b bVar) {
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
        this.d = new Handler(Looper.getMainLooper());
        this.a = bVar;
        this.b = new AdTemplate();
        try {
            AdTemplate a2 = this.a.a();
            if (a2 != null) {
                if (a2.mOriginJString != null) {
                    this.b.parseJson(new JSONObject(a2.mOriginJString));
                } else {
                    this.b.parseJson(a2.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, adInfo, aVar) == null) {
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            adConversionInfo.deeplinkUrl = aVar.i;
            adConversionInfo.marketUrl = aVar.m;
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            adBaseInfo.adOperationType = aVar.a;
            adBaseInfo.appPackageName = aVar.c;
            adBaseInfo.appName = aVar.b;
            adBaseInfo.appVersion = aVar.d;
            adBaseInfo.packageSize = aVar.f;
            adBaseInfo.appIconUrl = aVar.j;
            adBaseInfo.appDescription = aVar.k;
            if (!com.kwad.sdk.core.response.a.a.I(adInfo)) {
                adInfo.adConversionInfo.h5Url = aVar.h;
                return;
            }
            AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
            String str = aVar.h;
            adConversionInfo2.appDownloadUrl = str;
            adInfo.downloadId = com.kwad.sdk.utils.z.a(str);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "handleAdUrl" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.c.a.b bVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            if (com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.i(this.b))) {
                if (this.c == null) {
                    this.c = new com.kwad.components.core.c.a.b(this.b);
                }
                bVar = this.c;
                i = 2;
            } else {
                AdInfo i2 = com.kwad.sdk.core.response.a.d.i(this.b);
                a aVar = new a();
                try {
                    aVar.parseJson(new JSONObject(str));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.a(e);
                }
                a(i2, aVar);
                if (this.c == null) {
                    this.c = new com.kwad.components.core.c.a.b(this.b);
                }
                bVar = this.c;
                i = 1;
            }
            bVar.a(i);
            this.d.post(new Runnable(this) { // from class: com.kwad.components.core.webview.jshandler.m.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.components.core.c.a.a.a(new a.C0507a(this.a.a.d.getContext()).a(this.a.b).a(this.a.c).a(new a.b(this) { // from class: com.kwad.components.core.webview.jshandler.m.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // com.kwad.components.core.c.a.a.b
                            public final void a() {
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
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.removeCallbacksAndMessages(null);
        }
    }
}
