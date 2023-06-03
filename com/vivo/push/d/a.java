package com.vivo.push.d;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.d.a.a.d;
import com.vivo.push.d.b.b;
import com.vivo.push.d.b.e;
import com.vivo.push.util.z;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public com.vivo.push.d.c.a b;
    public d c;
    public com.vivo.push.d.b.a d;
    public b e;
    public com.vivo.push.c.a f;

    /* renamed from: com.vivo.push.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0767a {
        public static /* synthetic */ Interceptable $ic;
        public static a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1080908108, "Lcom/vivo/push/d/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1080908108, "Lcom/vivo/push/d/a$a;");
                    return;
                }
            }
            a = new a((byte) 0);
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return C0767a.a;
        }
        return (a) invokeV.objValue;
    }

    public final synchronized Context b() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                context = this.a;
            }
            return context;
        }
        return (Context) invokeV.objValue;
    }

    public final com.vivo.push.d.c.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (com.vivo.push.d.c.a) invokeV.objValue;
    }

    public final d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (d) invokeV.objValue;
    }

    public final synchronized com.vivo.push.d.b.a e() {
        InterceptResult invokeV;
        com.vivo.push.d.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                aVar = this.d;
            }
            return aVar;
        }
        return (com.vivo.push.d.b.a) invokeV.objValue;
    }

    public final b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (b) invokeV.objValue;
    }

    public final com.vivo.push.c.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (com.vivo.push.c.a) invokeV.objValue;
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public final synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            synchronized (this) {
                if (context == null) {
                    return;
                }
                if (context != null) {
                    this.a = context;
                }
                com.vivo.push.d.b.d dVar = new com.vivo.push.d.b.d(new z(context));
                this.d = dVar;
                this.b = new com.vivo.push.d.c.b(dVar);
                this.c = new d();
                this.e = new e();
                this.f = new com.vivo.push.c.a(context);
            }
        }
    }
}
