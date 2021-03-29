package d.b.b.h;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f42205b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a> f42206a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ServiceProxy f42207a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f42208b;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.f42207a = serviceProxy;
            this.f42208b = intent;
        }
    }

    public d() {
        this.f42206a = null;
        this.f42206a = new HashMap();
    }

    public static d a() {
        if (f42205b == null) {
            synchronized (d.class) {
                if (f42205b == null) {
                    f42205b = new d();
                }
            }
        }
        return f42205b;
    }

    public int b() {
        return this.f42206a.size();
    }

    public synchronized a c(String str) {
        return this.f42206a.get(str);
    }

    public synchronized void d(String str, a aVar) {
        this.f42206a.put(str, aVar);
    }

    public synchronized void e(String str) {
        this.f42206a.remove(str);
    }
}
