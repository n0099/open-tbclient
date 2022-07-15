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
/* loaded from: classes7.dex */
public class v62 {
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

    public v62() {
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

    public static Map<String, String> a(v62 v62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, v62Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (v62Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, v62Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, v62Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, v62Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, v62Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, v62Var.f);
            treeMap.put("root", v62Var.g);
            if (!TextUtils.isEmpty(v62Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, v62Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(v62Var.h));
            treeMap.put("pageType", v62Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(v62Var.j));
            if (!TextUtils.isEmpty(v62Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, v62Var.k);
            }
            fw2.a(treeMap, "app ready event");
            z33.a(v62Var.d, treeMap);
            if (lz1.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (f63.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (f63.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(v62Var.l));
            if (!TextUtils.isEmpty(v62Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, v62Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static ia2 b(v62 v62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, v62Var)) == null) {
            Map<String, String> a = a(v62Var);
            ia2 ia2Var = new ia2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return ia2Var;
            }
            x62 x62Var = new x62();
            x62Var.t(createFromAppReadyEvent);
            x62Var.t(ia2Var);
            return x62Var;
        }
        return (ia2) invokeL.objValue;
    }

    public static String c(h03 h03Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, h03Var, str)) == null) {
            String c0 = h03Var != null ? h03Var.c0(zd3.f(str)) : null;
            return c0 == null ? "" : c0;
        }
        return (String) invokeLL.objValue;
    }
}
