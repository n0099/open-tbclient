package d.b.c.h;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f42946d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Class<?>> f42947a;

    /* renamed from: b  reason: collision with root package name */
    public int f42948b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f42949c = 0;

    public e() {
        this.f42947a = null;
        this.f42947a = new HashMap<>();
    }

    public static e a() {
        if (f42946d == null) {
            synchronized (e.class) {
                if (f42946d == null) {
                    f42946d = new e();
                }
            }
        }
        return f42946d;
    }

    public Class<?> b(Class<?> cls) {
        String str;
        Class<?> cls2 = this.f42947a.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                int i = this.f42949c;
                if (i == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.f42949c = i + 1;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.f42949c;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                int i2 = this.f42948b;
                if (i2 == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.f42948b = i2 + 1;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.f42948b;
            } else {
                str = PluginBaseThirdService.class.isAssignableFrom(cls) ? "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy" : "";
            }
            try {
                cls2 = Class.forName(str);
                this.f42947a.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e2) {
                BdLog.e(e2);
                return cls2;
            }
        }
        return cls2;
    }
}
