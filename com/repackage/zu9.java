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
/* loaded from: classes7.dex */
public final class zu9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<zu9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final su9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755099373, "Lcom/repackage/zu9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755099373, "Lcom/repackage/zu9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public zu9() {
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
        su9 b2 = xu9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new av9(Looper.getMainLooper());
        }
    }

    public static zu9 a() {
        zu9 zu9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                zu9 zu9Var2 = b.get();
                if (zu9Var2 != null) {
                    return zu9Var2;
                }
                zu9Var = new zu9();
            } while (!b.compareAndSet(null, zu9Var));
            return zu9Var;
        }
        return (zu9) invokeV.objValue;
    }

    public static su9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (su9) invokeV.objValue;
    }
}
