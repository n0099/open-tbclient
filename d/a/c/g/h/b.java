package d.a.c.g.h;

import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, e> f42802a;

    static {
        HashMap hashMap = new HashMap();
        f42802a = hashMap;
        hashMap.put(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, new a());
    }

    public static void a(String str, int i2) {
        e eVar = f42802a.get(str);
        if (eVar != null) {
            eVar.b(i2);
        }
    }

    public static void b(String str, int i2, long j) {
        e eVar = f42802a.get(str);
        if (eVar != null) {
            eVar.c(i2, j);
        }
    }

    public static void c(String str, int i2, int i3) {
        e eVar = f42802a.get(str);
        if (eVar != null) {
            eVar.d(i2, i3);
        }
    }

    public static void d(String str, int i2, int i3) {
        e eVar = f42802a.get(str);
        if (eVar != null) {
            eVar.e(i2, i3);
        }
    }
}
