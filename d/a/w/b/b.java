package d.a.w.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.w.b.e.c;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.w.b.d.a f68275a;

    /* renamed from: b  reason: collision with root package name */
    public c f68276b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.w.b.g.c f68277c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1181692029, "Ld/a/w/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1181692029, "Ld/a/w/b/b;");
        }
    }

    public b(d.a.w.b.g.c cVar) {
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
        this.f68277c = cVar;
        this.f68275a = new d.a.w.b.d.a(cVar.i(), 1);
        d();
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar == null) {
                this.f68276b = new d.a.w.b.e.b();
            } else {
                this.f68276b = cVar;
            }
            this.f68276b.b(this.f68277c.m(), this.f68277c.l());
        }
    }

    public void b(long j) {
        d.a.w.b.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f68276b == null || (cVar = this.f68277c) == null) {
            return;
        }
        if (cVar.o()) {
            d();
        }
        if (j != 0) {
            this.f68277c.k().k(j);
        }
        this.f68276b.a(this.f68277c.h(), this.f68277c.k());
    }

    public d.a.w.b.d.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68275a : (d.a.w.b.d.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] e2 = this.f68277c.k().e();
            d.a.w.b.h.b.b(e2);
            d.a.w.b.g.a f2 = this.f68277c.f();
            d.a.w.b.h.b.e(e2, f2.j(), f2.k());
            d.a.w.b.h.b.a(e2, f2.g());
            d.a.w.b.h.b.c(e2, f2.e());
            if ((f2.i() + 360) % 180 == 0) {
                d.a.w.b.h.b.d(e2, this.f68277c.m(), this.f68277c.l(), f2.h(), f2.f());
                return;
            }
            d.a.w.b.f.c clone = this.f68277c.l().clone();
            clone.h(this.f68277c.l().e());
            clone.g(this.f68277c.l().f());
            d.a.w.b.h.b.d(e2, this.f68277c.m(), clone, f2.h(), f2.f());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c cVar = this.f68276b;
            if (cVar != null) {
                cVar.release();
                this.f68276b = null;
            }
            d.a.w.b.d.a aVar = this.f68275a;
            if (aVar != null) {
                aVar.f();
                this.f68275a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c j = this.f68277c.j();
            this.f68276b = j;
            a(j);
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            d.a.w.b.g.c cVar2 = this.f68277c;
            if (cVar2 != null) {
                cVar2.r(cVar);
            }
            this.f68276b.release();
            a(cVar);
        }
    }
}
