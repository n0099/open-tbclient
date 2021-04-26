package d.a.h.a.j;

import com.baidu.permissionhelper.app.ActivityCompat;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f41032b = new a();

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> f41033a = new HashMap();

    public static a b() {
        return f41032b;
    }

    public void a(int i2, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        if (this.f41033a == null) {
            return;
        }
        synchronized (a.class) {
            if (this.f41033a.containsKey(Integer.valueOf(i2))) {
                this.f41033a.remove(Integer.valueOf(i2));
            }
            this.f41033a.put(Integer.valueOf(i2), onRequestPermissionsResultCallback);
        }
    }

    public ActivityCompat.OnRequestPermissionsResultCallback c(int i2) {
        Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> map = this.f41033a;
        if (map == null || !map.containsKey(Integer.valueOf(i2))) {
            return null;
        }
        return this.f41033a.get(Integer.valueOf(i2));
    }

    public void d(int i2) {
        synchronized (a.class) {
            if (this.f41033a != null && this.f41033a.containsKey(Integer.valueOf(i2))) {
                this.f41033a.remove(Integer.valueOf(i2));
            }
        }
    }
}
