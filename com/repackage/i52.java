package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class i52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;

    /* loaded from: classes6.dex */
    public static class a extends PrefetchEvent.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@Nullable Map<String, String> map, String str) {
            super(map, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Map) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755667541, "Lcom/repackage/i52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755667541, "Lcom/repackage/i52;");
                return;
            }
        }
        l = tg1.a;
    }

    public i52() {
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

    public static i52 a(pm1<?> pm1Var, PrefetchEvent prefetchEvent, j03 j03Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, pm1Var, prefetchEvent, j03Var)) == null) {
            long currentTimeMillis = l ? System.currentTimeMillis() : 0L;
            i52 i52Var = new i52();
            i52Var.h = pm1Var.c();
            i52Var.a = prefetchEvent.appPath;
            i52Var.b = prefetchEvent.pageUrl;
            i52Var.f = prefetchEvent.rootPath;
            SwanAppConfigData P = j03Var.P();
            i52Var.c = prefetchEvent.pageType;
            String c = t03.c(prefetchEvent.appPath, be3.f(b43.b(prefetchEvent.pageUrl)));
            i52Var.g = c;
            y03 b = y03.b(c, P.e);
            i52Var.k = b.r;
            i52Var.d = b.g;
            i52Var.e = prefetchEvent.isT7Available;
            i52Var.i = prefetchEvent.sConsole;
            if (!TextUtils.isEmpty(prefetchEvent.userActionApis)) {
                i52Var.j = prefetchEvent.userActionApis;
            }
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SlavePreloadEvent", "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return i52Var;
        }
        return (i52) invokeLLL.objValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = l ? System.currentTimeMillis() : 0L;
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.a);
            treeMap.put("pagePath", this.b);
            treeMap.put("pageType", this.c);
            treeMap.put("onReachBottomDistance", this.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.i);
            treeMap.put("root", this.f);
            treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, this.j);
            hw2.a(treeMap, "slave preload ready event");
            b43.a(this.b, treeMap);
            treeMap.put("pageConfig", this.g);
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SlavePreloadEvent", "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return new a(treeMap, "preload");
        }
        return (a) invokeV.objValue;
    }
}
