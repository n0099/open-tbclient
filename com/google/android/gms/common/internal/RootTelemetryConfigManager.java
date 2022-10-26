package com.google.android.gms.common.internal;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class RootTelemetryConfigManager {
    public static /* synthetic */ Interceptable $ic;
    public static RootTelemetryConfigManager zza;
    public static final RootTelemetryConfiguration zzb;
    public transient /* synthetic */ FieldHolder $fh;
    public RootTelemetryConfiguration zzc;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1025127675, "Lcom/google/android/gms/common/internal/RootTelemetryConfigManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1025127675, "Lcom/google/android/gms/common/internal/RootTelemetryConfigManager;");
                return;
            }
        }
        zzb = new RootTelemetryConfiguration(0, false, false, 0, 0);
    }

    public RootTelemetryConfigManager() {
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

    public static synchronized RootTelemetryConfigManager getInstance() {
        InterceptResult invokeV;
        RootTelemetryConfigManager rootTelemetryConfigManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (RootTelemetryConfigManager.class) {
                if (zza == null) {
                    zza = new RootTelemetryConfigManager();
                }
                rootTelemetryConfigManager = zza;
            }
            return rootTelemetryConfigManager;
        }
        return (RootTelemetryConfigManager) invokeV.objValue;
    }

    public RootTelemetryConfiguration getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.zzc : (RootTelemetryConfiguration) invokeV.objValue;
    }

    public final synchronized void zza(RootTelemetryConfiguration rootTelemetryConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rootTelemetryConfiguration) == null) {
            synchronized (this) {
                if (rootTelemetryConfiguration == null) {
                    this.zzc = zzb;
                    return;
                }
                RootTelemetryConfiguration rootTelemetryConfiguration2 = this.zzc;
                if (rootTelemetryConfiguration2 != null && rootTelemetryConfiguration2.getVersion() >= rootTelemetryConfiguration.getVersion()) {
                    return;
                }
                this.zzc = rootTelemetryConfiguration;
            }
        }
    }
}
