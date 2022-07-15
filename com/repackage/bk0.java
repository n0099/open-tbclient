package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jk0;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class bk0 implements hk0, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentLinkedQueue<jk0.b<?>> a;
    public final AtomicBoolean b;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final bk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-497646419, "Lcom/repackage/bk0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-497646419, "Lcom/repackage/bk0$a;");
                    return;
                }
            }
            a = new bk0();
        }
    }

    public bk0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentLinkedQueue<>();
        this.b = new AtomicBoolean(false);
    }

    public static hk0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (hk0) invokeV.objValue;
    }

    @Override // com.repackage.hk0
    public <T extends fk0> void a(kk0 kk0Var, ik0<T> ik0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, kk0Var, ik0Var, t) == null) {
            if (uh0.a()) {
                this.a.offer(new jk0.b<>(kk0Var, ik0Var, t));
                if (this.b.compareAndSet(false, true)) {
                    gz0.c(this, "BackgroundDeliver", 3);
                    return;
                }
                return;
            }
            ik0Var.onEvent(t);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        while (true) {
            jk0.b<?> poll = this.a.poll();
            if (poll != null) {
                poll.a.onEvent(poll.b);
            } else {
                this.b.set(false);
                return;
            }
        }
    }
}
