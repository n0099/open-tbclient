package d.a.o0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class i extends j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f52171b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f52172c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f52173a;

        /* renamed from: b  reason: collision with root package name */
        public static int f52174b;

        /* renamed from: c  reason: collision with root package name */
        public static int f52175c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                d.a.c.e.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(f52173a));
                a2.b("tfailNum", String.valueOf(f52174b));
                a2.b("qfailNum", String.valueOf(f52175c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f52173a = 0;
                f52174b = 0;
                f52175c = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f52176a;

        /* renamed from: b  reason: collision with root package name */
        public static long f52177b;

        /* renamed from: c  reason: collision with root package name */
        public static long f52178c;

        /* renamed from: d  reason: collision with root package name */
        public static long f52179d;

        /* renamed from: e  reason: collision with root package name */
        public static int f52180e;

        /* renamed from: f  reason: collision with root package name */
        public static int f52181f;

        /* renamed from: g  reason: collision with root package name */
        public static long f52182g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                d.a.c.e.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f52177b));
                a2.b("dlsize", String.valueOf(f52178c));
                a2.b("dbt", String.valueOf(f52179d));
                a2.b("pnum", String.valueOf(f52180e));
                a2.b("reqcost", String.valueOf(f52182g));
                a2.b("cpu", String.valueOf(f52181f));
                a2.b("totalNum", String.valueOf(f52176a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f52176a = 0;
                f52177b = 0L;
                f52178c = 0L;
                f52179d = 0L;
                f52180e = 0;
                f52181f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(985890293, "Ld/a/o0/m0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(985890293, "Ld/a/o0/m0/i;");
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
            a.f52173a++;
            if (z2) {
                a.f52174b++;
            } else if (z3) {
                a.f52175c++;
            }
            if (a.f52173a > f52171b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.f52176a > f52172c) {
                b.a();
            }
            if (a.f52173a > f52172c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.f52176a < f52171b) {
                b.f52177b += fVar.f52152b;
                b.f52178c += fVar.f52153c;
                b.f52179d += fVar.f52154d;
                b.f52180e += fVar.f52155e;
                b.f52182g += fVar.f52156f;
                b.f52181f += fVar.f52157g;
                b.f52176a++;
                return;
            }
            b.a();
        }
    }
}
