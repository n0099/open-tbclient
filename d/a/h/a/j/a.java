package d.a.h.a.j;

import com.baidu.permissionhelper.app.ActivityCompat;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f39961b = new a();

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> f39962a = new HashMap();

    public static a b() {
        return f39961b;
    }

    public void a(int i2, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        if (this.f39962a == null) {
            return;
        }
        synchronized (a.class) {
            if (this.f39962a.containsKey(Integer.valueOf(i2))) {
                this.f39962a.remove(Integer.valueOf(i2));
            }
            this.f39962a.put(Integer.valueOf(i2), onRequestPermissionsResultCallback);
        }
    }

    public ActivityCompat.OnRequestPermissionsResultCallback c(int i2) {
        Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> map = this.f39962a;
        if (map == null || !map.containsKey(Integer.valueOf(i2))) {
            return null;
        }
        return this.f39962a.get(Integer.valueOf(i2));
    }

    public void d(int i2) {
        synchronized (a.class) {
            if (this.f39962a != null && this.f39962a.containsKey(Integer.valueOf(i2))) {
                this.f39962a.remove(Integer.valueOf(i2));
            }
        }
    }
}
