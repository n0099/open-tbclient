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
public final class hv9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<hv9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final av9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755634650, "Lcom/repackage/hv9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755634650, "Lcom/repackage/hv9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public hv9() {
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
        av9 b2 = fv9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new iv9(Looper.getMainLooper());
        }
    }

    public static hv9 a() {
        hv9 hv9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                hv9 hv9Var2 = b.get();
                if (hv9Var2 != null) {
                    return hv9Var2;
                }
                hv9Var = new hv9();
            } while (!b.compareAndSet(null, hv9Var));
            return hv9Var;
        }
        return (hv9) invokeV.objValue;
    }

    public static av9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (av9) invokeV.objValue;
    }
}
