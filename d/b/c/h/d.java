package d.b.c.h;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f42942b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a> f42943a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ServiceProxy f42944a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f42945b;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.f42944a = serviceProxy;
            this.f42945b = intent;
        }
    }

    public d() {
        this.f42943a = null;
        this.f42943a = new HashMap();
    }

    public static d a() {
        if (f42942b == null) {
            synchronized (d.class) {
                if (f42942b == null) {
                    f42942b = new d();
                }
            }
        }
        return f42942b;
    }

    public int b() {
        return this.f42943a.size();
    }

    public synchronized a c(String str) {
        return this.f42943a.get(str);
    }

    public synchronized void d(String str, a aVar) {
        this.f42943a.put(str, aVar);
    }

    public synchronized void e(String str) {
        this.f42943a.remove(str);
    }
}
