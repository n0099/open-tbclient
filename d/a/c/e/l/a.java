package d.a.c.e.l;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f44254a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f44255b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.c.e.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C0590a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2144965160, "Ld/a/c/e/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2144965160, "Ld/a/c/e/l/a;");
                return;
            }
        }
        f44254a = new b(null);
        f44255b = new Object();
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (j.H()) {
                return f44254a.f44259d;
            }
            if (j.v()) {
                return f44254a.f44258c;
            }
            if (j.u()) {
                return f44254a.f44257b;
            }
            return f44254a.f44256a;
        }
        return (f) invokeV.objValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? 1 == i2 ? "2G" : 2 == i2 ? g.f3983b : 3 == i2 ? "4G" : 4 == i2 ? "5G" : 5 == i2 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : "N" : (String) invokeI.objValue;
    }

    public static void c(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (f44255b) {
                f a2 = a();
                if (z) {
                    a2.l++;
                    a2.m += j;
                }
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            f a2 = a();
            if (z) {
                a2.t++;
            }
            if (z2) {
                a2.u++;
            }
            if (z3) {
                a2.v++;
            }
        }
    }

    public static void e(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            f a2 = a();
            if (z) {
                a2.r++;
                a2.s += j;
            }
        }
    }

    public static void f(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (f44255b) {
                f a2 = a();
                a2.f44278d++;
                if (z) {
                    a2.f44279e++;
                    a2.f44280f += j;
                }
            }
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || f44254a.a() <= 10) {
            return;
        }
        if (f44254a.e()) {
            h(f44254a.f44259d, 5);
        }
        if (f44254a.b()) {
            h(f44254a.f44258c, 3);
        }
        if (f44254a.c()) {
            h(f44254a.f44257b, 2);
        }
        if (f44254a.d()) {
            h(f44254a.f44256a, 1);
        }
        f44254a.f();
    }

    public static void h(f fVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65544, null, fVar, i2) == null) && fVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "imgStat");
            statsItem.b("memoryCount", String.valueOf(fVar.f44275a));
            statsItem.b("memorySucCount", String.valueOf(fVar.f44276b));
            statsItem.b("memoryTime", String.valueOf(fVar.f44277c));
            statsItem.b("localCount", String.valueOf(fVar.f44278d));
            statsItem.b("localSucCount", String.valueOf(fVar.f44279e));
            statsItem.b("localTime", String.valueOf(fVar.f44280f));
            statsItem.b("netCount", String.valueOf(fVar.f44281g));
            statsItem.b("netSucCount", String.valueOf(fVar.f44282h));
            statsItem.b("netTime", String.valueOf(fVar.f44283i));
            statsItem.b("taskCount", String.valueOf(fVar.j));
            statsItem.b("taskTime", String.valueOf(fVar.k));
            statsItem.b("decodeCount", String.valueOf(fVar.l));
            statsItem.b("decodeTime", String.valueOf(fVar.m));
            statsItem.b("saveMemoryCount", String.valueOf(fVar.n));
            statsItem.b("saveMemoryTime", String.valueOf(fVar.o));
            statsItem.b("saveLocalCount", String.valueOf(fVar.p));
            statsItem.b("saveLocalTime", String.valueOf(fVar.q));
            statsItem.b("memoryHitCount", String.valueOf(fVar.t));
            statsItem.b("localHitCount", String.valueOf(fVar.u));
            statsItem.b("netHitCount", String.valueOf(fVar.v));
            statsItem.b("totalHitCount", String.valueOf(fVar.t + fVar.u + fVar.v));
            statsItem.b("totalCount", String.valueOf(fVar.r));
            statsItem.b("totalTime", String.valueOf(fVar.s));
            statsItem.b("cdnCount", String.valueOf(fVar.w));
            statsItem.b("ipCount", String.valueOf(fVar.x));
            statsItem.b("cdnAndIpCount", String.valueOf(fVar.y));
            statsItem.b("imgSize", String.valueOf(fVar.z));
            statsItem.b("nettype", b(i2));
            BdStatisticsManager.getInstance().performance("image", statsItem);
        }
    }

    public static void i(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            f a2 = a();
            a2.f44275a++;
            if (z) {
                a2.f44276b++;
                a2.f44277c += j;
            }
        }
    }

    public static void j(boolean z, String str, d.a.c.e.j.a.d dVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), str, dVar, Long.valueOf(j), Long.valueOf(j2)}) == null) && l.D()) {
            synchronized (f44255b) {
                boolean n = n(str);
                boolean z2 = false;
                if (dVar != null && !StringUtils.isNull(dVar.k)) {
                    z2 = true;
                }
                f a2 = a();
                if (n) {
                    a2.w++;
                }
                if (z2) {
                    a2.x++;
                }
                if (n && z2) {
                    a2.y++;
                }
                a2.f44281g++;
                if (z) {
                    a2.f44282h++;
                    a2.f44283i += j;
                    a2.z += j2;
                }
                if (f44254a.a() > 100) {
                    g();
                }
            }
        }
    }

    public static void k(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (f44255b) {
                f a2 = a();
                if (z) {
                    a2.p++;
                    a2.q += j;
                }
            }
        }
    }

    public static void l(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            f a2 = a();
            if (z) {
                a2.n++;
                a2.o += j;
            }
        }
    }

    public static void m(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (f44255b) {
                f a2 = a();
                if (z) {
                    a2.j++;
                    a2.k += j;
                }
            }
        }
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (str == null) {
                return false;
            }
            int indexOf = str.indexOf("hiphotos");
            if (indexOf <= 0 || indexOf >= 20) {
                int indexOf2 = str.indexOf("tiebapic");
                return indexOf2 > 0 && indexOf2 < 20;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f f44256a;

        /* renamed from: b  reason: collision with root package name */
        public f f44257b;

        /* renamed from: c  reason: collision with root package name */
        public f f44258c;

        /* renamed from: d  reason: collision with root package name */
        public f f44259d;

        public b() {
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
            this.f44256a = new f();
            this.f44257b = new f();
            this.f44258c = new f();
            this.f44259d = new f();
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f44256a.f44281g + this.f44257b.f44281g + this.f44258c.f44281g + this.f44259d.f44281g : invokeV.intValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f44258c.f44281g > 0 : invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44257b.f44281g > 0 : invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44256a.f44281g > 0 : invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f44259d.f44281g > 0 : invokeV.booleanValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f44256a.a();
                this.f44257b.a();
                this.f44258c.a();
                this.f44259d.a();
            }
        }

        public /* synthetic */ b(C0590a c0590a) {
            this();
        }
    }
}
