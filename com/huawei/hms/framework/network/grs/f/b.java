package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, b> b;
    public static final Object c;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2128805066, "Lcom/huawei/hms/framework/network/grs/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2128805066, "Lcom/huawei/hms/framework/network/grs/f/b;");
                return;
            }
        }
        b = new ConcurrentHashMap(16);
        c = new Object();
    }

    public b(Context context, GrsBaseInfo grsBaseInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, grsBaseInfo, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context, z);
        Map<String, b> map = b;
        map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
    }

    public static b a(String str, GrsBaseInfo grsBaseInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, grsBaseInfo)) == null) {
            Map<String, b> map = b;
            return map.get(str + grsBaseInfo.uniqueCode());
        }
        return (b) invokeLL.objValue;
    }

    public static void a(Context context, GrsBaseInfo grsBaseInfo) {
        b a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, grsBaseInfo) == null) || (a = a(context.getPackageName(), grsBaseInfo)) == null) {
            return;
        }
        Logger.i("LocalManagerProxy", "appGrs is not null and clear services.");
        synchronized (c) {
            a.a.a();
        }
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.b() : (com.huawei.hms.framework.network.grs.local.model.a) invokeV.objValue;
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, aVar, grsBaseInfo, str, str2, Boolean.valueOf(z)})) == null) {
            synchronized (c) {
                String a = this.a.a(context, aVar, grsBaseInfo, str, str2, z);
                if (TextUtils.isEmpty(a) && this.a.d()) {
                    a(context, true);
                    a(grsBaseInfo);
                    Map<String, b> map = b;
                    map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
                    return this.a.a(context, aVar, grsBaseInfo, str, str2, z);
                }
                return a;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, aVar, grsBaseInfo, str, Boolean.valueOf(z)})) == null) {
            synchronized (c) {
                Map<String, String> a = this.a.a(context, aVar, grsBaseInfo, str, z);
                if ((a == null || a.isEmpty()) && this.a.d()) {
                    a(context, true);
                    a(grsBaseInfo);
                    Map<String, b> map = b;
                    map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
                    return this.a.a(context, aVar, grsBaseInfo, str, z);
                }
                return a;
            }
        }
        return (Map) invokeCommon.objValue;
    }

    public void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, context, z) == null) {
            String[] list = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
            List<String> arrayList = list == null ? new ArrayList<>() : Arrays.asList(list);
            String appConfigName = GrsApp.getInstance().getAppConfigName();
            Logger.i("LocalManagerProxy", "appConfigName is" + appConfigName);
            this.a = new d(false, z);
            if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
                this.a = new d(context, appConfigName, z);
            }
            if (!this.a.e() && arrayList.contains("grs_sdk_global_route_config.json")) {
                this.a = new c(context, z);
            }
            this.a.a(context, arrayList);
        }
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, grsBaseInfo) == null) {
            this.a.a(grsBaseInfo);
        }
    }

    public Set<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.c() : (Set) invokeV.objValue;
    }
}
