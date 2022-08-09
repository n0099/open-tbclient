package com.repackage;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class sa5 extends qa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sa5() {
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

    public void b(oa5 oa5Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, oa5Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            wg a = qa5.a();
            a.b("action", "time");
            a.b("ishttp", oa5Var.s ? "1" : "0");
            a.b("issuccess", oa5Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("wt", String.valueOf(oa5Var.p));
            a.b("qt", String.valueOf(oa5Var.f));
            a.b("connt", String.valueOf(oa5Var.g));
            a.b("rwt", String.valueOf(oa5Var.h));
            a.b("fbt", String.valueOf(oa5Var.i));
            a.b("abt", String.valueOf(oa5Var.j));
            a.b("dect", String.valueOf(oa5Var.k));
            a.b("parset", String.valueOf(oa5Var.l));
            a.b("tqt", String.valueOf(oa5Var.n));
            a.b("rendert", String.valueOf(oa5Var.o));
            a.b("ss", String.valueOf(oa5Var.q));
            a.b("hs", String.valueOf(oa5Var.r));
            if (oa5Var.s && (i = oa5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = oa5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            if (oa5Var.s) {
                a.b("hrtn", String.valueOf(oa5Var.w));
                a.b("hrtt", String.valueOf(oa5Var.x));
            }
            int i2 = oa5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (oa5Var.y) {
                a.b(Config.PLATFORM_TYPE, "1");
            } else {
                a.b("sysct", String.valueOf(oa5Var.c));
                a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(oa5Var.e));
                a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(oa5Var.d));
                a.b("df", String.valueOf(oa5Var.m));
            }
            if (oa5Var.s) {
                a.b("c_logid", String.valueOf(oa5Var.A));
                long j2 = oa5Var.z;
                if (j2 != 0) {
                    a.b("seq_id", String.valueOf(j2 & 4294967295L));
                }
            } else {
                a.b("seq_id", String.valueOf(oa5Var.z & 4294967295L));
            }
            HashMap<String, String> hashMap = oa5Var.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : oa5Var.E.entrySet()) {
                    a.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void c(oa5 oa5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oa5Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && oa5Var.D > 0) {
            wg a = qa5.a();
            a.b("action", "time");
            a.b("pct", String.valueOf(oa5Var.D));
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

    public void d(oa5 oa5Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, oa5Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || oa5Var.B > 0) {
                if (z || oa5Var.C > 0) {
                    wg a = qa5.a();
                    a.b("action", "time");
                    if (z) {
                        a.b("put", String.valueOf(oa5Var.B));
                    } else {
                        a.b("pdt", String.valueOf(oa5Var.C));
                    }
                    a.b("ishttp", oa5Var.s ? "1" : "0");
                    a.b("issuccess", oa5Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(oa5Var.f));
                    a.b("connt", String.valueOf(oa5Var.g));
                    a.b("rwt", String.valueOf(oa5Var.h));
                    a.b("dect", String.valueOf(oa5Var.k));
                    a.b("parset", String.valueOf(oa5Var.l));
                    a.b("rendert", String.valueOf(oa5Var.o));
                    a.b("ss", String.valueOf(oa5Var.q));
                    a.b("hs", String.valueOf(oa5Var.r));
                    if (oa5Var.s && (i = oa5Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = oa5Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = oa5Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public void e(ia5 ia5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ia5Var) == null) && ia5Var != null && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            wg a = qa5.a();
            a.b("action", FpsTracer.UBC_KEY_FLUENCY);
            a.b(FpsConstants.REPORT_FPS, String.valueOf(ia5Var.b()));
            BdStatisticsManager.getInstance().performance(this.a, a);
            wg a2 = qa5.a();
            a2.b("action", "mem");
            a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
            BdStatisticsManager.getInstance().performance(this.a, a2);
        }
    }
}
