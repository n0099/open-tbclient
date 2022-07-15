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
public final class y62 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755189924, "Lcom/repackage/y62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755189924, "Lcom/repackage/y62;");
                return;
            }
        }
        n = rg1.a;
    }

    public y62() {
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

    public static ia2 a(y62 y62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, y62Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, y62Var.a);
            treeMap.put("pagePath", y62Var.b);
            treeMap.put("pageType", y62Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, y62Var.e);
            if (!TextUtils.isEmpty(y62Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + y62Var.f);
                }
                treeMap.put("initData", y62Var.f);
            }
            if (!TextUtils.isEmpty(y62Var.d)) {
                treeMap.put("onReachBottomDistance", y62Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(y62Var.g));
            if (!TextUtils.isEmpty(y62Var.h)) {
                treeMap.put("routeId", y62Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(y62Var.i));
            if (!TextUtils.isEmpty(y62Var.j)) {
                treeMap.put("slavePreload", y62Var.j);
            }
            treeMap.put("root", y62Var.k);
            fw2.a(treeMap, "page ready event");
            z33.a(y62Var.b, treeMap);
            String f = zd3.f(z33.b(y62Var.b));
            hx1.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = r03.c(y62Var.a, f);
            y62Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", y62Var.l);
            }
            d22 W = b72.U().W();
            if (W != null) {
                treeMap.put("masterId", W.b());
            }
            if (y62Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (lz1.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (f63.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (f63.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new ia2("PageReady", treeMap);
        }
        return (ia2) invokeL.objValue;
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
