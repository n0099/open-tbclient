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
public final class l72 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755576246, "Lcom/repackage/l72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755576246, "Lcom/repackage/l72;");
                return;
            }
        }
        n = eh1.a;
    }

    public l72() {
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

    public static va2 a(l72 l72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, l72Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, l72Var.a);
            treeMap.put("pagePath", l72Var.b);
            treeMap.put("pageType", l72Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, l72Var.e);
            if (!TextUtils.isEmpty(l72Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + l72Var.f);
                }
                treeMap.put("initData", l72Var.f);
            }
            if (!TextUtils.isEmpty(l72Var.d)) {
                treeMap.put("onReachBottomDistance", l72Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(l72Var.g));
            if (!TextUtils.isEmpty(l72Var.h)) {
                treeMap.put("routeId", l72Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(l72Var.i));
            if (!TextUtils.isEmpty(l72Var.j)) {
                treeMap.put("slavePreload", l72Var.j);
            }
            treeMap.put("root", l72Var.k);
            sw2.a(treeMap, "page ready event");
            m43.a(l72Var.b, treeMap);
            String f = me3.f(m43.b(l72Var.b));
            ux1.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = e13.c(l72Var.a, f);
            l72Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", l72Var.l);
            }
            q22 W = o72.U().W();
            if (W != null) {
                treeMap.put("masterId", W.c());
            }
            if (l72Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (yz1.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (s63.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (s63.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new va2("PageReady", treeMap);
        }
        return (va2) invokeL.objValue;
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
