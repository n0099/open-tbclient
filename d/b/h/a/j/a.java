package d.b.h.a.j;

import com.baidu.permissionhelper.app.ActivityCompat;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f43775b = new a();

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> f43776a = new HashMap();

    public static a b() {
        return f43775b;
    }

    public void a(int i, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        if (this.f43776a == null) {
            return;
        }
        synchronized (a.class) {
            if (this.f43776a.containsKey(Integer.valueOf(i))) {
                this.f43776a.remove(Integer.valueOf(i));
            }
            this.f43776a.put(Integer.valueOf(i), onRequestPermissionsResultCallback);
        }
    }

    public ActivityCompat.OnRequestPermissionsResultCallback c(int i) {
        Map<Integer, ActivityCompat.OnRequestPermissionsResultCallback> map = this.f43776a;
        if (map == null || !map.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.f43776a.get(Integer.valueOf(i));
    }

    public void d(int i) {
        synchronized (a.class) {
            if (this.f43776a != null && this.f43776a.containsKey(Integer.valueOf(i))) {
                this.f43776a.remove(Integer.valueOf(i));
            }
        }
    }
}
