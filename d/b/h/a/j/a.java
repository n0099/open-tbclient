package d.b.h.a.j;

import com.baidu.permissionhelper.app.ActivityCompat;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f49848b = new a();

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> f49849a = new HashMap();

    public static a b() {
        return f49848b;
    }

    public void a(int i, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        if (this.f49849a == null) {
            return;
        }
        synchronized (a.class) {
            if (this.f49849a.containsKey(Integer.valueOf(i))) {
                this.f49849a.remove(Integer.valueOf(i));
            }
            this.f49849a.put(Integer.valueOf(i), onRequestPermissionsResultCallback);
        }
    }

    public ActivityCompat.OnRequestPermissionsResultCallback c(int i) {
        Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> map = this.f49849a;
        if (map == null || !map.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.f49849a.get(Integer.valueOf(i));
    }

    public void d(int i) {
        synchronized (a.class) {
            if (this.f49849a != null && this.f49849a.containsKey(Integer.valueOf(i))) {
                this.f49849a.remove(Integer.valueOf(i));
            }
        }
    }
}
