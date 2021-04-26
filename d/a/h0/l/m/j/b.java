package d.a.h0.l.m.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.node.Node;
import com.tencent.open.SocialOperation;
import d.a.h0.l.f;
import d.a.h0.p.i;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f47280c;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f47282b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f47281a = new a();

    /* loaded from: classes3.dex */
    public static class a extends i {
        public a() {
            super("updatecore_node_host");
        }
    }

    public static b b() {
        if (f47280c == null) {
            synchronized (b.class) {
                if (f47280c == null) {
                    f47280c = new b();
                }
            }
        }
        return f47280c;
    }

    public String a() {
        if (this.f47281a.contains("version")) {
            return this.f47281a.getString("version", "0");
        }
        return c() ? this.f47281a.getString("version", "0") : "0";
    }

    public final synchronized boolean c() {
        if (this.f47282b) {
            return true;
        }
        String q = d.a.h0.p.d.q(AppRuntime.getAppContext(), "config/union-cfg.json");
        HashSet hashSet = null;
        if (TextUtils.isEmpty(q)) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
            q = file.exists() ? d.a.h0.p.d.r(file) : null;
        }
        if (TextUtils.isEmpty(q)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(q);
            String optString = jSONObject.optString("hostName");
            String optString2 = jSONObject.optString("schemeHead");
            String optString3 = jSONObject.optString("shareCallbackUrl");
            int optInt = jSONObject.optInt("version");
            JSONArray optJSONArray = jSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                hashSet = new HashSet();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    hashSet.add(optJSONArray.optString(i2));
                }
            }
            e(optString, optString2, optString3, String.valueOf(optInt), hashSet);
            this.f47282b = true;
            return true;
        } catch (JSONException e2) {
            if (f.f47117a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public void d(d.a.h0.l.m.j.a aVar) {
        if (aVar == null) {
            return;
        }
        if (f.f47117a) {
            Log.d(Node.TAG, "update host data version " + aVar.f47277f);
        }
        SharedPreferences.Editor putString = this.f47281a.edit().putString("hostName", aVar.f47275d).putString("schemeHead", aVar.f47279h).putString("shareCallbackUrl", aVar.f47276e).putString("contentType", aVar.f47272a).putInt("containerNo", aVar.f47274c).putInt("officialNo", aVar.f47273b).putString("version", aVar.f47277f);
        Set<String> set = aVar.f47278g;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f47278g);
        }
        putString.apply();
    }

    public final void e(String str, String str2, String str3, String str4, Set<String> set) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
            return;
        }
        SharedPreferences.Editor putString = this.f47281a.edit().putString("hostName", str).putString("schemeHead", str2).putString("shareCallbackUrl", str3).putString("version", str4);
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, set);
        }
        putString.apply();
    }
}
