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
public final class bv9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<bv9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final uu9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755813396, "Lcom/repackage/bv9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755813396, "Lcom/repackage/bv9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public bv9() {
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
        uu9 b2 = zu9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new cv9(Looper.getMainLooper());
        }
    }

    public static bv9 a() {
        bv9 bv9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                bv9 bv9Var2 = b.get();
                if (bv9Var2 != null) {
                    return bv9Var2;
                }
                bv9Var = new bv9();
            } while (!b.compareAndSet(null, bv9Var));
            return bv9Var;
        }
        return (bv9) invokeV.objValue;
    }

    public static uu9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (uu9) invokeV.objValue;
    }
}
