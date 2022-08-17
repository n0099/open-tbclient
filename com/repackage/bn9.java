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
/* loaded from: classes5.dex */
public final class bn9 {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static bn9 b;
    public static final RootTelemetryConfiguration c;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public RootTelemetryConfiguration a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755821084, "Lcom/repackage/bn9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755821084, "Lcom/repackage/bn9;");
                return;
            }
        }
        c = new RootTelemetryConfiguration(0, false, false, 0, 0);
    }

    public bn9() {
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
    public static synchronized bn9 a() {
        InterceptResult invokeV;
        bn9 bn9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (bn9.class) {
                if (b == null) {
                    b = new bn9();
                }
                bn9Var = b;
            }
            return bn9Var;
        }
        return (bn9) invokeV.objValue;
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
