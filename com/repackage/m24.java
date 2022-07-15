package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class m24 {
    public static /* synthetic */ Interceptable $ic;
    public static final ReentrantLock c;
    public static volatile m24 d;
    public transient /* synthetic */ FieldHolder $fh;
    public List<o24> a;
    public p24 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755551198, "Lcom/repackage/m24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755551198, "Lcom/repackage/m24;");
                return;
            }
        }
        c = new ReentrantLock();
    }

    public m24() {
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
        this.a = new ArrayList(3);
    }

    public static m24 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (m24.class) {
                    if (d == null) {
                        d = new m24();
                    }
                }
            }
            return d;
        }
        return (m24) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = null;
            this.a.clear();
        }
    }

    public final void c(o24 o24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o24Var) == null) {
            c.lock();
            try {
                if (this.b != null) {
                    this.b.a(o24Var);
                } else {
                    this.a.add(o24Var);
                }
            } finally {
                c.unlock();
            }
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            hx1.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
            o24 o24Var = new o24(str);
            o24Var.hasUpdate = z;
            c(o24Var);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.isEmpty() || this.b == null) {
            return;
        }
        c.lock();
        try {
            for (o24 o24Var : this.a) {
                this.b.a(o24Var);
            }
            this.a.clear();
        } finally {
            c.unlock();
        }
    }

    public void f(p24 p24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, p24Var) == null) {
            this.b = p24Var;
            e();
        }
    }
}
