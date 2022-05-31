package com.repackage;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class e85 extends c85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e85() {
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

    public void b(a85 a85Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, a85Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            rg a = c85.a();
            a.b("action", "time");
            a.b("ishttp", a85Var.s ? "1" : "0");
            a.b("issuccess", a85Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("wt", String.valueOf(a85Var.p));
            a.b("qt", String.valueOf(a85Var.f));
            a.b("connt", String.valueOf(a85Var.g));
            a.b("rwt", String.valueOf(a85Var.h));
            a.b("fbt", String.valueOf(a85Var.i));
            a.b("abt", String.valueOf(a85Var.j));
            a.b("dect", String.valueOf(a85Var.k));
            a.b("parset", String.valueOf(a85Var.l));
            a.b("tqt", String.valueOf(a85Var.n));
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
            if (a85Var.s) {
                a.b("hrtn", String.valueOf(a85Var.w));
                a.b("hrtt", String.valueOf(a85Var.x));
            }
            int i2 = a85Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (a85Var.y) {
                a.b(Config.PLATFORM_TYPE, "1");
            } else {
                a.b("sysct", String.valueOf(a85Var.c));
                a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(a85Var.e));
                a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(a85Var.d));
                a.b("df", String.valueOf(a85Var.m));
            }
            if (a85Var.s) {
                a.b("c_logid", String.valueOf(a85Var.A));
                long j2 = a85Var.z;
                if (j2 != 0) {
                    a.b("seq_id", String.valueOf(j2 & 4294967295L));
                }
            } else {
                a.b("seq_id", String.valueOf(a85Var.z & 4294967295L));
            }
            HashMap<String, String> hashMap = a85Var.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : a85Var.E.entrySet()) {
                    a.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void c(a85 a85Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a85Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && a85Var.D > 0) {
            rg a = c85.a();
            a.b("action", "time");
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

    public void d(a85 a85Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, a85Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || a85Var.B > 0) {
                if (z || a85Var.C > 0) {
                    rg a = c85.a();
                    a.b("action", "time");
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

    public void e(u75 u75Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, u75Var) == null) && u75Var != null && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            rg a = c85.a();
            a.b("action", FpsTracer.UBC_KEY_FLUENCY);
            a.b(FpsConstants.REPORT_FPS, String.valueOf(u75Var.b()));
            BdStatisticsManager.getInstance().performance(this.a, a);
            rg a2 = c85.a();
            a2.b("action", "mem");
            a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
            BdStatisticsManager.getInstance().performance(this.a, a2);
        }
    }
}
