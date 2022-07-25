package com.repackage;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class n95 extends u95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n95() {
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

    @Override // com.repackage.u95
    public void b(q95 q95Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, q95Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            vg a = s95.a();
            a.b("action", "time_t");
            f(a, q95Var);
            a.b("ishttp", q95Var.s ? "1" : "0");
            a.b("issuccess", q95Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(q95Var.e));
            a.b("wt", String.valueOf(q95Var.p));
            a.b("qt", String.valueOf(q95Var.f));
            a.b("connt", String.valueOf(q95Var.g));
            a.b("rwt", String.valueOf(q95Var.h));
            a.b("dect", String.valueOf(q95Var.k));
            a.b("parset", String.valueOf(q95Var.l));
            a.b("rendert", String.valueOf(q95Var.o));
            a.b("ss", String.valueOf(q95Var.q));
            a.b("hs", String.valueOf(q95Var.r));
            if (q95Var.s && (i = q95Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = q95Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = q95Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (q95Var.s) {
                a.b("c_logid", String.valueOf(q95Var.A));
            } else {
                a.b("seq_id", String.valueOf(q95Var.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // com.repackage.u95
    public void c(q95 q95Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q95Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && q95Var.D > 0) {
            vg a = s95.a();
            a.b("action", "time_t");
            f(a, q95Var);
            a.b("pct", String.valueOf(q95Var.D));
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

    @Override // com.repackage.u95
    public void d(q95 q95Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, q95Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || q95Var.B > 0) {
                if (z || q95Var.C > 0) {
                    vg a = s95.a();
                    a.b("action", "time_t");
                    f(a, q95Var);
                    if (z) {
                        a.b("put", String.valueOf(q95Var.B));
                    } else {
                        a.b("pdt", String.valueOf(q95Var.C));
                    }
                    a.b("ishttp", q95Var.s ? "1" : "0");
                    a.b("issuccess", q95Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(q95Var.f));
                    a.b("connt", String.valueOf(q95Var.g));
                    a.b("rwt", String.valueOf(q95Var.h));
                    a.b("dect", String.valueOf(q95Var.k));
                    a.b("parset", String.valueOf(q95Var.l));
                    a.b("rendert", String.valueOf(q95Var.o));
                    a.b("ss", String.valueOf(q95Var.q));
                    a.b("hs", String.valueOf(q95Var.r));
                    if (q95Var.s && (i = q95Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = q95Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = q95Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public final void f(vg vgVar, q95 q95Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, vgVar, q95Var) == null) && (q95Var instanceof m95)) {
            vgVar.c("ptype", Integer.valueOf(((m95) q95Var).F));
        }
    }
}
