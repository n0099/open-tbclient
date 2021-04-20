package d.b.c.h;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f42702b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a> f42703a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ServiceProxy f42704a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f42705b;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.f42704a = serviceProxy;
            this.f42705b = intent;
        }
    }

    public d() {
        this.f42703a = null;
        this.f42703a = new HashMap();
    }

    public static d a() {
        if (f42702b == null) {
            synchronized (d.class) {
                if (f42702b == null) {
                    f42702b = new d();
                }
            }
        }
        return f42702b;
    }

    public int b() {
        return this.f42703a.size();
    }

    public synchronized a c(String str) {
        return this.f42703a.get(str);
    }

    public synchronized void d(String str, a aVar) {
        this.f42703a.put(str, aVar);
    }

    public synchronized void e(String str) {
        this.f42703a.remove(str);
    }
}
