package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class va4 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final ud4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public qa4 a;
    public AtomicBoolean b;
    public pa4 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755237912, "Lcom/repackage/va4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755237912, "Lcom/repackage/va4;");
                return;
            }
        }
        d = ud4.e();
    }

    public va4(AtomicBoolean atomicBoolean, qa4 qa4Var, pa4 pa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atomicBoolean, qa4Var, pa4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = atomicBoolean;
        this.a = qa4Var;
        this.c = pa4Var;
    }

    public final <T> void a(ua4<T> ua4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ua4Var) == null) {
            this.a.a(ua4Var);
            try {
                try {
                    ua4Var.run();
                } catch (Exception e) {
                    d.g("PMSTaskExecutor", "#runTask 包下载任务出错", e);
                }
            } finally {
                this.a.b(ua4Var);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.b.get()) {
                Runnable a = this.c.a(true);
                if (!(a instanceof ua4)) {
                    return;
                }
                try {
                    a((ua4) a);
                } catch (Throwable th) {
                    d.g("PMSTaskExecutor", "#run 包下载任务出错", th);
                }
            }
        }
    }
}
