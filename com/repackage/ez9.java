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
public final class ez9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<ez9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final xy9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755720179, "Lcom/repackage/ez9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755720179, "Lcom/repackage/ez9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public ez9() {
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
        xy9 b2 = cz9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new fz9(Looper.getMainLooper());
        }
    }

    public static ez9 a() {
        ez9 ez9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                ez9 ez9Var2 = b.get();
                if (ez9Var2 != null) {
                    return ez9Var2;
                }
                ez9Var = new ez9();
            } while (!b.compareAndSet(null, ez9Var));
            return ez9Var;
        }
        return (ez9) invokeV.objValue;
    }

    public static xy9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (xy9) invokeV.objValue;
    }
}
