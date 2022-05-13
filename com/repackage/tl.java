package com.repackage;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class tl {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tl d;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Class<?>> a;
    public int b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964026739, "Lcom/repackage/tl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964026739, "Lcom/repackage/tl;");
        }
    }

    public tl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.a = new HashMap<>();
    }

    public static tl a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (tl.class) {
                    if (d == null) {
                        d = new tl();
                    }
                }
            }
            return d;
        }
        return (tl) invokeV.objValue;
    }

    public Class<?> b(Class<?> cls) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            Class<?> cls2 = this.a.get(cls.getName());
            if (cls2 == null) {
                if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                    int i = this.c;
                    if (i == 10) {
                        BdLog.e("can not find service,Has started 10 Remoteservice");
                        return null;
                    }
                    this.c = i + 1;
                    str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.c;
                } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                    int i2 = this.b;
                    if (i2 == 20) {
                        BdLog.e("can not find service,Has started 20 service");
                        return null;
                    }
                    this.b = i2 + 1;
                    str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.b;
                } else {
                    str = PluginBaseThirdService.class.isAssignableFrom(cls) ? "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy" : "";
                }
                try {
                    cls2 = Class.forName(str);
                    this.a.put(cls.getName(), cls2);
                    return cls2;
                } catch (Exception e) {
                    BdLog.e(e);
                    return cls2;
                }
            }
            return cls2;
        }
        return (Class) invokeL.objValue;
    }
}
