package d.a.l0.a.l1.d;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.k;
import d.a.l0.n.o.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47044c = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, JSONObject> f47045a = new LruCache<>(5);

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, JSONObject> f47046b = new LruCache<>(5);

    public final JSONObject a(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null) {
            if (f47044c) {
                Log.e("SwanAppExtInfo", "appInfo is null");
            }
            return null;
        }
        String str = pMSAppInfo.appId;
        String valueOf = String.valueOf(pMSAppInfo.appSign);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
            String d2 = d(str, valueOf);
            JSONObject jSONObject = this.f47045a.get(d2);
            if (jSONObject == null) {
                jSONObject = e.m(b.a(pMSAppInfo));
                this.f47045a.put(d2, jSONObject);
            }
            if (f47044c) {
                Log.d("SwanAppExtInfo", "appId - " + str + " app info' ext - " + jSONObject.toString());
            }
            return jSONObject;
        }
        if (f47044c) {
            Log.e("SwanAppExtInfo", "appId or app sign is empty");
        }
        return null;
    }

    public final JSONObject b(PMSAppInfo pMSAppInfo) {
        JSONObject a2 = a(pMSAppInfo);
        if (a2 == null) {
            if (f47044c) {
                Log.e("SwanAppExtInfo", "appInfoExt is null");
            }
            return null;
        }
        JSONObject optJSONObject = a2.optJSONObject("client");
        if (optJSONObject == null) {
            if (f47044c) {
                Log.e("SwanAppExtInfo", "clientInfo is null");
            }
            return null;
        }
        if (f47044c) {
            Log.d("SwanAppExtInfo", "clientInfo - " + optJSONObject);
        }
        return optJSONObject;
    }

    public final JSONObject c(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null) {
            if (f47044c) {
                Log.e("SwanAppExtInfo", "appInfo is null");
            }
            return null;
        }
        String str = pMSAppInfo.appId;
        String valueOf = String.valueOf(pMSAppInfo.versionCode);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
            String d2 = d(str, valueOf);
            JSONObject jSONObject = this.f47046b.get(d2);
            if (jSONObject == null) {
                jSONObject = e.m(c.f(pMSAppInfo));
                this.f47045a.put(d2, jSONObject);
            }
            if (f47044c) {
                Log.d("SwanAppExtInfo", "appId - " + str + " pkg info' ext - " + jSONObject.toString());
            }
            return jSONObject;
        }
        if (f47044c) {
            Log.e("SwanAppExtInfo", "appId or version code is empty");
        }
        return null;
    }

    public final String d(String str, String str2) {
        return str + "_" + str2;
    }

    public void e() {
        if (f47044c) {
            Log.d("SwanAppExtInfo", "release cache");
        }
        this.f47045a.evictAll();
        this.f47046b.evictAll();
    }
}
