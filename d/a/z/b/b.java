package d.a.z.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.z.b.e.c;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.z.b.d.a f71472a;

    /* renamed from: b  reason: collision with root package name */
    public c f71473b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.z.b.g.c f71474c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1095804576, "Ld/a/z/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1095804576, "Ld/a/z/b/b;");
        }
    }

    public b(d.a.z.b.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f71474c = cVar;
        this.f71472a = new d.a.z.b.d.a(cVar.i(), 1);
        d();
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar == null) {
                this.f71473b = new d.a.z.b.e.b();
            } else {
                this.f71473b = cVar;
            }
            this.f71473b.b(this.f71474c.m(), this.f71474c.l());
        }
    }

    public void b(long j) {
        d.a.z.b.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f71473b == null || (cVar = this.f71474c) == null) {
            return;
        }
        if (cVar.o()) {
            d();
        }
        if (j != 0) {
            this.f71474c.k().k(j);
        }
        this.f71473b.a(this.f71474c.h(), this.f71474c.k());
    }

    public d.a.z.b.d.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f71472a : (d.a.z.b.d.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] e2 = this.f71474c.k().e();
            d.a.z.b.h.b.b(e2);
            d.a.z.b.g.a f2 = this.f71474c.f();
            d.a.z.b.h.b.e(e2, f2.j(), f2.k());
            d.a.z.b.h.b.a(e2, f2.g());
            d.a.z.b.h.b.c(e2, f2.e());
            if ((f2.i() + 360) % 180 == 0) {
                d.a.z.b.h.b.d(e2, this.f71474c.m(), this.f71474c.l(), f2.h(), f2.f());
                return;
            }
            d.a.z.b.f.c clone = this.f71474c.l().clone();
            clone.h(this.f71474c.l().e());
            clone.g(this.f71474c.l().f());
            d.a.z.b.h.b.d(e2, this.f71474c.m(), clone, f2.h(), f2.f());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c cVar = this.f71473b;
            if (cVar != null) {
                cVar.release();
                this.f71473b = null;
            }
            d.a.z.b.d.a aVar = this.f71472a;
            if (aVar != null) {
                aVar.f();
                this.f71472a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c j = this.f71474c.j();
            this.f71473b = j;
            a(j);
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            d.a.z.b.g.c cVar2 = this.f71474c;
            if (cVar2 != null) {
                cVar2.r(cVar);
            }
            this.f71473b.release();
            a(cVar);
        }
    }
}
