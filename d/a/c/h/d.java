package d.a.c.h;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f39407b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a> f39408a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ServiceProxy f39409a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f39410b;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.f39409a = serviceProxy;
            this.f39410b = intent;
        }
    }

    public d() {
        this.f39408a = null;
        this.f39408a = new HashMap();
    }

    public static d a() {
        if (f39407b == null) {
            synchronized (d.class) {
                if (f39407b == null) {
                    f39407b = new d();
                }
            }
        }
        return f39407b;
    }

    public int b() {
        return this.f39408a.size();
    }

    public synchronized a c(String str) {
        return this.f39408a.get(str);
    }

    public synchronized void d(String str, a aVar) {
        this.f39408a.put(str, aVar);
    }

    public synchronized void e(String str) {
        this.f39408a.remove(str);
    }
}
