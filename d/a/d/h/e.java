package d.a.d.h;

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
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f42160d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Class<?>> f42161a;

    /* renamed from: b  reason: collision with root package name */
    public int f42162b;

    /* renamed from: c  reason: collision with root package name */
    public int f42163c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1725467059, "Ld/a/d/h/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1725467059, "Ld/a/d/h/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42161a = null;
        this.f42162b = 0;
        this.f42163c = 0;
        this.f42161a = new HashMap<>();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f42160d == null) {
                synchronized (e.class) {
                    if (f42160d == null) {
                        f42160d = new e();
                    }
                }
            }
            return f42160d;
        }
        return (e) invokeV.objValue;
    }

    public Class<?> b(Class<?> cls) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            Class<?> cls2 = this.f42161a.get(cls.getName());
            if (cls2 == null) {
                if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                    int i2 = this.f42163c;
                    if (i2 == 10) {
                        BdLog.e("can not find service,Has started 10 Remoteservice");
                        return null;
                    }
                    this.f42163c = i2 + 1;
                    str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.f42163c;
                } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                    int i3 = this.f42162b;
                    if (i3 == 20) {
                        BdLog.e("can not find service,Has started 20 service");
                        return null;
                    }
                    this.f42162b = i3 + 1;
                    str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.f42162b;
                } else {
                    str = PluginBaseThirdService.class.isAssignableFrom(cls) ? "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy" : "";
                }
                try {
                    cls2 = Class.forName(str);
                    this.f42161a.put(cls.getName(), cls2);
                    return cls2;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return cls2;
                }
            }
            return cls2;
        }
        return (Class) invokeL.objValue;
    }
}
