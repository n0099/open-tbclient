package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public class ea2 implements ll2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue<fa2> c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ea2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-420934563, "Lcom/repackage/ea2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-420934563, "Lcom/repackage/ea2$b;");
                    return;
                }
            }
            a = new ea2(null);
        }
    }

    public /* synthetic */ ea2(a aVar) {
        this();
    }

    public static ea2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (ea2) invokeV.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.c.clear();
            }
        }
    }

    public synchronized void c(@NonNull fa2 fa2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fa2Var, str) == null) {
            synchronized (this) {
                while (this.c.size() > 0) {
                    fa2 peek = this.c.peek();
                    if (peek == null) {
                        this.c.remove();
                    } else if (peek.a()) {
                        break;
                    } else {
                        this.c.remove();
                    }
                }
                int size = this.c.size();
                if (size == 0) {
                    this.c.offer(fa2Var);
                    be3.g0(fa2Var);
                } else {
                    fa2 peek2 = this.c.peek();
                    this.c.offer(fa2Var);
                    if (size == 1 && peek2 != null && peek2.b(str)) {
                        be3.g0(fa2Var);
                    } else {
                        be3.q().post(fa2Var);
                    }
                }
            }
        }
    }

    public ea2() {
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
        this.c = new ConcurrentLinkedQueue();
    }
}
