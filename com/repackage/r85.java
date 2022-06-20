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
public class r85 extends p85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r85() {
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

    public void b(n85 n85Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, n85Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            vg a = p85.a();
            a.b("action", "time");
            a.b("ishttp", n85Var.s ? "1" : "0");
            a.b("issuccess", n85Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("wt", String.valueOf(n85Var.p));
            a.b("qt", String.valueOf(n85Var.f));
            a.b("connt", String.valueOf(n85Var.g));
            a.b("rwt", String.valueOf(n85Var.h));
            a.b("fbt", String.valueOf(n85Var.i));
            a.b("abt", String.valueOf(n85Var.j));
            a.b("dect", String.valueOf(n85Var.k));
            a.b("parset", String.valueOf(n85Var.l));
            a.b("tqt", String.valueOf(n85Var.n));
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
            if (n85Var.s) {
                a.b("hrtn", String.valueOf(n85Var.w));
                a.b("hrtt", String.valueOf(n85Var.x));
            }
            int i2 = n85Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (n85Var.y) {
                a.b(Config.PLATFORM_TYPE, "1");
            } else {
                a.b("sysct", String.valueOf(n85Var.c));
                a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(n85Var.e));
                a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(n85Var.d));
                a.b("df", String.valueOf(n85Var.m));
            }
            if (n85Var.s) {
                a.b("c_logid", String.valueOf(n85Var.A));
                long j2 = n85Var.z;
                if (j2 != 0) {
                    a.b("seq_id", String.valueOf(j2 & 4294967295L));
                }
            } else {
                a.b("seq_id", String.valueOf(n85Var.z & 4294967295L));
            }
            HashMap<String, String> hashMap = n85Var.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : n85Var.E.entrySet()) {
                    a.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void c(n85 n85Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n85Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && n85Var.D > 0) {
            vg a = p85.a();
            a.b("action", "time");
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

    public void d(n85 n85Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, n85Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || n85Var.B > 0) {
                if (z || n85Var.C > 0) {
                    vg a = p85.a();
                    a.b("action", "time");
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

    public void e(h85 h85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, h85Var) == null) && h85Var != null && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            vg a = p85.a();
            a.b("action", FpsTracer.UBC_KEY_FLUENCY);
            a.b(FpsConstants.REPORT_FPS, String.valueOf(h85Var.b()));
            BdStatisticsManager.getInstance().performance(this.a, a);
            vg a2 = p85.a();
            a2.b("action", "mem");
            a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
            BdStatisticsManager.getInstance().performance(this.a, a2);
        }
    }
}
