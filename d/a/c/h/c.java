package d.a.c.h;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseFragmentActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteSingleTaskActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseSingleTaskActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdFragmentActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdSingleTaskActivity;
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import com.baidu.adp.plugin.proxy.activity.FragmentActivityProxy;
import com.baidu.adp.plugin.proxy.activity.RemoteActivityProxy;
import com.baidu.adp.plugin.proxy.activity.ThirdActivityProxy;
import com.baidu.adp.plugin.proxy.activity.ThirdFragmentActivityProxy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f41645g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f41646a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f41647b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f41648c;

    /* renamed from: d  reason: collision with root package name */
    public int f41649d;

    /* renamed from: e  reason: collision with root package name */
    public int f41650e;

    /* renamed from: f  reason: collision with root package name */
    public int f41651f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1754096272, "Ld/a/c/h/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1754096272, "Ld/a/c/h/c;");
        }
    }

    public c() {
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
        this.f41646a = null;
        this.f41647b = null;
        this.f41648c = null;
        this.f41649d = 0;
        this.f41650e = 0;
        this.f41651f = 0;
        this.f41646a = new HashMap();
        this.f41647b = new HashMap();
        this.f41648c = new HashMap();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f41645g == null) {
                synchronized (c.class) {
                    if (f41645g == null) {
                        f41645g = new c();
                    }
                }
            }
            return f41645g;
        }
        return (c) invokeV.objValue;
    }

    public Class<?> b(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            if (cls == null) {
                return null;
            }
            if (PluginBaseSingleTaskActivity.class.isAssignableFrom(cls)) {
                Class<?> cls2 = this.f41646a.get(cls);
                if (cls2 != null) {
                    return cls2;
                }
                int i2 = this.f41650e;
                if (i2 == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.f41650e = i2 + 1;
                try {
                    cls2 = Class.forName("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy" + this.f41650e);
                    this.f41646a.put(cls, cls2);
                    return cls2;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return cls2;
                }
            } else if (PluginBaseRemoteSingleTaskActivity.class.isAssignableFrom(cls)) {
                Class<?> cls3 = this.f41647b.get(cls);
                if (cls3 != null) {
                    return cls3;
                }
                int i3 = this.f41651f;
                if (i3 == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.f41651f = i3 + 1;
                try {
                    cls3 = Class.forName("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy" + this.f41651f);
                    this.f41647b.put(cls, cls3);
                    return cls3;
                } catch (Exception e3) {
                    BdLog.e(e3);
                    return cls3;
                }
            } else if (PluginBaseRemoteActivity.class.isAssignableFrom(cls)) {
                return RemoteActivityProxy.class;
            } else {
                if (PluginBaseThirdSingleTaskActivity.class.isAssignableFrom(cls)) {
                    Class<?> cls4 = this.f41648c.get(cls);
                    if (cls4 != null) {
                        return cls4;
                    }
                    int i4 = this.f41649d;
                    if (i4 == 10) {
                        BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                        return null;
                    }
                    this.f41649d = i4 + 1;
                    try {
                        cls4 = Class.forName("com.baidu.adp.plugin.proxy.activity.ThirdSingleTaskActivityProxy" + this.f41649d);
                        this.f41648c.put(cls, cls4);
                        return cls4;
                    } catch (Exception e4) {
                        BdLog.e(e4);
                        return cls4;
                    }
                } else if (PluginBaseThirdActivity.class.isAssignableFrom(cls)) {
                    return ThirdActivityProxy.class;
                } else {
                    if (PluginBaseThirdFragmentActivity.class.isAssignableFrom(cls)) {
                        return ThirdFragmentActivityProxy.class;
                    }
                    if (PluginBaseFragmentActivity.class.isAssignableFrom(cls)) {
                        return FragmentActivityProxy.class;
                    }
                    if (PluginBaseActivity.class.isAssignableFrom(cls)) {
                        return ActivityProxy.class;
                    }
                    return null;
                }
            }
        }
        return (Class) invokeL.objValue;
    }
}
