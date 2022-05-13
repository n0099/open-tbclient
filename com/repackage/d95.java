package com.repackage;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d95 extends k95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d95() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.k95
    public void b(g95 g95Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, g95Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            sg a = i95.a();
            a.b("action", "time_t");
            f(a, g95Var);
            a.b("ishttp", g95Var.s ? "1" : "0");
            a.b("issuccess", g95Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(g95Var.e));
            a.b("wt", String.valueOf(g95Var.p));
            a.b("qt", String.valueOf(g95Var.f));
            a.b("connt", String.valueOf(g95Var.g));
            a.b("rwt", String.valueOf(g95Var.h));
            a.b("dect", String.valueOf(g95Var.k));
            a.b("parset", String.valueOf(g95Var.l));
            a.b("rendert", String.valueOf(g95Var.o));
            a.b("ss", String.valueOf(g95Var.q));
            a.b("hs", String.valueOf(g95Var.r));
            if (g95Var.s && (i = g95Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = g95Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = g95Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (g95Var.s) {
                a.b("c_logid", String.valueOf(g95Var.A));
            } else {
                a.b("seq_id", String.valueOf(g95Var.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // com.repackage.k95
    public void c(g95 g95Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g95Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && g95Var.D > 0) {
            sg a = i95.a();
            a.b("action", "time_t");
            f(a, g95Var);
            a.b("pct", String.valueOf(g95Var.D));
            if (i == 0) {
                a.b("pct_type", String.valueOf(100));
            } else if (i != 40) {
                return;
            } else {
                a.b("pct_type", String.valueOf(101));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // com.repackage.k95
    public void d(g95 g95Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, g95Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || g95Var.B > 0) {
                if (z || g95Var.C > 0) {
                    sg a = i95.a();
                    a.b("action", "time_t");
                    f(a, g95Var);
                    if (z) {
                        a.b(SharedPreferenceManager.OPERATION_PUT_PERFIX, String.valueOf(g95Var.B));
                    } else {
                        a.b("pdt", String.valueOf(g95Var.C));
                    }
                    a.b("ishttp", g95Var.s ? "1" : "0");
                    a.b("issuccess", g95Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(g95Var.f));
                    a.b("connt", String.valueOf(g95Var.g));
                    a.b("rwt", String.valueOf(g95Var.h));
                    a.b("dect", String.valueOf(g95Var.k));
                    a.b("parset", String.valueOf(g95Var.l));
                    a.b("rendert", String.valueOf(g95Var.o));
                    a.b("ss", String.valueOf(g95Var.q));
                    a.b("hs", String.valueOf(g95Var.r));
                    if (g95Var.s && (i = g95Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = g95Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = g95Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public final void f(sg sgVar, g95 g95Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, sgVar, g95Var) == null) && (g95Var instanceof c95)) {
            sgVar.c("ptype", Integer.valueOf(((c95) g95Var).F));
        }
    }
}
