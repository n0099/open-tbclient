package com.kwad.sdk.crash.report.request;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public void a(List<ReportEvent> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        new i<a, CrashReportResult>(this, list) { // from class: com.kwad.sdk.crash.report.request.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f36984a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f36985b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, list};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36985b = this;
                this.f36984a = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public CrashReportResult b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                    JSONObject jSONObject = new JSONObject(str);
                    CrashReportResult crashReportResult = new CrashReportResult();
                    crashReportResult.parseJson(jSONObject);
                    return crashReportResult;
                }
                return (CrashReportResult) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public a b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? new a(this.f36984a) : (a) invokeV.objValue;
            }
        }.a(new j<a, CrashReportResult>(this, list) { // from class: com.kwad.sdk.crash.report.request.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f36986a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f36987b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, list};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36987b = this;
                this.f36986a = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull a aVar, int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, aVar, i2, str) == null) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull a aVar, @NonNull CrashReportResult crashReportResult) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048579, this, aVar, crashReportResult) == null) {
                }
            }
        });
    }
}
