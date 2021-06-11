package d.a.c.h;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f42728d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Class<?>> f42729a;

    /* renamed from: b  reason: collision with root package name */
    public int f42730b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f42731c = 0;

    public e() {
        this.f42729a = null;
        this.f42729a = new HashMap<>();
    }

    public static e a() {
        if (f42728d == null) {
            synchronized (e.class) {
                if (f42728d == null) {
                    f42728d = new e();
                }
            }
        }
        return f42728d;
    }

    public Class<?> b(Class<?> cls) {
        String str;
        Class<?> cls2 = this.f42729a.get(cls.getName());
        if (cls2 == null) {
            if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                int i2 = this.f42731c;
                if (i2 == 10) {
                    BdLog.e("can not find service,Has started 10 Remoteservice");
                    return null;
                }
                this.f42731c = i2 + 1;
                str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.f42731c;
            } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                int i3 = this.f42730b;
                if (i3 == 20) {
                    BdLog.e("can not find service,Has started 20 service");
                    return null;
                }
                this.f42730b = i3 + 1;
                str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.f42730b;
            } else {
                str = PluginBaseThirdService.class.isAssignableFrom(cls) ? "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy" : "";
            }
            try {
                cls2 = Class.forName(str);
                this.f42729a.put(cls.getName(), cls2);
                return cls2;
            } catch (Exception e2) {
                BdLog.e(e2);
                return cls2;
            }
        }
        return cls2;
    }
}
