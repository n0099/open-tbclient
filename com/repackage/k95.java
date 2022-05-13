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
/* loaded from: classes6.dex */
public class k95 extends i95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k95() {
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

    public void b(g95 g95Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, g95Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            sg a = i95.a();
            a.b("action", "time");
            a.b("ishttp", g95Var.s ? "1" : "0");
            a.b("issuccess", g95Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("wt", String.valueOf(g95Var.p));
            a.b("qt", String.valueOf(g95Var.f));
            a.b("connt", String.valueOf(g95Var.g));
            a.b("rwt", String.valueOf(g95Var.h));
            a.b("fbt", String.valueOf(g95Var.i));
            a.b("abt", String.valueOf(g95Var.j));
            a.b("dect", String.valueOf(g95Var.k));
            a.b("parset", String.valueOf(g95Var.l));
            a.b("tqt", String.valueOf(g95Var.n));
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
            if (g95Var.s) {
                a.b("hrtn", String.valueOf(g95Var.w));
                a.b("hrtt", String.valueOf(g95Var.x));
            }
            int i2 = g95Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (g95Var.y) {
                a.b(Config.PLATFORM_TYPE, "1");
            } else {
                a.b("sysct", String.valueOf(g95Var.c));
                a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(g95Var.e));
                a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(g95Var.d));
                a.b("df", String.valueOf(g95Var.m));
            }
            if (g95Var.s) {
                a.b("c_logid", String.valueOf(g95Var.A));
                long j2 = g95Var.z;
                if (j2 != 0) {
                    a.b("seq_id", String.valueOf(j2 & 4294967295L));
                }
            } else {
                a.b("seq_id", String.valueOf(g95Var.z & 4294967295L));
            }
            HashMap<String, String> hashMap = g95Var.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : g95Var.E.entrySet()) {
                    a.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void c(g95 g95Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g95Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && g95Var.D > 0) {
            sg a = i95.a();
            a.b("action", "time");
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

    public void d(g95 g95Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, g95Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || g95Var.B > 0) {
                if (z || g95Var.C > 0) {
                    sg a = i95.a();
                    a.b("action", "time");
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

    public void e(a95 a95Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, a95Var) == null) && a95Var != null && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            sg a = i95.a();
            a.b("action", FpsTracer.UBC_KEY_FLUENCY);
            a.b(FpsConstants.REPORT_FPS, String.valueOf(a95Var.b()));
            BdStatisticsManager.getInstance().performance(this.a, a);
            sg a2 = i95.a();
            a2.b("action", "mem");
            a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
            BdStatisticsManager.getInstance().performance(this.a, a2);
        }
    }
}
