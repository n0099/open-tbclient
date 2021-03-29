package d.b.b.h;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f42209d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Class<?>> f42210a;

    /* renamed from: b  reason: collision with root package name */
    public int f42211b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f42212c = 0;

    public e() {
        this.f42210a = null;
        this.f42210a = new HashMap<>();
    }

    public static e a() {
        if (f42209d == null) {
            synchronized (e.class) {
                if (f42209d == null) {
                    f42209d = new e();
                }
            }
        }
        return f42209d;
    }

    public Class<?> b(Class<?> cls) {
        String str;
        Class<?> cls2 = this.f42210a.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                int i = this.f42212c;
                if (i == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.f42212c = i + 1;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.f42212c;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                int i2 = this.f42211b;
                if (i2 == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.f42211b = i2 + 1;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.f42211b;
            } else {
                str = PluginBaseThirdService.class.isAssignableFrom(cls) ? "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy" : "";
            }
            try {
                cls2 = Class.forName(str);
                this.f42210a.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e2) {
                BdLog.e(e2);
                return cls2;
            }
        }
        return cls2;
    }
}
