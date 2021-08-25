package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
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
import com.kwad.sdk.utils.w;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f72332a;

    /* renamed from: b  reason: collision with root package name */
    public final AdTemplate f72333b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f72334c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f72335d;

    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72338a;

        /* renamed from: b  reason: collision with root package name */
        public String f72339b;

        /* renamed from: c  reason: collision with root package name */
        public String f72340c;

        /* renamed from: d  reason: collision with root package name */
        public String f72341d;

        /* renamed from: e  reason: collision with root package name */
        public int f72342e;

        /* renamed from: f  reason: collision with root package name */
        public int f72343f;

        /* renamed from: g  reason: collision with root package name */
        public String f72344g;

        /* renamed from: h  reason: collision with root package name */
        public String f72345h;

        /* renamed from: i  reason: collision with root package name */
        public String f72346i;

        /* renamed from: j  reason: collision with root package name */
        public String f72347j;
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
        this.f72335d = new Handler(Looper.getMainLooper());
        this.f72332a = aVar;
        AdTemplate adTemplate = new AdTemplate();
        this.f72333b = adTemplate;
        try {
            adTemplate.parseJson(this.f72332a.f72243b.mOriginJString != null ? new JSONObject(this.f72332a.f72243b.mOriginJString) : this.f72332a.f72243b.toJson());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, adInfo, aVar) == null) {
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            adConversionInfo.deeplinkUrl = aVar.f72346i;
            adConversionInfo.marketUrl = aVar.m;
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            adBaseInfo.adOperationType = aVar.f72338a;
            adBaseInfo.appPackageName = aVar.f72340c;
            adBaseInfo.appName = aVar.f72339b;
            adBaseInfo.appVersion = aVar.f72341d;
            adBaseInfo.packageSize = aVar.f72343f;
            adBaseInfo.appIconUrl = aVar.f72347j;
            adBaseInfo.appDescription = aVar.k;
            if (!com.kwad.sdk.core.response.b.a.v(adInfo)) {
                adInfo.adConversionInfo.h5Url = aVar.f72345h;
                return;
            }
            AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
            String str = aVar.f72345h;
            adConversionInfo2.appDownloadUrl = str;
            adInfo.downloadId = w.a(str);
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
        com.kwad.sdk.core.download.b.b bVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.i(this.f72333b))) {
                if (this.f72334c == null) {
                    this.f72334c = new com.kwad.sdk.core.download.b.b(this.f72333b);
                }
                bVar = this.f72334c;
                i2 = 2;
            } else {
                AdInfo i3 = com.kwad.sdk.core.response.b.c.i(this.f72333b);
                a aVar = new a();
                try {
                    aVar.parseJson(new JSONObject(str));
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                a(i3, aVar);
                if (this.f72334c == null) {
                    this.f72334c = new com.kwad.sdk.core.download.b.b(this.f72333b);
                }
                bVar = this.f72334c;
                i2 = 1;
            }
            bVar.a(i2);
            this.f72335d.post(new Runnable(this) { // from class: com.kwad.sdk.core.webview.jshandler.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ g f72336a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72336a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.download.b.a.a(this.f72336a.f72332a.f72246e.getContext(), this.f72336a.f72333b, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.core.webview.jshandler.g.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f72337a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f72337a = this;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                }
                            }
                        }, this.f72336a.f72334c, false);
                    }
                }
            });
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f72335d.removeCallbacksAndMessages(null);
        }
    }
}
