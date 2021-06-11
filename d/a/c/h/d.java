package d.a.c.h;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f42724b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a> f42725a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ServiceProxy f42726a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f42727b;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.f42726a = serviceProxy;
            this.f42727b = intent;
        }
    }

    public d() {
        this.f42725a = null;
        this.f42725a = new HashMap();
    }

    public static d a() {
        if (f42724b == null) {
            synchronized (d.class) {
                if (f42724b == null) {
                    f42724b = new d();
                }
            }
        }
        return f42724b;
    }

    public int b() {
        return this.f42725a.size();
    }

    public synchronized a c(String str) {
        return this.f42725a.get(str);
    }

    public synchronized void d(String str, a aVar) {
        this.f42725a.put(str, aVar);
    }

    public synchronized void e(String str) {
        this.f42725a.remove(str);
    }
}
