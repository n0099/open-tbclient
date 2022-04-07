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
/* loaded from: classes5.dex */
public final class a72 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755903947, "Lcom/repackage/a72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755903947, "Lcom/repackage/a72;");
                return;
            }
        }
        n = tg1.a;
    }

    public a72() {
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

    public static ka2 a(a72 a72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, a72Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, a72Var.a);
            treeMap.put("pagePath", a72Var.b);
            treeMap.put("pageType", a72Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, a72Var.e);
            if (!TextUtils.isEmpty(a72Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + a72Var.f);
                }
                treeMap.put("initData", a72Var.f);
            }
            if (!TextUtils.isEmpty(a72Var.d)) {
                treeMap.put("onReachBottomDistance", a72Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(a72Var.g));
            if (!TextUtils.isEmpty(a72Var.h)) {
                treeMap.put("routeId", a72Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(a72Var.i));
            if (!TextUtils.isEmpty(a72Var.j)) {
                treeMap.put("slavePreload", a72Var.j);
            }
            treeMap.put("root", a72Var.k);
            hw2.a(treeMap, "page ready event");
            b43.a(a72Var.b, treeMap);
            String f = be3.f(b43.b(a72Var.b));
            jx1.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = t03.c(a72Var.a, f);
            a72Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", a72Var.l);
            }
            f22 W = d72.U().W();
            if (W != null) {
                treeMap.put("masterId", W.c());
            }
            if (a72Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (nz1.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (h63.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (h63.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new ka2("PageReady", treeMap);
        }
        return (ka2) invokeL.objValue;
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
