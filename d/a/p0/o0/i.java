package d.a.p0.o0;

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
    public static int f52834b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f52835c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f52836a;

        /* renamed from: b  reason: collision with root package name */
        public static int f52837b;

        /* renamed from: c  reason: collision with root package name */
        public static int f52838c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                d.a.d.e.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(f52836a));
                a2.b("tfailNum", String.valueOf(f52837b));
                a2.b("qfailNum", String.valueOf(f52838c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f52836a = 0;
                f52837b = 0;
                f52838c = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f52839a;

        /* renamed from: b  reason: collision with root package name */
        public static long f52840b;

        /* renamed from: c  reason: collision with root package name */
        public static long f52841c;

        /* renamed from: d  reason: collision with root package name */
        public static long f52842d;

        /* renamed from: e  reason: collision with root package name */
        public static int f52843e;

        /* renamed from: f  reason: collision with root package name */
        public static int f52844f;

        /* renamed from: g  reason: collision with root package name */
        public static long f52845g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                d.a.d.e.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f52840b));
                a2.b("dlsize", String.valueOf(f52841c));
                a2.b("dbt", String.valueOf(f52842d));
                a2.b("pnum", String.valueOf(f52843e));
                a2.b("reqcost", String.valueOf(f52845g));
                a2.b("cpu", String.valueOf(f52844f));
                a2.b("totalNum", String.valueOf(f52839a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f52839a = 0;
                f52840b = 0L;
                f52841c = 0L;
                f52842d = 0L;
                f52843e = 0;
                f52844f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1564419626, "Ld/a/p0/o0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1564419626, "Ld/a/p0/o0/i;");
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
            a.f52836a++;
            if (z2) {
                a.f52837b++;
            } else if (z3) {
                a.f52838c++;
            }
            if (a.f52836a > f52834b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.f52839a > f52835c) {
                b.a();
            }
            if (a.f52836a > f52835c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.f52839a < f52834b) {
                b.f52840b += fVar.f52815b;
                b.f52841c += fVar.f52816c;
                b.f52842d += fVar.f52817d;
                b.f52843e += fVar.f52818e;
                b.f52845g += fVar.f52819f;
                b.f52844f += fVar.f52820g;
                b.f52839a++;
                return;
            }
            b.a();
        }
    }
}
