package d.a.q0.a.r1.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class f implements e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50402c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f50403d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile d f50404a;

    /* renamed from: b  reason: collision with root package name */
    public volatile d.a.q0.a.r1.o.a f50405b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1019267888, "Ld/a/q0/a/r1/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1019267888, "Ld/a/q0/a/r1/k/f;");
                return;
            }
        }
        f50402c = k.f49133a;
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        k();
    }

    public static f j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f50403d == null) {
                synchronized (f.class) {
                    if (f50403d == null) {
                        f50403d = new f();
                    }
                }
            }
            return f50403d;
        }
        return (f) invokeV.objValue;
    }

    @Override // d.a.q0.a.r1.k.e
    public void b(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && m()) {
            if (f50402c) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.f50404a.b(j);
            this.f50405b.b(j);
        }
    }

    @Override // d.a.q0.a.r1.k.e
    public void c(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && m()) {
            if (f50402c) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.f50404a.c(j);
            this.f50405b.c(j);
            o(j);
        }
    }

    public d i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50404a : (d) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f50404a == null) {
                this.f50404a = new b();
            }
            if (this.f50405b == null) {
                this.f50405b = new d.a.q0.a.r1.o.c();
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (f50402c) {
                return true;
            }
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q == null) {
                return false;
            }
            String appId = Q.getAppId();
            return (TextUtils.isEmpty(appId) || d.a.q0.a.v.a.b(appId) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l() : invokeV.booleanValue;
    }

    public d.a.q0.a.r1.o.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f50405b : (d.a.q0.a.r1.o.a) invokeV.objValue;
    }

    public final void o(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            d.a.q0.a.q2.d.f50164i.d(Long.valueOf(j));
        }
    }
}
