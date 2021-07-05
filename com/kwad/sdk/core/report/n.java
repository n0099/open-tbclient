package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.BaseResultData;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class n extends com.kwad.sdk.core.network.a<o> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n() {
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

    private void a(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, oVar) == null) {
            try {
                for (String str : oVar.g()) {
                    KsAdSDKImpl.get().getProxyForHttp().doGet(str, null);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.a
    public void a(o oVar, com.kwad.sdk.core.network.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar, cVar) == null) {
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (com.ksad.download.d.b.a(KsAdSDKImpl.get().getContext())) {
                super.d();
            } else {
                com.kwad.sdk.core.d.a.d("ReportNetwork", "no network while report log");
            }
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void f() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o b2 = b();
            com.kwad.sdk.core.network.c cVar = null;
            try {
                cVar = KsAdSDKImpl.get().getProxyForHttp().doPost(b2.a(), (Map<String, String>) null, b2.d());
                if (cVar == null || cVar.f36355a != 200) {
                    str = "report fail result is null";
                } else {
                    str = "report success actionType:" + b2.f36549b;
                }
                com.kwad.sdk.core.d.a.a("ReportNetwork", str);
                a(b2);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            if (com.kwad.sdk.a.f34045b.booleanValue()) {
                BaseResultData baseResultData = new BaseResultData(this) { // from class: com.kwad.sdk.core.report.ReportNetwork$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ n this$0;

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
                        this.this$0 = this;
                    }

                    @Override // com.kwad.sdk.core.network.BaseResultData
                    public void parseJson(@Nullable JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                            super.parseJson(jSONObject);
                        }
                    }
                };
                if (cVar != null) {
                    try {
                        baseResultData.parseJson(new JSONObject(cVar.f36356b));
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                if (baseResultData.isResultOk()) {
                    return;
                }
                throw new RuntimeException("请求返回失败 code:" + baseResultData.result + ", errorMsg:" + baseResultData.errorMsg);
            }
        }
    }
}
