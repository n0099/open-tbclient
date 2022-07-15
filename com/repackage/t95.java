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
/* loaded from: classes7.dex */
public class t95 extends r95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t95() {
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

    public void b(p95 p95Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, p95Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            vg a = r95.a();
            a.b("action", "time");
            a.b("ishttp", p95Var.s ? "1" : "0");
            a.b("issuccess", p95Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("wt", String.valueOf(p95Var.p));
            a.b("qt", String.valueOf(p95Var.f));
            a.b("connt", String.valueOf(p95Var.g));
            a.b("rwt", String.valueOf(p95Var.h));
            a.b("fbt", String.valueOf(p95Var.i));
            a.b("abt", String.valueOf(p95Var.j));
            a.b("dect", String.valueOf(p95Var.k));
            a.b("parset", String.valueOf(p95Var.l));
            a.b("tqt", String.valueOf(p95Var.n));
            a.b("rendert", String.valueOf(p95Var.o));
            a.b("ss", String.valueOf(p95Var.q));
            a.b("hs", String.valueOf(p95Var.r));
            if (p95Var.s && (i = p95Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = p95Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            if (p95Var.s) {
                a.b("hrtn", String.valueOf(p95Var.w));
                a.b("hrtt", String.valueOf(p95Var.x));
            }
            int i2 = p95Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (p95Var.y) {
                a.b(Config.PLATFORM_TYPE, "1");
            } else {
                a.b("sysct", String.valueOf(p95Var.c));
                a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(p95Var.e));
                a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(p95Var.d));
                a.b("df", String.valueOf(p95Var.m));
            }
            if (p95Var.s) {
                a.b("c_logid", String.valueOf(p95Var.A));
                long j2 = p95Var.z;
                if (j2 != 0) {
                    a.b("seq_id", String.valueOf(j2 & 4294967295L));
                }
            } else {
                a.b("seq_id", String.valueOf(p95Var.z & 4294967295L));
            }
            HashMap<String, String> hashMap = p95Var.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : p95Var.E.entrySet()) {
                    a.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void c(p95 p95Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p95Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && p95Var.D > 0) {
            vg a = r95.a();
            a.b("action", "time");
            a.b("pct", String.valueOf(p95Var.D));
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

    public void d(p95 p95Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, p95Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || p95Var.B > 0) {
                if (z || p95Var.C > 0) {
                    vg a = r95.a();
                    a.b("action", "time");
                    if (z) {
                        a.b(SharedPreferenceManager.OPERATION_PUT_PERFIX, String.valueOf(p95Var.B));
                    } else {
                        a.b("pdt", String.valueOf(p95Var.C));
                    }
                    a.b("ishttp", p95Var.s ? "1" : "0");
                    a.b("issuccess", p95Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(p95Var.f));
                    a.b("connt", String.valueOf(p95Var.g));
                    a.b("rwt", String.valueOf(p95Var.h));
                    a.b("dect", String.valueOf(p95Var.k));
                    a.b("parset", String.valueOf(p95Var.l));
                    a.b("rendert", String.valueOf(p95Var.o));
                    a.b("ss", String.valueOf(p95Var.q));
                    a.b("hs", String.valueOf(p95Var.r));
                    if (p95Var.s && (i = p95Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = p95Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = p95Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public void e(j95 j95Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, j95Var) == null) && j95Var != null && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            vg a = r95.a();
            a.b("action", FpsTracer.UBC_KEY_FLUENCY);
            a.b(FpsConstants.REPORT_FPS, String.valueOf(j95Var.b()));
            BdStatisticsManager.getInstance().performance(this.a, a);
            vg a2 = r95.a();
            a2.b("action", "mem");
            a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
            BdStatisticsManager.getInstance().performance(this.a, a2);
        }
    }
}
