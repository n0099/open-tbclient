package d.b.c.g.h;

import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, e> f42678a;

    static {
        HashMap hashMap = new HashMap();
        f42678a = hashMap;
        hashMap.put(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, new a());
    }

    public static void a(String str, int i) {
        e eVar = f42678a.get(str);
        if (eVar != null) {
            eVar.b(i);
        }
    }

    public static void b(String str, int i, long j) {
        e eVar = f42678a.get(str);
        if (eVar != null) {
            eVar.c(i, j);
        }
    }

    public static void c(String str, int i, int i2) {
        e eVar = f42678a.get(str);
        if (eVar != null) {
            eVar.d(i, i2);
        }
    }

    public static void d(String str, int i, int i2) {
        e eVar = f42678a.get(str);
        if (eVar != null) {
            eVar.e(i, i2);
        }
    }
}
