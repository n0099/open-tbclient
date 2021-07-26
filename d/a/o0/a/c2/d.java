package d.a.o0.a.c2;

import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.c2.f.g;
import d.a.o0.a.c2.f.w;
import d.a.o0.a.k;
import d.a.o0.a.p0.f.d.f;
import d.a.o0.a.p0.f.d.h;
import d.a.o0.a.p0.f.d.i;
import d.a.o0.a.p0.f.d.j;
import java.util.List;
@Service
/* loaded from: classes7.dex */
public class d extends e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44083b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(505403936, "Ld/a/o0/a/c2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(505403936, "Ld/a/o0/a/c2/d;");
                return;
            }
        }
        f44083b = k.f46335a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.a.o0.a.c2.e
    public void a() {
        List<a0> b2;
        List<a0> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f44084a.clear();
            b(new d.a.o0.a.f1.a(this));
            b(new d.a.o0.a.e0.f.e.a(this));
            b(new d.a.o0.a.e0.f.f.a(this));
            b(new d.a.o0.a.e0.f.d.a(this));
            b(new w(this));
            b(new g(this));
            b(new d.a.o0.a.c2.f.n0.a(this));
            b(new d.a.o0.a.p0.f.d.a(this));
            b(new h(this));
            b(new d.a.o0.a.p0.f.d.b(this));
            b(new d.a.o0.a.p0.f.d.e(this));
            b(new f(this));
            b(new d.a.o0.a.p0.f.d.d(this));
            b(new i(this));
            b(new d.a.o0.a.p0.f.d.c(this));
            b(new d.a.o0.a.p0.f.d.g(this));
            d.a.o0.a.p.b.a.b d2 = d.a.o0.a.c1.b.d();
            if (d2 != null && (a2 = d2.a(this)) != null && !a2.isEmpty()) {
                for (a0 a0Var : a2) {
                    b(a0Var);
                }
            }
            if (f44083b) {
                b(new j(this));
                b(new d.a.o0.a.c2.f.a(this));
                if (d2 == null || (b2 = d2.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (a0 a0Var2 : b2) {
                    b(a0Var2);
                }
            }
        }
    }
}
