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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f42717g;

    /* renamed from: a  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f42718a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f42719b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f42720c;

    /* renamed from: d  reason: collision with root package name */
    public int f42721d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f42722e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f42723f = 0;

    public c() {
        this.f42718a = null;
        this.f42719b = null;
        this.f42720c = null;
        this.f42718a = new HashMap();
        this.f42719b = new HashMap();
        this.f42720c = new HashMap();
    }

    public static c a() {
        if (f42717g == null) {
            synchronized (c.class) {
                if (f42717g == null) {
                    f42717g = new c();
                }
            }
        }
        return f42717g;
    }

    public Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (PluginBaseSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls2 = this.f42718a.get(cls);
            if (cls2 != null) {
                return cls2;
            }
            int i2 = this.f42722e;
            if (i2 == 20) {
                BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                return null;
            }
            this.f42722e = i2 + 1;
            try {
                cls2 = Class.forName("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy" + this.f42722e);
                this.f42718a.put(cls, cls2);
                return cls2;
            } catch (Exception e2) {
                BdLog.e(e2);
                return cls2;
            }
        } else if (PluginBaseRemoteSingleTaskActivity.class.isAssignableFrom(cls)) {
            Class<?> cls3 = this.f42719b.get(cls);
            if (cls3 != null) {
                return cls3;
            }
            int i3 = this.f42723f;
            if (i3 == 10) {
                BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                return null;
            }
            this.f42723f = i3 + 1;
            try {
                cls3 = Class.forName("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy" + this.f42723f);
                this.f42719b.put(cls, cls3);
                return cls3;
            } catch (Exception e3) {
                BdLog.e(e3);
                return cls3;
            }
        } else if (PluginBaseRemoteActivity.class.isAssignableFrom(cls)) {
            return RemoteActivityProxy.class;
        } else {
            if (PluginBaseThirdSingleTaskActivity.class.isAssignableFrom(cls)) {
                Class<?> cls4 = this.f42720c.get(cls);
                if (cls4 != null) {
                    return cls4;
                }
                int i4 = this.f42721d;
                if (i4 == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.f42721d = i4 + 1;
                try {
                    cls4 = Class.forName("com.baidu.adp.plugin.proxy.activity.ThirdSingleTaskActivityProxy" + this.f42721d);
                    this.f42720c.put(cls, cls4);
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
