package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class o extends com.kwad.sdk.core.network.a<p> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReportResultData a;

    public o() {
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

    @NonNull
    private ReportResultData a(com.kwad.sdk.core.network.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cVar)) == null) {
            if (this.a == null) {
                this.a = new ReportResultData(this) { // from class: com.kwad.sdk.core.report.ReportNetwork$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ o this$0;

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
            }
            if (cVar != null) {
                try {
                    this.a.parseJson(new JSONObject(cVar.f58087b));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return this.a;
        }
        return (ReportResultData) invokeL.objValue;
    }

    private void a(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, pVar) == null) {
            try {
                List<String> j2 = pVar.j();
                for (String str : j2) {
                    KsAdSDKImpl.get().getProxyForHttp().doGetWithoutResponse(str, null);
                }
                d.a(pVar.i(), j2);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.a
    public void a(p pVar, com.kwad.sdk.core.network.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar, cVar) == null) {
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (com.ksad.download.c.b.a(KsAdSDKImpl.get().getContext())) {
                super.d();
            } else {
                com.kwad.sdk.core.d.a.e("ReportNetwork", "no network while report log");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    @Override // com.kwad.sdk.core.network.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f() {
        String str;
        ReportResultData a;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            p b2 = b();
            com.kwad.sdk.core.network.c cVar = null;
            try {
                str = b2.a();
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            try {
                cVar = KsAdSDKImpl.get().getProxyForHttp().doPost(str, (Map<String, String>) null, b2.e());
                if (cVar == null || cVar.a != 200) {
                    str2 = "report fail result is null";
                } else {
                    str2 = "report success actionType:" + b2.f58258b;
                }
                com.kwad.sdk.core.d.a.a("ReportNetwork", str2);
            } catch (Exception e3) {
                e = e3;
                com.kwad.sdk.core.d.a.a(e);
                a = a(cVar);
                if (a.isCheatingFlow()) {
                }
                if (!b2.i().mCheatingFlow) {
                }
                if (com.kwad.sdk.b.f57625c.booleanValue()) {
                    return;
                }
                return;
            }
            a = a(cVar);
            if (a.isCheatingFlow()) {
                b2.i().setCheatingFlow(a.isCheatingFlow());
            }
            if (!b2.i().mCheatingFlow) {
                a(b2);
            }
            if (com.kwad.sdk.b.f57625c.booleanValue() || a.isResultOk()) {
                return;
            }
            throw new RuntimeException("请求返回失败 code:" + a.result + ", errorMsg:" + a.errorMsg + "\n url=" + str);
        }
    }
}
