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
public class k85 extends r85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k85() {
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

    @Override // com.repackage.r85
    public void b(n85 n85Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, n85Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            vg a = p85.a();
            a.b("action", "time_t");
            f(a, n85Var);
            a.b("ishttp", n85Var.s ? "1" : "0");
            a.b("issuccess", n85Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(n85Var.e));
            a.b("wt", String.valueOf(n85Var.p));
            a.b("qt", String.valueOf(n85Var.f));
            a.b("connt", String.valueOf(n85Var.g));
            a.b("rwt", String.valueOf(n85Var.h));
            a.b("dect", String.valueOf(n85Var.k));
            a.b("parset", String.valueOf(n85Var.l));
            a.b("rendert", String.valueOf(n85Var.o));
            a.b("ss", String.valueOf(n85Var.q));
            a.b("hs", String.valueOf(n85Var.r));
            if (n85Var.s && (i = n85Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = n85Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = n85Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (n85Var.s) {
                a.b("c_logid", String.valueOf(n85Var.A));
            } else {
                a.b("seq_id", String.valueOf(n85Var.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // com.repackage.r85
    public void c(n85 n85Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n85Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && n85Var.D > 0) {
            vg a = p85.a();
            a.b("action", "time_t");
            f(a, n85Var);
            a.b("pct", String.valueOf(n85Var.D));
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

    @Override // com.repackage.r85
    public void d(n85 n85Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, n85Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || n85Var.B > 0) {
                if (z || n85Var.C > 0) {
                    vg a = p85.a();
                    a.b("action", "time_t");
                    f(a, n85Var);
                    if (z) {
                        a.b(SharedPreferenceManager.OPERATION_PUT_PERFIX, String.valueOf(n85Var.B));
                    } else {
                        a.b("pdt", String.valueOf(n85Var.C));
                    }
                    a.b("ishttp", n85Var.s ? "1" : "0");
                    a.b("issuccess", n85Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(n85Var.f));
                    a.b("connt", String.valueOf(n85Var.g));
                    a.b("rwt", String.valueOf(n85Var.h));
                    a.b("dect", String.valueOf(n85Var.k));
                    a.b("parset", String.valueOf(n85Var.l));
                    a.b("rendert", String.valueOf(n85Var.o));
                    a.b("ss", String.valueOf(n85Var.q));
                    a.b("hs", String.valueOf(n85Var.r));
                    if (n85Var.s && (i = n85Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = n85Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = n85Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public final void f(vg vgVar, n85 n85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, vgVar, n85Var) == null) && (n85Var instanceof j85)) {
            vgVar.c("ptype", Integer.valueOf(((j85) n85Var).F));
        }
    }
}
