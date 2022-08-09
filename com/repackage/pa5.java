package com.repackage;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pa5 extends qa5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int b = 100;
    public static int c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static int a;
        public static int b;
        public static int c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                wg a2 = qa5.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(a));
                a2.b("tfailNum", String.valueOf(b));
                a2.b("qfailNum", String.valueOf(c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                b = 0;
                c = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static int a;
        public static long b;
        public static long c;
        public static long d;
        public static int e;
        public static int f;
        public static long g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                wg a2 = qa5.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(b));
                a2.b("dlsize", String.valueOf(c));
                a2.b("dbt", String.valueOf(d));
                a2.b("pnum", String.valueOf(e));
                a2.b("reqcost", String.valueOf(g));
                a2.b("cpu", String.valueOf(f));
                a2.b("totalNum", String.valueOf(a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                b = 0L;
                c = 0L;
                d = 0L;
                e = 0;
                f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755416627, "Lcom/repackage/pa5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755416627, "Lcom/repackage/pa5;");
        }
    }

    public pa5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            a.a++;
            if (z2) {
                a.b++;
            } else if (z3) {
                a.c++;
            }
            if (a.a > b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (b.a > c) {
                b.a();
            }
            if (a.a > c) {
                a.a();
            }
        }
    }

    public void c(ma5 ma5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ma5Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (b.a < b) {
                b.b += ma5Var.b;
                b.c += ma5Var.c;
                b.d += ma5Var.d;
                b.e += ma5Var.e;
                b.g += ma5Var.f;
                b.f += ma5Var.g;
                b.a++;
                return;
            }
            b.a();
        }
    }
}
