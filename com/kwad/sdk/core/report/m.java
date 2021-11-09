package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.BaseResultData;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class m extends com.kwad.sdk.core.network.a<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
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

    private void a(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, nVar) == null) {
            try {
                List<String> i2 = nVar.i();
                for (String str : i2) {
                    KsAdSDKImpl.get().getProxyForHttp().doGetWithoutResponse(str, null);
                }
                d.a(nVar.h(), i2);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.a
    public void a(n nVar, com.kwad.sdk.core.network.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar, cVar) == null) {
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (com.ksad.download.d.b.a(KsAdSDKImpl.get().getContext())) {
                super.d();
            } else {
                com.kwad.sdk.core.d.a.e("ReportNetwork", "no network while report log");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e A[ORIG_RETURN, RETURN] */
    @Override // com.kwad.sdk.core.network.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n b2 = b();
            com.kwad.sdk.core.network.c cVar = null;
            try {
                str = b2.a();
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            try {
                cVar = KsAdSDKImpl.get().getProxyForHttp().doPost(str, (Map<String, String>) null, b2.e());
                if (cVar == null || cVar.f64797a != 200) {
                    str2 = "report fail result is null";
                } else {
                    str2 = "report success actionType:" + b2.f65020b;
                }
                com.kwad.sdk.core.d.a.a("ReportNetwork", str2);
                a(b2);
            } catch (Exception e3) {
                e = e3;
                com.kwad.sdk.core.d.a.a(e);
                if (com.kwad.sdk.b.f63999b.booleanValue()) {
                }
            }
            if (com.kwad.sdk.b.f63999b.booleanValue()) {
                return;
            }
            BaseResultData baseResultData = new BaseResultData(this) { // from class: com.kwad.sdk.core.report.ReportNetwork$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m this$0;

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

                @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
                public void parseJson(@Nullable JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        super.parseJson(jSONObject);
                    }
                }
            };
            if (cVar != null) {
                try {
                    baseResultData.parseJson(new JSONObject(cVar.f64798b));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            if (baseResultData.isResultOk()) {
                return;
            }
            throw new RuntimeException("请求返回失败 code:" + baseResultData.result + ", errorMsg:" + baseResultData.errorMsg + "\n url=" + str);
        }
    }
}
