package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "c";
    public static final Map<String, PLSharedPreferences> c;
    public transient /* synthetic */ FieldHolder $fh;
    public final PLSharedPreferences a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2128775306, "Lcom/huawei/hms/framework/network/grs/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2128775306, "Lcom/huawei/hms/framework/network/grs/e/c;");
                return;
            }
        }
        c = new ConcurrentHashMap(16);
    }

    public c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String packageName = context.getPackageName();
        Logger.d(b, "get pkgname from context is{%s}", packageName);
        Map<String, PLSharedPreferences> map = c;
        if (map.containsKey(str + packageName)) {
            Map<String, PLSharedPreferences> map2 = c;
            this.a = map2.get(str + packageName);
        } else {
            this.a = new PLSharedPreferences(context, str + packageName);
            Map<String, PLSharedPreferences> map3 = c;
            map3.put(str + packageName, this.a);
        }
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            String str = b;
            Logger.i(str, "ContextHolder.getAppContext() from GRS is:" + ContextHolder.getAppContext());
            if (ContextHolder.getAppContext() != null) {
                context = ContextHolder.getAppContext();
            }
            try {
                String l = Long.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
                String a = a("version", "");
                if (l.equals(a)) {
                    return;
                }
                Logger.i(b, "app version changed! old version{%s} and new version{%s}", a, l);
                b();
                b("version", l);
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.w(b, "get app version failed and catch NameNotFoundException");
            }
        }
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            PLSharedPreferences pLSharedPreferences = this.a;
            if (pLSharedPreferences == null) {
                return str2;
            }
            synchronized (pLSharedPreferences) {
                string = this.a.getString(str, str2);
            }
            return string;
        }
        return (String) invokeLL.objValue;
    }

    public Map<String, ?> a() {
        InterceptResult invokeV;
        Map<String, ?> all;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PLSharedPreferences pLSharedPreferences = this.a;
            if (pLSharedPreferences == null) {
                return new HashMap();
            }
            synchronized (pLSharedPreferences) {
                all = this.a.getAll();
            }
            return all;
        }
        return (Map) invokeV.objValue;
    }

    public void a(String str) {
        PLSharedPreferences pLSharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (pLSharedPreferences = this.a) == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.a.remove(str);
        }
    }

    public void b() {
        PLSharedPreferences pLSharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pLSharedPreferences = this.a) == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.a.clear();
        }
    }

    public void b(String str, String str2) {
        PLSharedPreferences pLSharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || (pLSharedPreferences = this.a) == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.a.putString(str, str2);
        }
    }
}
