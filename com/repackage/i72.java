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
public class i72 {
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

    public i72() {
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

    public static Map<String, String> a(i72 i72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, i72Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (i72Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, i72Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, i72Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, i72Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, i72Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, i72Var.f);
            treeMap.put("root", i72Var.g);
            if (!TextUtils.isEmpty(i72Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, i72Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(i72Var.h));
            treeMap.put("pageType", i72Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(i72Var.j));
            if (!TextUtils.isEmpty(i72Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, i72Var.k);
            }
            sw2.a(treeMap, "app ready event");
            m43.a(i72Var.d, treeMap);
            if (yz1.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (s63.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (s63.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(i72Var.l));
            if (!TextUtils.isEmpty(i72Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, i72Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static va2 b(i72 i72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, i72Var)) == null) {
            Map<String, String> a = a(i72Var);
            va2 va2Var = new va2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return va2Var;
            }
            k72 k72Var = new k72();
            k72Var.t(createFromAppReadyEvent);
            k72Var.t(va2Var);
            return k72Var;
        }
        return (va2) invokeL.objValue;
    }

    public static String c(u03 u03Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, u03Var, str)) == null) {
            String b0 = u03Var != null ? u03Var.b0(me3.f(str)) : null;
            return b0 == null ? "" : b0;
        }
        return (String) invokeLL.objValue;
    }
}
