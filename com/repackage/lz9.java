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
public final class lz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<lz9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ez9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755511642, "Lcom/repackage/lz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755511642, "Lcom/repackage/lz9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public lz9() {
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
        ez9 b2 = jz9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new mz9(Looper.getMainLooper());
        }
    }

    public static lz9 a() {
        lz9 lz9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                lz9 lz9Var2 = b.get();
                if (lz9Var2 != null) {
                    return lz9Var2;
                }
                lz9Var = new lz9();
            } while (!b.compareAndSet(null, lz9Var));
            return lz9Var;
        }
        return (lz9) invokeV.objValue;
    }

    public static ez9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (ez9) invokeV.objValue;
    }
}
