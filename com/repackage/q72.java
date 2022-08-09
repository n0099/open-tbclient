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
/* loaded from: classes7.dex */
public final class q72 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755427291, "Lcom/repackage/q72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755427291, "Lcom/repackage/q72;");
                return;
            }
        }
        n = jh1.a;
    }

    public q72() {
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

    public static ab2 a(q72 q72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, q72Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, q72Var.a);
            treeMap.put("pagePath", q72Var.b);
            treeMap.put("pageType", q72Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, q72Var.e);
            if (!TextUtils.isEmpty(q72Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + q72Var.f);
                }
                treeMap.put("initData", q72Var.f);
            }
            if (!TextUtils.isEmpty(q72Var.d)) {
                treeMap.put("onReachBottomDistance", q72Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(q72Var.g));
            if (!TextUtils.isEmpty(q72Var.h)) {
                treeMap.put("routeId", q72Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(q72Var.i));
            if (!TextUtils.isEmpty(q72Var.j)) {
                treeMap.put("slavePreload", q72Var.j);
            }
            treeMap.put("root", q72Var.k);
            xw2.a(treeMap, "page ready event");
            r43.a(q72Var.b, treeMap);
            String f = re3.f(r43.b(q72Var.b));
            zx1.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = j13.c(q72Var.a, f);
            q72Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", q72Var.l);
            }
            v22 W = t72.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (q72Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (d02.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (x63.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (x63.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new ab2("PageReady", treeMap);
        }
        return (ab2) invokeL.objValue;
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
