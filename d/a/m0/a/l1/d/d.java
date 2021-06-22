package d.a.m0.a.l1.d;

import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.a.m0.a.l1.d.a {

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f47157a = new d();
    }

    public static d f() {
        return b.f47157a;
    }

    public boolean g(PMSAppInfo pMSAppInfo) {
        JSONObject c2 = c(pMSAppInfo);
        if (c2 == null || c2.length() <= 0) {
            return false;
        }
        boolean optBoolean = c2.optBoolean("is_opti");
        if (d.a.m0.a.l1.d.a.f47152c) {
            Log.d("SwanAppExtInfo", "is opt pkg  - " + optBoolean);
        }
        return optBoolean;
    }

    public boolean h(PMSAppInfo pMSAppInfo) {
        boolean z;
        JSONObject b2 = b(pMSAppInfo);
        if (b2 != null && b2.has(PrefetchEvent.MODULE)) {
            z = b2.optBoolean(PrefetchEvent.MODULE);
        } else {
            JSONObject a2 = a(pMSAppInfo);
            z = a2 != null && a2.optBoolean(PrefetchEvent.MODULE);
        }
        if (d.a.m0.a.l1.d.a.f47152c) {
            Log.d("SwanAppExtInfo", "is prefetch on - " + z);
        }
        return z;
    }

    public JSONObject i(PMSAppInfo pMSAppInfo) {
        JSONObject b2 = b(pMSAppInfo);
        if (b2 == null || b2.length() <= 0) {
            return null;
        }
        return b2.optJSONObject("topPages");
    }

    public d() {
    }
}
