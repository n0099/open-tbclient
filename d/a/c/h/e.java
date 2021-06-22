package d.a.c.h;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f42831d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Class<?>> f42832a;

    /* renamed from: b  reason: collision with root package name */
    public int f42833b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f42834c = 0;

    public e() {
        this.f42832a = null;
        this.f42832a = new HashMap<>();
    }

    public static e a() {
        if (f42831d == null) {
            synchronized (e.class) {
                if (f42831d == null) {
                    f42831d = new e();
                }
            }
        }
        return f42831d;
    }

    public Class<?> b(Class<?> cls) {
        String str;
        Class<?> cls2 = this.f42832a.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                int i2 = this.f42834c;
                if (i2 == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.f42834c = i2 + 1;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.f42834c;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                int i3 = this.f42833b;
                if (i3 == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.f42833b = i3 + 1;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.f42833b;
            } else {
                str = PluginBaseThirdService.class.isAssignableFrom(cls) ? "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy" : "";
            }
            try {
                cls2 = Class.forName(str);
                this.f42832a.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e2) {
                BdLog.e(e2);
                return cls2;
            }
        }
        return cls2;
    }
}
