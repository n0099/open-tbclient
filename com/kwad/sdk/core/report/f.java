package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.b;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends b<ReportAction, e> {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static f f57672b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-615486341, "Lcom/kwad/sdk/core/report/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-615486341, "Lcom/kwad/sdk/core/report/f;");
                return;
            }
        }
        f57672b = new f();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(@NonNull ReportAction reportAction) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, reportAction) == null) || reportAction == null) {
            return;
        }
        if (com.kwad.sdk.b.f57044c.booleanValue()) {
            com.kwad.sdk.core.d.a.a("BatchReporter", "report actionType:" + reportAction.f57643i);
        }
        if (b(reportAction.f57643i)) {
            b(reportAction);
        } else {
            c(reportAction);
        }
    }

    public static void b(ReportAction reportAction) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, reportAction) == null) || reportAction == null) {
            return;
        }
        f57672b.b(new g<ReportAction>(reportAction) { // from class: com.kwad.sdk.core.report.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ReportAction a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {reportAction};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = reportAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.report.g
            /* renamed from: b */
            public ReportAction a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.b() : (ReportAction) invokeV.objValue;
            }
        });
    }

    public static boolean b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2)) == null) ? b.a.aU.a(j2) : invokeJ.booleanValue;
    }

    public static f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f57672b : (f) invokeV.objValue;
    }

    public static void c(ReportAction reportAction) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, reportAction) == null) || reportAction == null) {
            return;
        }
        f57672b.a(new g<ReportAction>(reportAction) { // from class: com.kwad.sdk.core.report.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ReportAction a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {reportAction};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = reportAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.report.g
            /* renamed from: b */
            public ReportAction a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.b() : (ReportAction) invokeV.objValue;
            }
        });
    }

    @Override // com.kwad.sdk.core.report.b
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || a) {
            return;
        }
        super.a(context);
        n.a(context);
        n.a();
        int a2 = com.kwad.sdk.core.config.item.c.a(context);
        com.kwad.sdk.core.d.a.a("BatchReporter", "cache type = " + a2);
        if (a2 == 2) {
            a(l.a(context));
        }
        a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b */
    public e a(List<ReportAction> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, list, z)) == null) ? z ? new com.kwad.sdk.core.report.a.a(list) : new e(list) : (e) invokeLZ.objValue;
    }
}
