package com.repackage;

import android.os.Looper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class gy9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<gy9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final zx9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755661558, "Lcom/repackage/gy9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755661558, "Lcom/repackage/gy9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public gy9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        zx9 b2 = ey9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new hy9(Looper.getMainLooper());
        }
    }

    public static gy9 a() {
        gy9 gy9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                gy9 gy9Var2 = b.get();
                if (gy9Var2 != null) {
                    return gy9Var2;
                }
                gy9Var = new gy9();
            } while (!b.compareAndSet(null, gy9Var));
            return gy9Var;
        }
        return (gy9) invokeV.objValue;
    }

    public static zx9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (zx9) invokeV.objValue;
    }
}
