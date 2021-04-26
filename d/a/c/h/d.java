package d.a.c.h;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f40162b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a> f40163a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ServiceProxy f40164a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f40165b;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.f40164a = serviceProxy;
            this.f40165b = intent;
        }
    }

    public d() {
        this.f40163a = null;
        this.f40163a = new HashMap();
    }

    public static d a() {
        if (f40162b == null) {
            synchronized (d.class) {
                if (f40162b == null) {
                    f40162b = new d();
                }
            }
        }
        return f40162b;
    }

    public int b() {
        return this.f40163a.size();
    }

    public synchronized a c(String str) {
        return this.f40163a.get(str);
    }

    public synchronized void d(String str, a aVar) {
        this.f40163a.put(str, aVar);
    }

    public synchronized void e(String str) {
        this.f40163a.remove(str);
    }
}
