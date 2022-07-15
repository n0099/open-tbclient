package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.at;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;

        public a(String str) {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.a = false;
                this.b = "数据解析失败";
                jSONObject = null;
            }
            a(jSONObject);
        }

        private void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65538, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.a = jSONObject.optBoolean("isValid");
            this.b = jSONObject.toString();
        }

        public final boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.booleanValue;
        }
    }

    public static void a(AdTemplate adTemplate, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, adTemplate, adInfo) == null) {
            String au = com.kwad.sdk.core.response.a.a.au(adInfo);
            com.kwad.sdk.core.d.b.a("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + au);
            if (at.a(au)) {
                return;
            }
            com.kwad.sdk.utils.g.a(new Runnable(au, adTemplate) { // from class: com.kwad.components.ad.reward.s.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ AdTemplate b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {au, adTemplate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = au;
                    this.b = adTemplate;
                }

                private void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                        com.kwad.components.core.i.a.a().b(this.b, 0, "success");
                    }
                }

                private void a(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65538, this, str) == null) {
                        com.kwad.components.core.i.a.a().b(this.b, 1, str);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            com.kwad.sdk.core.network.c doGet = KsAdSDKImpl.get().getProxyForHttp().doGet(this.a, null);
                            if (doGet == null) {
                                str = "Network Error: url invalid";
                            } else if (doGet.a != 200) {
                                a("Network Error: " + doGet.d);
                                return;
                            } else {
                                a aVar = new a(doGet.d);
                                if (aVar.a()) {
                                    a();
                                    return;
                                }
                                str = aVar.b;
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
