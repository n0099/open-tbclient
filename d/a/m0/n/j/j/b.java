package d.a.m0.n.j.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.node.Node;
import com.tencent.open.SocialOperation;
import d.a.m0.t.j;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f51952c;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f51954b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f51953a = new a();

    /* loaded from: classes3.dex */
    public static class a extends j {
        public a() {
            super("updatecore_node_host");
        }
    }

    public static b c() {
        if (f51952c == null) {
            synchronized (b.class) {
                if (f51952c == null) {
                    f51952c = new b();
                }
            }
        }
        return f51952c;
    }

    public String a() {
        if (this.f51953a.contains("version")) {
            return this.f51953a.getString("version", "0");
        }
        return d() ? this.f51953a.getString("version", "0") : "0";
    }

    public Long b() {
        return Long.valueOf(this.f51953a.getLong("identity", 0L));
    }

    public synchronized boolean d() {
        if (this.f51954b) {
            return true;
        }
        String C = d.a.m0.t.d.C(AppRuntime.getAppContext(), "config/union-cfg.json");
        HashSet hashSet = null;
        if (TextUtils.isEmpty(C)) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
            C = file.exists() ? d.a.m0.t.d.D(file) : null;
        }
        if (TextUtils.isEmpty(C)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(C);
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
            HashSet hashSet2 = hashSet;
            int optInt2 = jSONObject.optInt("officialNo");
            int optInt3 = jSONObject.optInt("containerNo");
            JSONObject optJSONObject = jSONObject.optJSONObject("confsk");
            long j = 0;
            if (optJSONObject != null) {
                String optString4 = optJSONObject.optString("value");
                long optLong = optJSONObject.optLong("identity");
                if (d.a.m0.n.c.b() != null) {
                    d.a.m0.n.c.b().d(optString4.getBytes());
                }
                j = optLong;
            }
            e(new d.a.m0.n.j.j.a(null, optInt2, optInt3, optString, optString3, String.valueOf(optInt), hashSet2, optString2, Long.valueOf(j)));
            this.f51954b = true;
            return true;
        } catch (JSONException e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public final void e(d.a.m0.n.j.j.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.f51946d) || TextUtils.isEmpty(aVar.f51950h) || TextUtils.isEmpty(aVar.f51948f)) {
            return;
        }
        SharedPreferences.Editor putString = this.f51953a.edit().putString("hostName", aVar.f51946d).putString("schemeHead", aVar.f51950h).putString("shareCallbackUrl", aVar.f51947e).putString("version", aVar.f51948f);
        Set<String> set = aVar.f51949g;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f51949g);
        }
        Long l = aVar.f51951i;
        if (l != null) {
            putString.putLong("identity", l.longValue());
        }
        putString.apply();
    }

    public void f(d.a.m0.n.j.j.a aVar) {
        if (aVar == null) {
            return;
        }
        if (d.a.m0.n.c.f51766a) {
            Log.d(Node.TAG, "update host data version " + aVar.f51948f);
        }
        SharedPreferences.Editor putString = this.f51953a.edit().putString("hostName", aVar.f51946d).putString("schemeHead", aVar.f51950h).putString("shareCallbackUrl", aVar.f51947e).putString("contentType", aVar.f51943a).putInt("containerNo", aVar.f51945c).putInt("officialNo", aVar.f51944b).putString("version", aVar.f51948f);
        Set<String> set = aVar.f51949g;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f51949g);
        }
        putString.apply();
    }
}
