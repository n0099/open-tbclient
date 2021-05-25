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
    public static final boolean f43368c = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, JSONObject> f43369a = new LruCache<>(5);

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, JSONObject> f43370b = new LruCache<>(5);

    public final JSONObject a(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null) {
            if (f43368c) {
                Log.e("SwanAppExtInfo", "appInfo is null");
            }
            return null;
        }
        String str = pMSAppInfo.appId;
        String valueOf = String.valueOf(pMSAppInfo.appSign);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
            String d2 = d(str, valueOf);
            JSONObject jSONObject = this.f43369a.get(d2);
            if (jSONObject == null) {
                jSONObject = e.m(b.a(pMSAppInfo));
                this.f43369a.put(d2, jSONObject);
            }
            if (f43368c) {
                Log.d("SwanAppExtInfo", "appId - " + str + " app info' ext - " + jSONObject.toString());
            }
            return jSONObject;
        }
        if (f43368c) {
            Log.e("SwanAppExtInfo", "appId or app sign is empty");
        }
        return null;
    }

    public final JSONObject b(PMSAppInfo pMSAppInfo) {
        JSONObject a2 = a(pMSAppInfo);
        if (a2 == null) {
            if (f43368c) {
                Log.e("SwanAppExtInfo", "appInfoExt is null");
            }
            return null;
        }
        JSONObject optJSONObject = a2.optJSONObject("client");
        if (optJSONObject == null) {
            if (f43368c) {
                Log.e("SwanAppExtInfo", "clientInfo is null");
            }
            return null;
        }
        if (f43368c) {
            Log.d("SwanAppExtInfo", "clientInfo - " + optJSONObject);
        }
        return optJSONObject;
    }

    public final JSONObject c(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null) {
            if (f43368c) {
                Log.e("SwanAppExtInfo", "appInfo is null");
            }
            return null;
        }
        String str = pMSAppInfo.appId;
        String valueOf = String.valueOf(pMSAppInfo.versionCode);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
            String d2 = d(str, valueOf);
            JSONObject jSONObject = this.f43370b.get(d2);
            if (jSONObject == null) {
                jSONObject = e.m(c.f(pMSAppInfo));
                this.f43369a.put(d2, jSONObject);
            }
            if (f43368c) {
                Log.d("SwanAppExtInfo", "appId - " + str + " pkg info' ext - " + jSONObject.toString());
            }
            return jSONObject;
        }
        if (f43368c) {
            Log.e("SwanAppExtInfo", "appId or version code is empty");
        }
        return null;
    }

    public final String d(String str, String str2) {
        return str + "_" + str2;
    }

    public void e() {
        if (f43368c) {
            Log.d("SwanAppExtInfo", "release cache");
        }
        this.f43369a.evictAll();
        this.f43370b.evictAll();
    }
}
