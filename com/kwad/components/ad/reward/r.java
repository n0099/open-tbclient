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
import com.kwad.sdk.utils.ax;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String errorMsg;
        public boolean nQ;

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
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.nQ = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65538, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.nQ = jSONObject.optBoolean("isValid");
            this.errorMsg = jSONObject.toString();
        }

        public final boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.nQ : invokeV.booleanValue;
        }
    }

    public static void b(AdTemplate adTemplate, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, adTemplate, adInfo) == null) {
            String bd = com.kwad.sdk.core.response.a.a.bd(adInfo);
            com.kwad.sdk.core.e.b.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + bd);
            if (ax.dT(bd)) {
                return;
            }
            com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(bd, adTemplate) { // from class: com.kwad.components.ad.reward.r.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate kp;
                public final /* synthetic */ String nP;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bd, adTemplate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.nP = bd;
                    this.kp = adTemplate;
                }

                private void Q(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65537, this, str) == null) {
                        com.kwad.components.core.j.a.og().c(this.kp, 1, str);
                    }
                }

                private void fT() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65538, this) == null) {
                        com.kwad.components.core.j.a.og().c(this.kp, 0, "success");
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            com.kwad.sdk.core.network.c doGet = KsAdSDKImpl.get().getProxyForHttp().doGet(this.nP, null);
                            if (doGet == null) {
                                str = "Network Error: url invalid";
                            } else if (doGet.code != 200) {
                                Q("Network Error: " + doGet.XV);
                                return;
                            } else {
                                a aVar = new a(doGet.XV);
                                if (aVar.isValid()) {
                                    fT();
                                    return;
                                }
                                str = aVar.errorMsg;
                            }
                            Q(str);
                        } catch (Throwable th) {
                            Q("Request Error: " + th.getMessage());
                        }
                    }
                }
            });
        }
    }
}
