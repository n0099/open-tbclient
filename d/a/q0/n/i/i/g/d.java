package d.a.q0.n.i.i.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static d f53976b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.n.i.i.e.b f53977a;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53977a = new d.a.q0.n.i.i.e.b();
    }

    public static d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            d dVar = f53976b;
            if (dVar != null) {
                return dVar;
            }
            synchronized (d.class) {
                if (f53976b == null) {
                    f53976b = new d();
                }
            }
            return f53976b;
        }
        return (d) invokeV.objValue;
    }

    public d.a.q0.n.i.i.b a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            return new k(fVar, false);
        }
        return (d.a.q0.n.i.i.b) invokeL.objValue;
    }

    public synchronized boolean c(String str) {
        InterceptResult invokeL;
        boolean e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                e2 = this.f53977a.e(str);
            }
            return e2;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean d(String str) {
        InterceptResult invokeL;
        boolean f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                f2 = this.f53977a.f(str);
            }
            return f2;
        }
        return invokeL.booleanValue;
    }

    public synchronized void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            synchronized (this) {
                this.f53977a.c(bVar);
            }
        }
    }

    public synchronized <T> void f(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            synchronized (this) {
                fVar.r(false);
                this.f53977a.h(fVar);
            }
        }
    }

    public synchronized void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            synchronized (this) {
                this.f53977a.i(bVar);
            }
        }
    }
}
