package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public final class j62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755636789, "Lcom/repackage/j62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755636789, "Lcom/repackage/j62;");
                return;
            }
        }
        n = cg1.a;
    }

    public j62() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static t92 a(j62 j62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, j62Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, j62Var.a);
            treeMap.put("pagePath", j62Var.b);
            treeMap.put("pageType", j62Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, j62Var.e);
            if (!TextUtils.isEmpty(j62Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + j62Var.f);
                }
                treeMap.put("initData", j62Var.f);
            }
            if (!TextUtils.isEmpty(j62Var.d)) {
                treeMap.put("onReachBottomDistance", j62Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(j62Var.g));
            if (!TextUtils.isEmpty(j62Var.h)) {
                treeMap.put("routeId", j62Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(j62Var.i));
            if (!TextUtils.isEmpty(j62Var.j)) {
                treeMap.put("slavePreload", j62Var.j);
            }
            treeMap.put("root", j62Var.k);
            qv2.a(treeMap, "page ready event");
            k33.a(j62Var.b, treeMap);
            String f = kd3.f(k33.b(j62Var.b));
            sw1.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = c03.c(j62Var.a, f);
            j62Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", j62Var.l);
            }
            o12 W = m62.U().W();
            if (W != null) {
                treeMap.put("masterId", W.c());
            }
            if (j62Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (wy1.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (q53.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (q53.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new t92("PageReady", treeMap);
        }
        return (t92) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PageReadyEvent{appPath='" + this.a + "', pagePath='" + this.b + "', pageType='" + this.c + "', onReachBottomDistance='" + this.d + "', sConsole='" + this.e + "', initData='" + this.f + "', showPerformancePanel=" + this.g + ", routeId='" + this.h + "', isT7Available=" + this.i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
        }
        return (String) invokeV.objValue;
    }
}
