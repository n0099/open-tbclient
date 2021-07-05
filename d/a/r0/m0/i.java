package d.a.r0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class i extends j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f55465b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f55466c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f55467a;

        /* renamed from: b  reason: collision with root package name */
        public static int f55468b;

        /* renamed from: c  reason: collision with root package name */
        public static int f55469c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                d.a.c.e.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(f55467a));
                a2.b("tfailNum", String.valueOf(f55468b));
                a2.b("qfailNum", String.valueOf(f55469c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f55467a = 0;
                f55468b = 0;
                f55469c = 0;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f55470a;

        /* renamed from: b  reason: collision with root package name */
        public static long f55471b;

        /* renamed from: c  reason: collision with root package name */
        public static long f55472c;

        /* renamed from: d  reason: collision with root package name */
        public static long f55473d;

        /* renamed from: e  reason: collision with root package name */
        public static int f55474e;

        /* renamed from: f  reason: collision with root package name */
        public static int f55475f;

        /* renamed from: g  reason: collision with root package name */
        public static long f55476g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                d.a.c.e.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f55471b));
                a2.b("dlsize", String.valueOf(f55472c));
                a2.b("dbt", String.valueOf(f55473d));
                a2.b("pnum", String.valueOf(f55474e));
                a2.b("reqcost", String.valueOf(f55476g));
                a2.b("cpu", String.valueOf(f55475f));
                a2.b("totalNum", String.valueOf(f55470a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f55470a = 0;
                f55471b = 0L;
                f55472c = 0L;
                f55473d = 0L;
                f55474e = 0;
                f55475f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1919354002, "Ld/a/r0/m0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1919354002, "Ld/a/r0/m0/i;");
        }
    }

    public i() {
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

    public static void b(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            a.f55467a++;
            if (z2) {
                a.f55468b++;
            } else if (z3) {
                a.f55469c++;
            }
            if (a.f55467a > f55465b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.f55470a > f55466c) {
                b.a();
            }
            if (a.f55467a > f55466c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.f55470a < f55465b) {
                b.f55471b += fVar.f55446b;
                b.f55472c += fVar.f55447c;
                b.f55473d += fVar.f55448d;
                b.f55474e += fVar.f55449e;
                b.f55476g += fVar.f55450f;
                b.f55475f += fVar.f55451g;
                b.f55470a++;
                return;
            }
            b.a();
        }
    }
}
