package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.CommercialAction;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            com.kwai.adclient.kscommerciallogger.a.a().a(new com.kwai.adclient.kscommerciallogger.kwai.a() { // from class: com.kwad.sdk.core.report.i.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.kwai.adclient.kscommerciallogger.kwai.a
                public void a(String str, String str2, Object... objArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, str2, objArr) == null) {
                        com.kwad.sdk.core.d.a.d(str, str2);
                    }
                }
            }, new com.kwai.adclient.kscommerciallogger.kwai.b() { // from class: com.kwad.sdk.core.report.i.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.kwai.adclient.kscommerciallogger.kwai.b
                public void a(@NonNull String str, @NonNull String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, str2) == null) {
                        d.a(str, str2, "ad_client_error_log".equalsIgnoreCase(str));
                    }
                }
            }, null, com.kwad.sdk.b.f57625c.booleanValue());
        }
    }

    public static void a(String str, CommercialAction.TKDownloadMsg tKDownloadMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, tKDownloadMsg) == null) {
            a(str, "ad_tk_download_performance", tKDownloadMsg.toJson());
        }
    }

    public static void a(String str, CommercialAction.TKPerformMsg tKPerformMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, tKPerformMsg) == null) {
            a(str, "ad_tk_render_performance", tKPerformMsg.toJson());
        }
    }

    public static void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, jSONObject) == null) {
            try {
                com.kwai.adclient.kscommerciallogger.a.a().a(("ad_client_error_log".equals(str) ? a.C2129a.a() : a.C2129a.b()).a(BusinessType.TACHIKOMA).a(str2).b(str2).a(jSONObject).c());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
                com.kwad.sdk.core.kwai.a.a(th);
            }
        }
    }

    public static void b(String str, CommercialAction.TKDownloadMsg tKDownloadMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, tKDownloadMsg) == null) {
            a(str, "ad_tk_so_download_event", tKDownloadMsg.toJson());
        }
    }

    public static void c(String str, CommercialAction.TKDownloadMsg tKDownloadMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, tKDownloadMsg) == null) {
            a(str, "ad_tk_so_load_performence", tKDownloadMsg.toJson());
        }
    }
}
