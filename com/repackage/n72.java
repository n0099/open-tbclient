package com.repackage;

import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class n72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public String i;
    public boolean j;
    public String k;
    public boolean l;
    public String m;

    public n72() {
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

    public static Map<String, String> a(n72 n72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, n72Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (n72Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, n72Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, n72Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, n72Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, n72Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, n72Var.f);
            treeMap.put("root", n72Var.g);
            if (!TextUtils.isEmpty(n72Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, n72Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(n72Var.h));
            treeMap.put("pageType", n72Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(n72Var.j));
            if (!TextUtils.isEmpty(n72Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, n72Var.k);
            }
            xw2.a(treeMap, "app ready event");
            r43.a(n72Var.d, treeMap);
            if (d02.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (x63.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (x63.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(n72Var.l));
            if (!TextUtils.isEmpty(n72Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, n72Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static ab2 b(n72 n72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, n72Var)) == null) {
            Map<String, String> a = a(n72Var);
            ab2 ab2Var = new ab2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return ab2Var;
            }
            p72 p72Var = new p72();
            p72Var.t(createFromAppReadyEvent);
            p72Var.t(ab2Var);
            return p72Var;
        }
        return (ab2) invokeL.objValue;
    }

    public static String c(z03 z03Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, z03Var, str)) == null) {
            String c0 = z03Var != null ? z03Var.c0(re3.f(str)) : null;
            return c0 == null ? "" : c0;
        }
        return (String) invokeLL.objValue;
    }
}
