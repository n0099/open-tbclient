package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.debug.mirror.Frame;
/* loaded from: classes6.dex */
public class fg {
    public static /* synthetic */ Interceptable $ic;
    public static b a;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964040348, "Lcom/repackage/fg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964040348, "Lcom/repackage/fg;");
                return;
            }
        }
        a = new b(null);
        b = new Object();
    }

    public static kg a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mi.H()) {
                return a.d;
            }
            if (mi.v()) {
                return a.c;
            }
            if (mi.u()) {
                return a.b;
            }
            return a.a;
        }
        return (kg) invokeV.objValue;
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? 1 == i ? "2G" : 2 == i ? "3G" : 3 == i ? "4G" : 4 == i ? "5G" : 5 == i ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : "N" : (String) invokeI.objValue;
    }

    public static void c(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (b) {
                kg a2 = a();
                if (z) {
                    a2.l++;
                    a2.m += j;
                }
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            kg a2 = a();
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
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            kg a2 = a();
            if (z) {
                a2.r++;
                a2.s += j;
            }
        }
    }

    public static void f(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (b) {
                kg a2 = a();
                a2.d++;
                if (z) {
                    a2.e++;
                    a2.f += j;
                }
            }
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || a.a() <= 10) {
            return;
        }
        if (a.e()) {
            h(a.d, 5);
        }
        if (a.b()) {
            h(a.c, 3);
        }
        if (a.c()) {
            h(a.b, 2);
        }
        if (a.d()) {
            h(a.a, 1);
        }
        a.f();
    }

    public static void h(kg kgVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65544, null, kgVar, i) == null) && kgVar != null && BdBaseApplication.getInst().isSmallFlow()) {
            ug statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "imgStat");
            statsItem.b("memoryCount", String.valueOf(kgVar.a));
            statsItem.b("memorySucCount", String.valueOf(kgVar.b));
            statsItem.b("memoryTime", String.valueOf(kgVar.c));
            statsItem.b(Frame.LOCAL_COUNT, String.valueOf(kgVar.d));
            statsItem.b("localSucCount", String.valueOf(kgVar.e));
            statsItem.b("localTime", String.valueOf(kgVar.f));
            statsItem.b("netCount", String.valueOf(kgVar.g));
            statsItem.b("netSucCount", String.valueOf(kgVar.h));
            statsItem.b("netTime", String.valueOf(kgVar.i));
            statsItem.b("taskCount", String.valueOf(kgVar.j));
            statsItem.b("taskTime", String.valueOf(kgVar.k));
            statsItem.b("decodeCount", String.valueOf(kgVar.l));
            statsItem.b("decodeTime", String.valueOf(kgVar.m));
            statsItem.b("saveMemoryCount", String.valueOf(kgVar.n));
            statsItem.b("saveMemoryTime", String.valueOf(kgVar.o));
            statsItem.b("saveLocalCount", String.valueOf(kgVar.p));
            statsItem.b("saveLocalTime", String.valueOf(kgVar.q));
            statsItem.b("memoryHitCount", String.valueOf(kgVar.t));
            statsItem.b("localHitCount", String.valueOf(kgVar.u));
            statsItem.b("netHitCount", String.valueOf(kgVar.v));
            statsItem.b("totalHitCount", String.valueOf(kgVar.t + kgVar.u + kgVar.v));
            statsItem.b("totalCount", String.valueOf(kgVar.r));
            statsItem.b("totalTime", String.valueOf(kgVar.s));
            statsItem.b("cdnCount", String.valueOf(kgVar.w));
            statsItem.b("ipCount", String.valueOf(kgVar.x));
            statsItem.b("cdnAndIpCount", String.valueOf(kgVar.y));
            statsItem.b("imgSize", String.valueOf(kgVar.z));
            statsItem.b(FpsTracer.UBC_KEY_NET_TYPE, b(i));
            BdStatisticsManager.getInstance().performance("image", statsItem);
        }
    }

    public static void i(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            kg a2 = a();
            a2.a++;
            if (z) {
                a2.b++;
                a2.c += j;
            }
        }
    }

    public static void j(boolean z, String str, nf nfVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), str, nfVar, Long.valueOf(j), Long.valueOf(j2)}) == null) && oi.C()) {
            synchronized (b) {
                boolean n = n(str);
                boolean z2 = false;
                if (nfVar != null && !StringUtils.isNull(nfVar.k)) {
                    z2 = true;
                }
                kg a2 = a();
                if (n) {
                    a2.w++;
                }
                if (z2) {
                    a2.x++;
                }
                if (n && z2) {
                    a2.y++;
                }
                a2.g++;
                if (z) {
                    a2.h++;
                    a2.i += j;
                    a2.z += j2;
                }
                if (a.a() > 100) {
                    g();
                }
            }
        }
    }

    public static void k(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (b) {
                kg a2 = a();
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
            kg a2 = a();
            if (z) {
                a2.n++;
                a2.o += j;
            }
        }
    }

    public static void m(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (b) {
                kg a2 = a();
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

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public kg a;
        public kg b;
        public kg c;
        public kg d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new kg();
            this.b = new kg();
            this.c = new kg();
            this.d = new kg();
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.g + this.b.g + this.c.g + this.d.g : invokeV.intValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.g > 0 : invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.g > 0 : invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.g > 0 : invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d.g > 0 : invokeV.booleanValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.a();
                this.b.a();
                this.c.a();
                this.d.a();
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
