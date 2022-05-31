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
/* loaded from: classes5.dex */
public final class av9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<av9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final tu9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755843187, "Lcom/repackage/av9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755843187, "Lcom/repackage/av9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public av9() {
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
        tu9 b2 = yu9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new bv9(Looper.getMainLooper());
        }
    }

    public static av9 a() {
        av9 av9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                av9 av9Var2 = b.get();
                if (av9Var2 != null) {
                    return av9Var2;
                }
                av9Var = new av9();
            } while (!b.compareAndSet(null, av9Var));
            return av9Var;
        }
        return (av9) invokeV.objValue;
    }

    public static tu9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (tu9) invokeV.objValue;
    }
}
