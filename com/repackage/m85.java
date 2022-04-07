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
/* loaded from: classes6.dex */
public class m85 extends t85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m85() {
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

    @Override // com.repackage.t85
    public void b(p85 p85Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, p85Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            ug a = r85.a();
            a.b("action", "time_t");
            f(a, p85Var);
            a.b("ishttp", p85Var.s ? "1" : "0");
            a.b("issuccess", p85Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(p85Var.e));
            a.b("wt", String.valueOf(p85Var.p));
            a.b("qt", String.valueOf(p85Var.f));
            a.b("connt", String.valueOf(p85Var.g));
            a.b("rwt", String.valueOf(p85Var.h));
            a.b("dect", String.valueOf(p85Var.k));
            a.b("parset", String.valueOf(p85Var.l));
            a.b("rendert", String.valueOf(p85Var.o));
            a.b("ss", String.valueOf(p85Var.q));
            a.b("hs", String.valueOf(p85Var.r));
            if (p85Var.s && (i = p85Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = p85Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = p85Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (p85Var.s) {
                a.b("c_logid", String.valueOf(p85Var.A));
            } else {
                a.b("seq_id", String.valueOf(p85Var.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // com.repackage.t85
    public void c(p85 p85Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p85Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && p85Var.D > 0) {
            ug a = r85.a();
            a.b("action", "time_t");
            f(a, p85Var);
            a.b("pct", String.valueOf(p85Var.D));
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

    @Override // com.repackage.t85
    public void d(p85 p85Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, p85Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || p85Var.B > 0) {
                if (z || p85Var.C > 0) {
                    ug a = r85.a();
                    a.b("action", "time_t");
                    f(a, p85Var);
                    if (z) {
                        a.b(SharedPreferenceManager.OPERATION_PUT_PERFIX, String.valueOf(p85Var.B));
                    } else {
                        a.b("pdt", String.valueOf(p85Var.C));
                    }
                    a.b("ishttp", p85Var.s ? "1" : "0");
                    a.b("issuccess", p85Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(p85Var.f));
                    a.b("connt", String.valueOf(p85Var.g));
                    a.b("rwt", String.valueOf(p85Var.h));
                    a.b("dect", String.valueOf(p85Var.k));
                    a.b("parset", String.valueOf(p85Var.l));
                    a.b("rendert", String.valueOf(p85Var.o));
                    a.b("ss", String.valueOf(p85Var.q));
                    a.b("hs", String.valueOf(p85Var.r));
                    if (p85Var.s && (i = p85Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = p85Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = p85Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public final void f(ug ugVar, p85 p85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, ugVar, p85Var) == null) && (p85Var instanceof l85)) {
            ugVar.c("ptype", Integer.valueOf(((l85) p85Var).F));
        }
    }
}
