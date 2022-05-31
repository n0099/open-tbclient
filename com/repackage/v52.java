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
public class v52 {
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

    public v52() {
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

    public static Map<String, String> a(v52 v52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, v52Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (v52Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, v52Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, v52Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, v52Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, v52Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, v52Var.f);
            treeMap.put("root", v52Var.g);
            if (!TextUtils.isEmpty(v52Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, v52Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(v52Var.h));
            treeMap.put("pageType", v52Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(v52Var.j));
            if (!TextUtils.isEmpty(v52Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, v52Var.k);
            }
            fv2.a(treeMap, "app ready event");
            z23.a(v52Var.d, treeMap);
            if (ly1.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (f53.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (f53.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(v52Var.l));
            if (!TextUtils.isEmpty(v52Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, v52Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static i92 b(v52 v52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, v52Var)) == null) {
            Map<String, String> a = a(v52Var);
            i92 i92Var = new i92("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return i92Var;
            }
            x52 x52Var = new x52();
            x52Var.t(createFromAppReadyEvent);
            x52Var.t(i92Var);
            return x52Var;
        }
        return (i92) invokeL.objValue;
    }

    public static String c(hz2 hz2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, hz2Var, str)) == null) {
            String b0 = hz2Var != null ? hz2Var.b0(zc3.f(str)) : null;
            return b0 == null ? "" : b0;
        }
        return (String) invokeLL.objValue;
    }
}
