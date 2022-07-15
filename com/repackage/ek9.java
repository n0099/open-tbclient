package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
/* loaded from: classes6.dex */
public final class ek9 {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static ek9 b;
    public static final RootTelemetryConfiguration c;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public RootTelemetryConfiguration a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755734594, "Lcom/repackage/ek9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755734594, "Lcom/repackage/ek9;");
                return;
            }
        }
        c = new RootTelemetryConfiguration(0, false, false, 0, 0);
    }

    public ek9() {
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

    @NonNull
    public static synchronized ek9 a() {
        InterceptResult invokeV;
        ek9 ek9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (ek9.class) {
                if (b == null) {
                    b = new ek9();
                }
                ek9Var = b;
            }
            return ek9Var;
        }
        return (ek9) invokeV.objValue;
    }

    public final synchronized void b(@Nullable RootTelemetryConfiguration rootTelemetryConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rootTelemetryConfiguration) == null) {
            synchronized (this) {
                if (rootTelemetryConfiguration == null) {
                    this.a = c;
                    return;
                }
                RootTelemetryConfiguration rootTelemetryConfiguration2 = this.a;
                if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.getVersion() < rootTelemetryConfiguration.getVersion()) {
                    this.a = rootTelemetryConfiguration;
                }
            }
        }
    }
}
