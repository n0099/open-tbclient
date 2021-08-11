package com.bytedance.sdk.openadsdk.j.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.a.b;
import com.bytedance.sdk.component.d.c;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.o;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    @Override // com.bytedance.sdk.component.d.c
    public void a(com.bytedance.sdk.component.d.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || !o.h().v() || cVar == null || cVar.a() == null) {
            return;
        }
        JSONObject a2 = cVar.a();
        com.bytedance.sdk.openadsdk.j.a.a().a("tt_pangle_thread_pool", a2);
        k.b("ReportThreadLogServiceI", "execReportSdkThreadLog: ", a2);
        k.c("ReportThreadLogServiceI", "execReportThreadPoolLog: " + a2);
    }

    @Override // com.bytedance.sdk.component.d.c
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || !o.h().v() || bVar == null || bVar.a() == null) {
            return;
        }
        JSONObject a2 = bVar.a();
        com.bytedance.sdk.openadsdk.j.a.a().a("tt_pangle_sdk_thread_state", a2);
        k.b("ReportThreadLogServiceI", "execReportSdkThreadLog: ", a2);
    }
}
