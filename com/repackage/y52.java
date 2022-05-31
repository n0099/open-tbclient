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
public final class y52 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755190885, "Lcom/repackage/y52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755190885, "Lcom/repackage/y52;");
                return;
            }
        }
        n = rf1.a;
    }

    public y52() {
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

    public static i92 a(y52 y52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, y52Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, y52Var.a);
            treeMap.put("pagePath", y52Var.b);
            treeMap.put("pageType", y52Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, y52Var.e);
            if (!TextUtils.isEmpty(y52Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + y52Var.f);
                }
                treeMap.put("initData", y52Var.f);
            }
            if (!TextUtils.isEmpty(y52Var.d)) {
                treeMap.put("onReachBottomDistance", y52Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(y52Var.g));
            if (!TextUtils.isEmpty(y52Var.h)) {
                treeMap.put("routeId", y52Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(y52Var.i));
            if (!TextUtils.isEmpty(y52Var.j)) {
                treeMap.put("slavePreload", y52Var.j);
            }
            treeMap.put("root", y52Var.k);
            fv2.a(treeMap, "page ready event");
            z23.a(y52Var.b, treeMap);
            String f = zc3.f(z23.b(y52Var.b));
            hw1.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = rz2.c(y52Var.a, f);
            y52Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", y52Var.l);
            }
            d12 W = b62.U().W();
            if (W != null) {
                treeMap.put("masterId", W.c());
            }
            if (y52Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (ly1.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (f53.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (f53.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new i92("PageReady", treeMap);
        }
        return (i92) invokeL.objValue;
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
