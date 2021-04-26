package d.a.c.h;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f40166d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Class<?>> f40167a;

    /* renamed from: b  reason: collision with root package name */
    public int f40168b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f40169c = 0;

    public e() {
        this.f40167a = null;
        this.f40167a = new HashMap<>();
    }

    public static e a() {
        if (f40166d == null) {
            synchronized (e.class) {
                if (f40166d == null) {
                    f40166d = new e();
                }
            }
        }
        return f40166d;
    }

    public Class<?> b(Class<?> cls) {
        String str;
        Class<?> cls2 = this.f40167a.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                int i2 = this.f40169c;
                if (i2 == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.f40169c = i2 + 1;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.f40169c;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                int i3 = this.f40168b;
                if (i3 == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.f40168b = i3 + 1;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.f40168b;
            } else {
                str = PluginBaseThirdService.class.isAssignableFrom(cls) ? "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy" : "";
            }
            try {
                cls2 = Class.forName(str);
                this.f40167a.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e2) {
                BdLog.e(e2);
                return cls2;
            }
        }
        return cls2;
    }
}
