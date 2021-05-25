package d.a.c.h;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f39071b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a> f39072a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ServiceProxy f39073a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f39074b;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.f39073a = serviceProxy;
            this.f39074b = intent;
        }
    }

    public d() {
        this.f39072a = null;
        this.f39072a = new HashMap();
    }

    public static d a() {
        if (f39071b == null) {
            synchronized (d.class) {
                if (f39071b == null) {
                    f39071b = new d();
                }
            }
        }
        return f39071b;
    }

    public int b() {
        return this.f39072a.size();
    }

    public synchronized a c(String str) {
        return this.f39072a.get(str);
    }

    public synchronized void d(String str, a aVar) {
        this.f39072a.put(str, aVar);
    }

    public synchronized void e(String str) {
        this.f39072a.remove(str);
    }
}
