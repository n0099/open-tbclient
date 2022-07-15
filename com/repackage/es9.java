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
public final class es9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<es9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final xr9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755726906, "Lcom/repackage/es9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755726906, "Lcom/repackage/es9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public es9() {
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
        xr9 b2 = cs9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new fs9(Looper.getMainLooper());
        }
    }

    public static es9 a() {
        es9 es9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                es9 es9Var2 = b.get();
                if (es9Var2 != null) {
                    return es9Var2;
                }
                es9Var = new es9();
            } while (!b.compareAndSet(null, es9Var));
            return es9Var;
        }
        return (es9) invokeV.objValue;
    }

    public static xr9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (xr9) invokeV.objValue;
    }
}
