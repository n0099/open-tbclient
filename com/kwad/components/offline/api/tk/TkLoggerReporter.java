package com.kwad.components.offline.api.tk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.utils.r;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class TkLoggerReporter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.offline.api.tk.TkLoggerReporter$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public final class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final TkLoggerReporter sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(627214711, "Lcom/kwad/components/offline/api/tk/TkLoggerReporter$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(627214711, "Lcom/kwad/components/offline/api/tk/TkLoggerReporter$Holder;");
                    return;
                }
            }
            sInstance = new TkLoggerReporter(null);
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public TkLoggerReporter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public /* synthetic */ TkLoggerReporter(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static TkLoggerReporter get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Holder.sInstance : (TkLoggerReporter) invokeV.objValue;
    }

    public static double getSamplingRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? OfflineHostProvider.getApi().tkLoggerSamplingRate() : invokeV.doubleValue;
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2, jSONObject) == null) {
            if (!jSONObject.has("ratio")) {
                r.putValue(jSONObject, "ratio", getSamplingRate());
            }
            OfflineHostProvider.getApi().loggerReporter().reportEvent(getSamplingRate(), str, BusinessType.TACHIKOMA, str2, jSONObject);
        }
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            reportEvent(str, "ad_tk_download_performance", jSONObject);
        }
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
            reportEvent(str, "ad_tk_render_performance", jSONObject);
        }
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) {
            reportEvent(str, "ad_tk_so_download_event", jSONObject);
        }
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jSONObject) == null) {
            reportEvent(str, "ad_tk_so_load_performence", jSONObject);
        }
    }
}
