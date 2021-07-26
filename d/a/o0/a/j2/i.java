package d.a.o0.a.j2;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.q;
/* loaded from: classes7.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46266a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.j2.p.d f46267e;

        public a(d.a.o0.a.j2.p.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46267e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("671", this.f46267e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(511868738, "Ld/a/o0/a/j2/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(511868738, "Ld/a/o0/a/j2/i;");
                return;
            }
        }
        f46266a = d.a.o0.a.k.f46335a;
    }

    public static void a(d.a.o0.n.f.d dVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{dVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (dVar == null) {
                if (f46266a) {
                    Log.d("SwanStabilityUbc", "pms callback is null");
                    return;
                }
                return;
            }
            d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
            aVar.j(11L);
            aVar.h(2331L);
            aVar.e("Retry=" + z + ", Scene=" + dVar.getClass().getName());
            d.a.o0.a.j2.p.d dVar2 = new d.a.o0.a.j2.p.d();
            dVar2.q(k.m(i2));
            dVar2.p(aVar);
            if (dVar instanceof d.a.o0.a.h0.m.g) {
                dVar2.r(((d.a.o0.a.h0.m.g) dVar).G0());
            }
            b(dVar2);
            if (f46266a) {
                Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + dVar.getClass().getSimpleName());
            }
        }
    }

    public static void b(d.a.o0.a.j2.p.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dVar) == null) {
            if (dVar == null) {
                if (f46266a) {
                    Log.d("SwanStabilityUbc", "event is null");
                    return;
                }
                return;
            }
            q.j(new a(dVar), "SwanStabilityUBC");
        }
    }
}
