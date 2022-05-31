package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ETAG;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class ba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, int i, int i2, String str2, int i3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2, Integer.valueOf(i3), str3}) == null) {
            b(str, i, -1L, i2, str2, i3, str3);
        }
    }

    public static void b(String str, int i, long j, int i2, String str2, int i3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), str2, Integer.valueOf(i3), str3}) == null) {
            StringBuilder sb = new StringBuilder(50);
            if (i != 0 && i2 != 0) {
                sb.append("cmd = ");
                sb.append(i);
                sb.append("\t");
                sb.append("sequence = ");
                sb.append(i2);
                sb.append("\t");
            }
            sb.append(str3);
            try {
                LinkedList linkedList = new LinkedList();
                linkedList.add("lib");
                linkedList.add(str);
                if (i != 0) {
                    linkedList.add("cmd");
                    linkedList.add(Integer.valueOf(i));
                }
                if (!TextUtils.isEmpty(str2)) {
                    linkedList.add("act");
                    linkedList.add(str2);
                }
                if (i3 != 0) {
                    linkedList.add("result");
                    linkedList.add(Integer.valueOf(i3));
                }
                if (!TextUtils.isEmpty(str3)) {
                    linkedList.add("comment");
                    linkedList.add(str3);
                }
                BdStatisticsManager.getInstance().newDebug("socket", j, i2 == 0 ? null : String.valueOf(i2 & 4294967295L), linkedList.toArray());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void c(String str, Message<?> message, int i, String str2, int i2, String str3) {
        long j;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, message, Integer.valueOf(i), str2, Integer.valueOf(i2), str3}) == null) {
            if (message != null) {
                i3 = message.getCmd();
                j = message.getClientLogID();
            } else {
                j = 0;
                i3 = 0;
            }
            b(str, i3, j, i, str2, i2, str3);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                BdStatisticsManager.getInstance().debug("socket", "url", kj.j().q(), "dns_cost", Long.valueOf(kj.j().h()), TiebaStatic.CON_COST, Long.valueOf(kj.j().g()), "remote_ip", kj.j().o(), ETAG.KEY_LOCAL_DNS, kj.j().m(), "local_dns_bak", kj.j().n(), "net", BdStatisticsManager.getInstance().getCurNetworkType());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            try {
                rg statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
                statsItem.b("action", "imconn");
                statsItem.b(TiebaStatic.CON_COST, String.valueOf(kj.j().g()));
                statsItem.b(FpsTracer.UBC_KEY_NET_TYPE, vg.a(BdBaseApplication.getInst()));
                BdStatisticsManager.getInstance().performance("im", statsItem);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
