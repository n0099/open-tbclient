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
/* loaded from: classes7.dex */
public class x75 extends e85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x75() {
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

    @Override // com.repackage.e85
    public void b(a85 a85Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, a85Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            rg a = c85.a();
            a.b("action", "time_t");
            f(a, a85Var);
            a.b("ishttp", a85Var.s ? "1" : "0");
            a.b("issuccess", a85Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(a85Var.e));
            a.b("wt", String.valueOf(a85Var.p));
            a.b("qt", String.valueOf(a85Var.f));
            a.b("connt", String.valueOf(a85Var.g));
            a.b("rwt", String.valueOf(a85Var.h));
            a.b("dect", String.valueOf(a85Var.k));
            a.b("parset", String.valueOf(a85Var.l));
            a.b("rendert", String.valueOf(a85Var.o));
            a.b("ss", String.valueOf(a85Var.q));
            a.b("hs", String.valueOf(a85Var.r));
            if (a85Var.s && (i = a85Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = a85Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = a85Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (a85Var.s) {
                a.b("c_logid", String.valueOf(a85Var.A));
            } else {
                a.b("seq_id", String.valueOf(a85Var.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // com.repackage.e85
    public void c(a85 a85Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a85Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && a85Var.D > 0) {
            rg a = c85.a();
            a.b("action", "time_t");
            f(a, a85Var);
            a.b("pct", String.valueOf(a85Var.D));
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

    @Override // com.repackage.e85
    public void d(a85 a85Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, a85Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || a85Var.B > 0) {
                if (z || a85Var.C > 0) {
                    rg a = c85.a();
                    a.b("action", "time_t");
                    f(a, a85Var);
                    if (z) {
                        a.b(SharedPreferenceManager.OPERATION_PUT_PERFIX, String.valueOf(a85Var.B));
                    } else {
                        a.b("pdt", String.valueOf(a85Var.C));
                    }
                    a.b("ishttp", a85Var.s ? "1" : "0");
                    a.b("issuccess", a85Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(a85Var.f));
                    a.b("connt", String.valueOf(a85Var.g));
                    a.b("rwt", String.valueOf(a85Var.h));
                    a.b("dect", String.valueOf(a85Var.k));
                    a.b("parset", String.valueOf(a85Var.l));
                    a.b("rendert", String.valueOf(a85Var.o));
                    a.b("ss", String.valueOf(a85Var.q));
                    a.b("hs", String.valueOf(a85Var.r));
                    if (a85Var.s && (i = a85Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = a85Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = a85Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public final void f(rg rgVar, a85 a85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, rgVar, a85Var) == null) && (a85Var instanceof w75)) {
            rgVar.c("ptype", Integer.valueOf(((w75) a85Var).F));
        }
    }
}
