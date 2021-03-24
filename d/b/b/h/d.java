package d.b.b.h;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f42204b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a> f42205a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ServiceProxy f42206a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f42207b;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.f42206a = serviceProxy;
            this.f42207b = intent;
        }
    }

    public d() {
        this.f42205a = null;
        this.f42205a = new HashMap();
    }

    public static d a() {
        if (f42204b == null) {
            synchronized (d.class) {
                if (f42204b == null) {
                    f42204b = new d();
                }
            }
        }
        return f42204b;
    }

    public int b() {
        return this.f42205a.size();
    }

    public synchronized a c(String str) {
        return this.f42205a.get(str);
    }

    public synchronized void d(String str, a aVar) {
        this.f42205a.put(str, aVar);
    }

    public synchronized void e(String str) {
        this.f42205a.remove(str);
    }
}
