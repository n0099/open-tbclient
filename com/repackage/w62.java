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
public class w62 {
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

    public w62() {
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

    public static Map<String, String> a(w62 w62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, w62Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (w62Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, w62Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, w62Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, w62Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, w62Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, w62Var.f);
            treeMap.put("root", w62Var.g);
            if (!TextUtils.isEmpty(w62Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, w62Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(w62Var.h));
            treeMap.put("pageType", w62Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(w62Var.j));
            if (!TextUtils.isEmpty(w62Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, w62Var.k);
            }
            gw2.a(treeMap, "app ready event");
            a43.a(w62Var.d, treeMap);
            if (mz1.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (g63.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (g63.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(w62Var.l));
            if (!TextUtils.isEmpty(w62Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, w62Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static ja2 b(w62 w62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, w62Var)) == null) {
            Map<String, String> a = a(w62Var);
            ja2 ja2Var = new ja2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return ja2Var;
            }
            y62 y62Var = new y62();
            y62Var.t(createFromAppReadyEvent);
            y62Var.t(ja2Var);
            return y62Var;
        }
        return (ja2) invokeL.objValue;
    }

    public static String c(i03 i03Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, i03Var, str)) == null) {
            String c0 = i03Var != null ? i03Var.c0(ae3.f(str)) : null;
            return c0 == null ? "" : c0;
        }
        return (String) invokeLL.objValue;
    }
}
