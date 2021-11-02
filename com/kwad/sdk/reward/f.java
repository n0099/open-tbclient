package com.kwad.sdk.reward;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f66351a;

        /* renamed from: b  reason: collision with root package name */
        public String f66352b;

        public a(String str) {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66352b = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.f66351a = false;
                this.f66352b = "数据解析失败";
                jSONObject = null;
            }
            a(jSONObject);
        }

        public void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f66351a = jSONObject.optBoolean("isValid");
            this.f66352b = jSONObject.toString();
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66351a : invokeV.booleanValue;
        }
    }

    public static void a(AdTemplate adTemplate, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, adTemplate, adInfo) == null) {
            String ae = com.kwad.sdk.core.response.b.a.ae(adInfo);
            com.kwad.sdk.core.d.a.a("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + ae);
            if (an.a(ae)) {
                return;
            }
            com.kwad.sdk.utils.g.a(new Runnable(ae, adTemplate) { // from class: com.kwad.sdk.reward.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f66349a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f66350b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ae, adTemplate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66349a = ae;
                    this.f66350b = adTemplate;
                }

                private void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                        com.kwad.sdk.core.report.d.b(this.f66350b, 0, "success");
                    }
                }

                private void a(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65538, this, str) == null) {
                        com.kwad.sdk.core.report.d.b(this.f66350b, 1, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            com.kwad.sdk.core.network.c doGet = KsAdSDKImpl.get().getProxyForHttp().doGet(this.f66349a, null);
                            if (doGet == null) {
                                str = "Network Error: url invalid";
                            } else if (doGet.f64798a == 200) {
                                a aVar = new a(doGet.f64799b);
                                if (aVar.a()) {
                                    a();
                                    return;
                                }
                                str = aVar.f66352b;
                            } else {
                                str = "Network Error: " + doGet.f64799b;
                            }
                            a(str);
                        } catch (Throwable th) {
                            a("Request Error: " + th.getMessage());
                        }
                    }
                }
            });
        }
    }
}
