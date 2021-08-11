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
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f73218a;

        /* renamed from: b  reason: collision with root package name */
        public String f73219b;

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
            this.f73219b = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.f73218a = false;
                this.f73219b = "数据解析失败";
                jSONObject = null;
            }
            a(jSONObject);
        }

        public void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f73218a = jSONObject.optBoolean("isValid");
            this.f73219b = jSONObject.toString();
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f73218a : invokeV.booleanValue;
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
                public final /* synthetic */ String f73216a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f73217b;

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
                    this.f73216a = ae;
                    this.f73217b = adTemplate;
                }

                private void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                        com.kwad.sdk.core.report.d.b(this.f73217b, 0, "success");
                    }
                }

                private void a(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65538, this, str) == null) {
                        com.kwad.sdk.core.report.d.b(this.f73217b, 1, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            com.kwad.sdk.core.network.c doGet = KsAdSDKImpl.get().getProxyForHttp().doGet(this.f73216a, null);
                            if (doGet == null) {
                                str = "Network Error: url invalid";
                            } else if (doGet.f71602a == 200) {
                                a aVar = new a(doGet.f71603b);
                                if (aVar.a()) {
                                    a();
                                    return;
                                }
                                str = aVar.f73219b;
                            } else {
                                str = "Network Error: " + doGet.f71603b;
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
