package d.a.x.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.x.b.e.c;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.x.b.d.a f68953a;

    /* renamed from: b  reason: collision with root package name */
    public c f68954b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.x.b.g.c f68955c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1153062878, "Ld/a/x/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1153062878, "Ld/a/x/b/b;");
        }
    }

    public b(d.a.x.b.g.c cVar) {
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
        this.f68955c = cVar;
        this.f68953a = new d.a.x.b.d.a(cVar.i(), 1);
        d();
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar == null) {
                this.f68954b = new d.a.x.b.e.b();
            } else {
                this.f68954b = cVar;
            }
            this.f68954b.b(this.f68955c.m(), this.f68955c.l());
        }
    }

    public void b(long j) {
        d.a.x.b.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f68954b == null || (cVar = this.f68955c) == null) {
            return;
        }
        if (cVar.o()) {
            d();
        }
        if (j != 0) {
            this.f68955c.k().k(j);
        }
        this.f68954b.a(this.f68955c.h(), this.f68955c.k());
    }

    public d.a.x.b.d.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68953a : (d.a.x.b.d.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] e2 = this.f68955c.k().e();
            d.a.x.b.h.b.b(e2);
            d.a.x.b.g.a f2 = this.f68955c.f();
            d.a.x.b.h.b.e(e2, f2.j(), f2.k());
            d.a.x.b.h.b.a(e2, f2.g());
            d.a.x.b.h.b.c(e2, f2.e());
            if ((f2.i() + 360) % 180 == 0) {
                d.a.x.b.h.b.d(e2, this.f68955c.m(), this.f68955c.l(), f2.h(), f2.f());
                return;
            }
            d.a.x.b.f.c clone = this.f68955c.l().clone();
            clone.h(this.f68955c.l().e());
            clone.g(this.f68955c.l().f());
            d.a.x.b.h.b.d(e2, this.f68955c.m(), clone, f2.h(), f2.f());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c cVar = this.f68954b;
            if (cVar != null) {
                cVar.release();
                this.f68954b = null;
            }
            d.a.x.b.d.a aVar = this.f68953a;
            if (aVar != null) {
                aVar.f();
                this.f68953a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c j = this.f68955c.j();
            this.f68954b = j;
            a(j);
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            d.a.x.b.g.c cVar2 = this.f68955c;
            if (cVar2 != null) {
                cVar2.r(cVar);
            }
            this.f68954b.release();
            a(cVar);
        }
    }
}
