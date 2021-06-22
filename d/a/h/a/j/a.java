package d.a.h.a.j;

import com.baidu.permissionhelper.app.ActivityCompat;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f43707b = new a();

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> f43708a = new HashMap();

    public static a b() {
        return f43707b;
    }

    public void a(int i2, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        if (this.f43708a == null) {
            return;
        }
        synchronized (a.class) {
            if (this.f43708a.containsKey(Integer.valueOf(i2))) {
                this.f43708a.remove(Integer.valueOf(i2));
            }
            this.f43708a.put(Integer.valueOf(i2), onRequestPermissionsResultCallback);
        }
    }

    public ActivityCompat.OnRequestPermissionsResultCallback c(int i2) {
        Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> map = this.f43708a;
        if (map == null || !map.containsKey(Integer.valueOf(i2))) {
            return null;
        }
        return this.f43708a.get(Integer.valueOf(i2));
    }

    public void d(int i2) {
        synchronized (a.class) {
            if (this.f43708a != null && this.f43708a.containsKey(Integer.valueOf(i2))) {
                this.f43708a.remove(Integer.valueOf(i2));
            }
        }
    }
}
