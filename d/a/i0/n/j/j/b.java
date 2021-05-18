package d.a.i0.n.j.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.node.Node;
import com.tencent.open.SocialOperation;
import d.a.i0.t.j;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f47994c;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f47996b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f47995a = new a();

    /* loaded from: classes3.dex */
    public static class a extends j {
        public a() {
            super("updatecore_node_host");
        }
    }

    public static b c() {
        if (f47994c == null) {
            synchronized (b.class) {
                if (f47994c == null) {
                    f47994c = new b();
                }
            }
        }
        return f47994c;
    }

    public String a() {
        if (this.f47995a.contains("version")) {
            return this.f47995a.getString("version", "0");
        }
        return d() ? this.f47995a.getString("version", "0") : "0";
    }

    public Long b() {
        return Long.valueOf(this.f47995a.getLong("identity", 0L));
    }

    public synchronized boolean d() {
        if (this.f47996b) {
            return true;
        }
        String C = d.a.i0.t.d.C(AppRuntime.getAppContext(), "config/union-cfg.json");
        HashSet hashSet = null;
        if (TextUtils.isEmpty(C)) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
            C = file.exists() ? d.a.i0.t.d.D(file) : null;
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
                if (d.a.i0.n.c.b() != null) {
                    d.a.i0.n.c.b().d(optString4.getBytes());
                }
                j = optLong;
            }
            e(new d.a.i0.n.j.j.a(null, optInt2, optInt3, optString, optString3, String.valueOf(optInt), hashSet2, optString2, Long.valueOf(j)));
            this.f47996b = true;
            return true;
        } catch (JSONException e2) {
            if (d.a.i0.n.c.f47808a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public final void e(d.a.i0.n.j.j.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.f47988d) || TextUtils.isEmpty(aVar.f47992h) || TextUtils.isEmpty(aVar.f47990f)) {
            return;
        }
        SharedPreferences.Editor putString = this.f47995a.edit().putString("hostName", aVar.f47988d).putString("schemeHead", aVar.f47992h).putString("shareCallbackUrl", aVar.f47989e).putString("version", aVar.f47990f);
        Set<String> set = aVar.f47991g;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f47991g);
        }
        Long l = aVar.f47993i;
        if (l != null) {
            putString.putLong("identity", l.longValue());
        }
        putString.apply();
    }

    public void f(d.a.i0.n.j.j.a aVar) {
        if (aVar == null) {
            return;
        }
        if (d.a.i0.n.c.f47808a) {
            Log.d(Node.TAG, "update host data version " + aVar.f47990f);
        }
        SharedPreferences.Editor putString = this.f47995a.edit().putString("hostName", aVar.f47988d).putString("schemeHead", aVar.f47992h).putString("shareCallbackUrl", aVar.f47989e).putString("contentType", aVar.f47985a).putInt("containerNo", aVar.f47987c).putInt("officialNo", aVar.f47986b).putString("version", aVar.f47990f);
        Set<String> set = aVar.f47991g;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f47991g);
        }
        putString.apply();
    }
}
