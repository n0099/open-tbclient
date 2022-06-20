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
public class g62 {
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

    public g62() {
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

    public static Map<String, String> a(g62 g62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, g62Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (g62Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, g62Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, g62Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, g62Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, g62Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, g62Var.f);
            treeMap.put("root", g62Var.g);
            if (!TextUtils.isEmpty(g62Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, g62Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(g62Var.h));
            treeMap.put("pageType", g62Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(g62Var.j));
            if (!TextUtils.isEmpty(g62Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, g62Var.k);
            }
            qv2.a(treeMap, "app ready event");
            k33.a(g62Var.d, treeMap);
            if (wy1.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (q53.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (q53.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(g62Var.l));
            if (!TextUtils.isEmpty(g62Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, g62Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static t92 b(g62 g62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, g62Var)) == null) {
            Map<String, String> a = a(g62Var);
            t92 t92Var = new t92("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return t92Var;
            }
            i62 i62Var = new i62();
            i62Var.t(createFromAppReadyEvent);
            i62Var.t(t92Var);
            return i62Var;
        }
        return (t92) invokeL.objValue;
    }

    public static String c(sz2 sz2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, sz2Var, str)) == null) {
            String c0 = sz2Var != null ? sz2Var.c0(kd3.f(str)) : null;
            return c0 == null ? "" : c0;
        }
        return (String) invokeLL.objValue;
    }
}
