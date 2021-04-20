package d.b.g0.l.m.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.node.Node;
import com.tencent.open.SocialOperation;
import d.b.g0.l.f;
import d.b.g0.p.i;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f49437c;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f49439b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f49438a = new a();

    /* loaded from: classes3.dex */
    public static class a extends i {
        public a() {
            super("updatecore_node_host");
        }
    }

    public static b b() {
        if (f49437c == null) {
            synchronized (b.class) {
                if (f49437c == null) {
                    f49437c = new b();
                }
            }
        }
        return f49437c;
    }

    public String a() {
        if (this.f49438a.contains("version")) {
            return this.f49438a.getString("version", "0");
        }
        return c() ? this.f49438a.getString("version", "0") : "0";
    }

    public final synchronized boolean c() {
        if (this.f49439b) {
            return true;
        }
        String q = d.b.g0.p.d.q(AppRuntime.getAppContext(), "config/union-cfg.json");
        HashSet hashSet = null;
        if (TextUtils.isEmpty(q)) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
            q = file.exists() ? d.b.g0.p.d.r(file) : null;
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
                for (int i = 0; i < optJSONArray.length(); i++) {
                    hashSet.add(optJSONArray.optString(i));
                }
            }
            e(optString, optString2, optString3, String.valueOf(optInt), hashSet);
            this.f49439b = true;
            return true;
        } catch (JSONException e2) {
            if (f.f49281a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public void d(d.b.g0.l.m.j.a aVar) {
        if (aVar == null) {
            return;
        }
        if (f.f49281a) {
            Log.d(Node.TAG, "update host data version " + aVar.f49434f);
        }
        SharedPreferences.Editor putString = this.f49438a.edit().putString("hostName", aVar.f49432d).putString("schemeHead", aVar.f49436h).putString("shareCallbackUrl", aVar.f49433e).putString("contentType", aVar.f49429a).putInt("containerNo", aVar.f49431c).putInt("officialNo", aVar.f49430b).putString("version", aVar.f49434f);
        Set<String> set = aVar.f49435g;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f49435g);
        }
        putString.apply();
    }

    public final void e(String str, String str2, String str3, String str4, Set<String> set) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
            return;
        }
        SharedPreferences.Editor putString = this.f49438a.edit().putString("hostName", str).putString("schemeHead", str2).putString("shareCallbackUrl", str3).putString("version", str4);
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, set);
        }
        putString.apply();
    }
}
