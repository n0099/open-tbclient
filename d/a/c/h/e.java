package d.a.c.h;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f39075d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Class<?>> f39076a;

    /* renamed from: b  reason: collision with root package name */
    public int f39077b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f39078c = 0;

    public e() {
        this.f39076a = null;
        this.f39076a = new HashMap<>();
    }

    public static e a() {
        if (f39075d == null) {
            synchronized (e.class) {
                if (f39075d == null) {
                    f39075d = new e();
                }
            }
        }
        return f39075d;
    }

    public Class<?> b(Class<?> cls) {
        String str;
        Class<?> cls2 = this.f39076a.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                int i2 = this.f39078c;
                if (i2 == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.f39078c = i2 + 1;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.f39078c;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                int i3 = this.f39077b;
                if (i3 == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.f39077b = i3 + 1;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.f39077b;
            } else {
                str = PluginBaseThirdService.class.isAssignableFrom(cls) ? "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy" : "";
            }
            try {
                cls2 = Class.forName(str);
                this.f39076a.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e2) {
                BdLog.e(e2);
                return cls2;
            }
        }
        return cls2;
    }
}
