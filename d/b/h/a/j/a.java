package d.b.h.a.j;

import com.baidu.permissionhelper.app.ActivityCompat;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f49456b = new a();

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> f49457a = new HashMap();

    public static a b() {
        return f49456b;
    }

    public void a(int i, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        if (this.f49457a == null) {
            return;
        }
        synchronized (a.class) {
            if (this.f49457a.containsKey(Integer.valueOf(i))) {
                this.f49457a.remove(Integer.valueOf(i));
            }
            this.f49457a.put(Integer.valueOf(i), onRequestPermissionsResultCallback);
        }
    }

    public ActivityCompat.OnRequestPermissionsResultCallback c(int i) {
        Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> map = this.f49457a;
        if (map == null || !map.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.f49457a.get(Integer.valueOf(i));
    }

    public void d(int i) {
        synchronized (a.class) {
            if (this.f49457a != null && this.f49457a.containsKey(Integer.valueOf(i))) {
                this.f49457a.remove(Integer.valueOf(i));
            }
        }
    }
}
