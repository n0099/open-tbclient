package d.a.c.h;

import android.content.Intent;
import com.baidu.adp.plugin.proxy.ServiceProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f42827b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, a> f42828a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ServiceProxy f42829a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f42830b;

        public a(ServiceProxy serviceProxy, Intent intent) {
            this.f42829a = serviceProxy;
            this.f42830b = intent;
        }
    }

    public d() {
        this.f42828a = null;
        this.f42828a = new HashMap();
    }

    public static d a() {
        if (f42827b == null) {
            synchronized (d.class) {
                if (f42827b == null) {
                    f42827b = new d();
                }
            }
        }
        return f42827b;
    }

    public int b() {
        return this.f42828a.size();
    }

    public synchronized a c(String str) {
        return this.f42828a.get(str);
    }

    public synchronized void d(String str, a aVar) {
        this.f42828a.put(str, aVar);
    }

    public synchronized void e(String str) {
        this.f42828a.remove(str);
    }
}
