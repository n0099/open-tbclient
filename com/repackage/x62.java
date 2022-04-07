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
public class x62 {
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

    public x62() {
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

    public static Map<String, String> a(x62 x62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, x62Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (x62Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, x62Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, x62Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, x62Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, x62Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, x62Var.f);
            treeMap.put("root", x62Var.g);
            if (!TextUtils.isEmpty(x62Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, x62Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(x62Var.h));
            treeMap.put("pageType", x62Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(x62Var.j));
            if (!TextUtils.isEmpty(x62Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, x62Var.k);
            }
            hw2.a(treeMap, "app ready event");
            b43.a(x62Var.d, treeMap);
            if (nz1.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (h63.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (h63.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(x62Var.l));
            if (!TextUtils.isEmpty(x62Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, x62Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static ka2 b(x62 x62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, x62Var)) == null) {
            Map<String, String> a = a(x62Var);
            ka2 ka2Var = new ka2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return ka2Var;
            }
            z62 z62Var = new z62();
            z62Var.t(createFromAppReadyEvent);
            z62Var.t(ka2Var);
            return z62Var;
        }
        return (ka2) invokeL.objValue;
    }

    public static String c(j03 j03Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, j03Var, str)) == null) {
            String b0 = j03Var != null ? j03Var.b0(be3.f(str)) : null;
            return b0 == null ? "" : b0;
        }
        return (String) invokeLL.objValue;
    }
}
