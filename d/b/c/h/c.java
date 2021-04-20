package d.b.c.h;

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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f42695g;

    /* renamed from: a  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f42696a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f42697b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f42698c;

    /* renamed from: d  reason: collision with root package name */
    public int f42699d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f42700e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f42701f = 0;

    public c() {
        this.f42696a = null;
        this.f42697b = null;
        this.f42698c = null;
        this.f42696a = new HashMap();
        this.f42697b = new HashMap();
        this.f42698c = new HashMap();
    }

    public static c a() {
        if (f42695g == null) {
            synchronized (c.class) {
                if (f42695g == null) {
                    f42695g = new c();
                }
            }
        }
        return f42695g;
    }

    public Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (PluginBaseSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.f42696a.get(cls);
            if (cls2 != null) {
                return cls2;
            }
            int i = this.f42700e;
            if (i == 20) {
                BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                return null;
            }
            this.f42700e = i + 1;
            try {
                cls2 = Class.forName("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy" + this.f42700e);
                this.f42696a.put(cls, cls2);
                return cls2;
            } catch (Exception e2) {
                BdLog.e(e2);
                return cls2;
            }
        } else if (PluginBaseRemoteSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.f42697b.get(cls);
            if (cls3 != null) {
                return cls3;
            }
            int i2 = this.f42701f;
            if (i2 == 10) {
                BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                return null;
            }
            this.f42701f = i2 + 1;
            try {
                cls3 = Class.forName("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy" + this.f42701f);
                this.f42697b.put(cls, cls3);
                return cls3;
            } catch (Exception e3) {
                BdLog.e(e3);
                return cls3;
            }
        } else if (PluginBaseRemoteActivity.class.isAssignableFrom(cls)) {
            return RemoteActivityProxy.class;
        } else {
            if (PluginBaseThirdSingleTaskActivity.class.isAssignableFrom(cls)) {
                Class<?> cls4 = this.f42698c.get(cls);
                if (cls4 != null) {
                    return cls4;
                }
                int i3 = this.f42699d;
                if (i3 == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.f42699d = i3 + 1;
                try {
                    cls4 = Class.forName("com.baidu.adp.plugin.proxy.activity.ThirdSingleTaskActivityProxy" + this.f42699d);
                    this.f42698c.put(cls, cls4);
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
}
