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
/* loaded from: classes7.dex */
public class y52 {
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

    /* loaded from: classes7.dex */
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
        l = jh1.a;
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

    public static y52 a(fn1<?> fn1Var, PrefetchEvent prefetchEvent, z03 z03Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, fn1Var, prefetchEvent, z03Var)) == null) {
            long currentTimeMillis = l ? System.currentTimeMillis() : 0L;
            y52 y52Var = new y52();
            y52Var.h = fn1Var.a();
            y52Var.a = prefetchEvent.appPath;
            y52Var.b = prefetchEvent.pageUrl;
            y52Var.f = prefetchEvent.rootPath;
            SwanAppConfigData Q = z03Var.Q();
            y52Var.c = prefetchEvent.pageType;
            String c = j13.c(prefetchEvent.appPath, re3.f(r43.b(prefetchEvent.pageUrl)));
            y52Var.g = c;
            o13 b = o13.b(c, Q.e);
            y52Var.k = b.r;
            y52Var.d = b.g;
            y52Var.e = prefetchEvent.isT7Available;
            y52Var.i = prefetchEvent.sConsole;
            if (!TextUtils.isEmpty(prefetchEvent.userActionApis)) {
                y52Var.j = prefetchEvent.userActionApis;
            }
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SlavePreloadEvent", "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return y52Var;
        }
        return (y52) invokeLLL.objValue;
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
            xw2.a(treeMap, "slave preload ready event");
            r43.a(this.b, treeMap);
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
