package d.a.l0.n.j.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.node.Node;
import com.tencent.open.SocialOperation;
import d.a.l0.t.j;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f48170c;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f48172b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f48171a = new a();

    /* loaded from: classes3.dex */
    public static class a extends j {
        public a() {
            super("updatecore_node_host");
        }
    }

    public static b c() {
        if (f48170c == null) {
            synchronized (b.class) {
                if (f48170c == null) {
                    f48170c = new b();
                }
            }
        }
        return f48170c;
    }

    public String a() {
        if (this.f48171a.contains("version")) {
            return this.f48171a.getString("version", "0");
        }
        return d() ? this.f48171a.getString("version", "0") : "0";
    }

    public Long b() {
        return Long.valueOf(this.f48171a.getLong("identity", 0L));
    }

    public synchronized boolean d() {
        if (this.f48172b) {
            return true;
        }
        String C = d.a.l0.t.d.C(AppRuntime.getAppContext(), "config/union-cfg.json");
        HashSet hashSet = null;
        if (TextUtils.isEmpty(C)) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
            C = file.exists() ? d.a.l0.t.d.D(file) : null;
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
                if (d.a.l0.n.c.b() != null) {
                    d.a.l0.n.c.b().d(optString4.getBytes());
                }
                j = optLong;
            }
            e(new d.a.l0.n.j.j.a(null, optInt2, optInt3, optString, optString3, String.valueOf(optInt), hashSet2, optString2, Long.valueOf(j)));
            this.f48172b = true;
            return true;
        } catch (JSONException e2) {
            if (d.a.l0.n.c.f47984a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public final void e(d.a.l0.n.j.j.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.f48164d) || TextUtils.isEmpty(aVar.f48168h) || TextUtils.isEmpty(aVar.f48166f)) {
            return;
        }
        SharedPreferences.Editor putString = this.f48171a.edit().putString("hostName", aVar.f48164d).putString("schemeHead", aVar.f48168h).putString("shareCallbackUrl", aVar.f48165e).putString("version", aVar.f48166f);
        Set<String> set = aVar.f48167g;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f48167g);
        }
        Long l = aVar.f48169i;
        if (l != null) {
            putString.putLong("identity", l.longValue());
        }
        putString.apply();
    }

    public void f(d.a.l0.n.j.j.a aVar) {
        if (aVar == null) {
            return;
        }
        if (d.a.l0.n.c.f47984a) {
            Log.d(Node.TAG, "update host data version " + aVar.f48166f);
        }
        SharedPreferences.Editor putString = this.f48171a.edit().putString("hostName", aVar.f48164d).putString("schemeHead", aVar.f48168h).putString("shareCallbackUrl", aVar.f48165e).putString("contentType", aVar.f48161a).putInt("containerNo", aVar.f48163c).putInt("officialNo", aVar.f48162b).putString("version", aVar.f48166f);
        Set<String> set = aVar.f48167g;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f48167g);
        }
        putString.apply();
    }
}
